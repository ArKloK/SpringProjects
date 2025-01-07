import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { useAuth } from './security/AuthContext';

export default function LoginComponent() {

    const [username, setUsername] = useState('carlos');
    const [password, setPassword] = useState('carlos');
    const [showErrorMessage, setShowErrorMessage] = useState(false);
    const navigate = useNavigate();
    const authContext = useAuth();

    function handleUsernameChange(event) {
        setUsername(event.target.value);
    }

    function handlePasswordChange(event) {
        setPassword(event.target.value);
    }

    async function handleSubmit() {
        if (await authContext.login(username, password)) {
            navigate(`/welcome/${username}`);
        } else {
            setShowErrorMessage(true);
        }
    }

    return (
        <div className="LoginComponent">
            <h1>Login</h1>
            <div className="LoginForm">
                <div>
                    <label htmlFor="username">
                        User Name: <input type="text" id="username" name="username" autoComplete='username' defaultValue={username} onChange={handleUsernameChange} />
                    </label>
                </div>
                <div>
                    <label htmlFor="password">
                        Password: <input type="password" id="password" name="password" autoComplete='new-password' defaultValue={password} onChange={handlePasswordChange} />
                    </label>
                </div>
                <button type="button" name="Login" onClick={handleSubmit}>Login</button>
                {/* Only prints te div if both variables are true */}
                {showErrorMessage && <div className='errorMessage'>Login Failed</div>}
            </div>
        </div>
    );
}