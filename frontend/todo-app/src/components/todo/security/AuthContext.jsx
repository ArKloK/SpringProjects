import { createContext, useContext, useMemo, useState } from "react";
import PropTypes from 'prop-types';

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

    function login(username, password) {
        if (username === 'carlos' && password === 'carlos') {
            setIsAuthenticated(true);
            return true;
        } else {
            setIsAuthenticated(false);
            return false;
        }
    }

    function logout() {
        setIsAuthenticated(false);
    }

    const statesToShare = useMemo(() => ({ isAuthenticated, login, logout }), [isAuthenticated, login, logout])
    
    return (
        <AuthContext.Provider value={statesToShare}>
            {children}
        </AuthContext.Provider>
    )
}

AuthProvider.propTypes = {
    children: PropTypes.node,
};