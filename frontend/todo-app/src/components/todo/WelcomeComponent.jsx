import { useParams, Link } from 'react-router-dom';
import {retrieveHelloWorldPath } from './api/HelloWorldApiService';
import { useState } from 'react';
import { useAuth } from './security/AuthContext';

export default function WelcomeComponent() {

    const { username } = useParams();

    const [message, setMessage] = useState('');

    const authContext = useAuth()
    const token = authContext.token

    function callHelloWorldRestApi() {
        //axios
        retrieveHelloWorldPath("Carlos2", token).then(
            (response) => successfulResponseBean(response)
        ).catch(
            (error) => errorResponse(error)
        ).finally(
            () => console.log('finally')
        );
    }

    function successfulResponseBean(response) {
        console.log(response);
        setMessage(response.data.message);
    }

    function errorResponse(error) {
        console.log(error);
    }

    return (
        <div className="WelcomeComponent">
            <h1>Welcome {username}</h1>
            <div>
                Your todos: <Link to="/todos">todos</Link>
            </div>
            <div>
                <button className="btn btn-success m-5" type="button" onClick={callHelloWorldRestApi}>Call Hello World Path</button>
            </div>
            <div className="text-info">
                {message}
            </div>
        </div>

    );
}