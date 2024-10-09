
import React from 'react';
import { Link } from 'react-router-dom';
import backgroundImage from '../assets/background.png';

const Home = () => {
    return (
        <div style={{
            backgroundImage: `url(${backgroundImage})`,
            backgroundSize: '100%', 
            backgroundRepeat: 'no-repeat', 
            backgroundPosition: 'center',
            height: '100vh',
            color: '#fff',
            display: 'flex',
            flexDirection: 'column',
            justifyContent: 'center',
            alignItems: 'center',
            textAlign: 'center',
            padding: '20px',
            boxShadow: '0 0 15px rgba(0, 0, 0, 0.5)',
        }}>
            <h1 style={{ fontSize: '3em', fontWeight: 'bold', textShadow: '2px 2px 4px rgba(0, 0, 0, 0.7)' }}>
                Welcome to the Grievance Management System
            </h1>
            <p style={{ fontSize: '1.5em', margin: '20px 0', textShadow: '1px 1px 2px rgba(0, 0, 0, 0.5)' }}>
                Please choose an option below:
            </p>
            <div>
                <Link to="/login" style={{
                    margin: '10px',
                    fontSize: '1.2em',
                    padding: '10px 20px',
                    backgroundColor: 'rgba(255, 255, 255, 0.8)',
                    color: '#333',
                    borderRadius: '5px',
                    textDecoration: 'none',
                    transition: 'background-color 0.3s',
                    boxShadow: '0 2px 5px rgba(0, 0, 0, 0.3)',
                }}>
                    Login
                </Link>
                <Link to="/register" style={{
                    margin: '10px',
                    fontSize: '1.2em',
                    padding: '10px 20px',
                    backgroundColor: 'rgba(255, 255, 255, 0.8)',
                    color: '#333',
                    borderRadius: '5px',
                    textDecoration: 'none',
                    transition: 'background-color 0.3s',
                    boxShadow: '0 2px 5px rgba(0, 0, 0, 0.3)',
                }}>
                    Register
                </Link>
            </div>
        </div>
    );
};

export default Home;
