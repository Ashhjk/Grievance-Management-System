
import React, { useEffect, useState } from 'react';
import axios from 'axios';
import './Styles/UserDashboard.css'; 

const UserDashboard = () => {
    const [grievances, setGrievances] = useState([]);
    const [description, setDescription] = useState('');
    const [complaint, setComplaint] = useState(''); 
    const [consumerName, setConsumerName] = useState(''); 
    const [message, setMessage] = useState('');
    
     
     useEffect(() => {
        if (consumerName) {
            fetchGrievances(consumerName);
        }
    }, [consumerName]);
    
    const fetchGrievances = async (consumer) => {
        try {
            const response = await axios.get(`http://localhost:8080/api/grievances/find?consumerName=${consumer}`); // Updated API endpoint
            setGrievances(response.data);
        } catch (error) {
            console.error('Error fetching grievances:', error);
            setMessage('Failed to fetch grievances.');
        }
    };

    const handleCreateGrievance = async (e) => {
        e.preventDefault();
        try {
            const newGrievance = { description, complaint, consumerName, status: 'submitted' }; // Use complaint for the backend
            await axios.post('http://localhost:8080/api/grievances/create', newGrievance);

            // Reset form fields and fetch updated grievances
            setDescription('');
            setComplaint(''); // Reset complaint
            setMessage('Grievance created successfully.');
            fetchGrievances(consumerName); // Fetch grievances for the provided consumerName
        } catch (error) {
            console.error('Error creating grievance:', error);
            setMessage('Failed to create grievance.');
        }
    };

    return (
        <div className="user-dashboard">
            <h2>User Dashboard</h2>

            {/* Grievance Creation Form */}
            <form onSubmit={handleCreateGrievance} className="grievance-form">
                <h3>Create Grievance</h3>
                <div className="form-group">
                    <label htmlFor="consumerName">Consumer Name:</label>
                    <input
                        type="text"
                        id="consumerName" // Updated input ID
                        className="form-control"
                        value={consumerName} // Updated state variable
                        onChange={(e) => setConsumerName(e.target.value)} // Updated state setter
                        required
                    />
                </div>
                <div className="form-group">
                    <label htmlFor="description">Description:</label>
                    <textarea
                        id="description"
                        className="form-control"
                        value={description}
                        onChange={(e) => setDescription(e.target.value)}
                        required
                    />
                </div>
                <div className="form-group">
                    <label htmlFor="product">Product:</label>
                    <select
                        id="complaint" // Updated input ID
                        className="form-control"
                        value={complaint} // Updated state variable
                        onChange={(e) => setComplaint(e.target.value)} // Updated state setter
                        required
                    >
                        <option value="">Select Product</option>
                        <option value="television">Television</option>
                        <option value="airconditioner">Airconditioner</option>
                        <option value="mixer grinder">Mixer Grinder</option>
                        <option value="oven">Microwave Oven</option>
                    </select>
                </div>
                <button type="submit" className="btn btn-primary">Submit Grievance</button>
            </form>

            {message && <div className="alert alert-info mt-3">{message}</div>}

            {/* Grievance List */}
            <h3>My Grievances</h3>
            {grievances.length > 0 ? (
                <ul className="grievance-list">
                    {grievances.map((grievance) => (
                        <li key={grievance.id} className="grievance-item">
                            <h4>{grievance.description}</h4>
                            <p>
                                Product: {grievance.complaint} | Status: {grievance.status}
                            </p>
                        </li>
                    ))}
                </ul>
             ) : (
                <p>No grievances found.</p>
            )}
        </div>
    );
};

export default UserDashboard;
