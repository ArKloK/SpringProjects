import { createContext, useContext, useMemo, useState } from "react";
import PropTypes from 'prop-types';
import { apiClient } from "../api/ApiClient";
import {executeJWTAuthenticationService } from "../api/AuthenticationApiService";

//1: Create a context
export const AuthContext = createContext()

//4: Create a custom hook to use the context
export const useAuth = () => {
    return useContext(AuthContext)
}

//2: Share the created context with other components

export default function AuthProvider({ children }) {

    //3: Put some state in the context
    const [isAuthenticated, setIsAuthenticated] = useState(false)

    const [username, setUsername] = useState(null)

    const [token, setToken] = useState(null)

    async function login(username, password) {

        try {
            const response = await executeJWTAuthenticationService(username, password);

            if (response.status === 200) {
                const jwtToken = 'Bearer ' + response.data.token;
                setIsAuthenticated(true);
                setUsername(username);
                setToken(jwtToken);

                apiClient.interceptors.request.use(
                    (config) => {
                        console.log("interceptor - basic auth");
                        config.headers.Authorization = jwtToken;
                        return config;
                    }
                );

                return true;
            } else {
                logout();
                return false;
            }
        } catch (error) {
            logout();
            return false;
        }

    }

    function logout() {
        setIsAuthenticated(false);
        setUsername(null);
        setToken(null);
    }

    const statesToShare = useMemo(() => ({ isAuthenticated, login, logout, username, token }), [isAuthenticated, login, logout, username, token])

    return (
        <AuthContext.Provider value={statesToShare}>
            {children}
        </AuthContext.Provider>
    )
}

AuthProvider.propTypes = {
    children: PropTypes.node,
};
