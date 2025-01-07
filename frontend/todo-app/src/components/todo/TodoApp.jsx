import { BrowserRouter, Navigate, Route, Routes } from 'react-router-dom';
import AuthProvider, { useAuth } from './security/AuthContext';
import PropTypes from 'prop-types';

import LoginComponent from './LoginComponent';
import WelcomeComponent from './WelcomeComponent';
import LogoutComponent from './LogoutComponent';
import FooterComponent from './FooterComponent';
import HeaderComponent from './HeaderComponent';
import ErrorComponent from './ErrorComponent';
import ListTodosComponent from './ListTodosComponent';
import TodoComponent from './TodoComponent';
import './TodoApp.css';

function AutenticatedRoute({ children }) {

    const authContext = useAuth();

    if (authContext.isAuthenticated) {
        return children;
    } else {
        return <Navigate to="/login" />
    }
}
AutenticatedRoute.propTypes = {
    children: PropTypes.node,
};
export default function TodoApp() {
    return (
        <div className="TodoApp">

            <AuthProvider>
                <BrowserRouter>
                    <HeaderComponent />
                    <Routes>
                        <Route path="/login" element={<LoginComponent />} />
                        <Route path="/welcome/:username" element={
                            <AutenticatedRoute>
                                <WelcomeComponent />
                            </AutenticatedRoute>
                        } />
                        <Route path="/todos" element={
                            <AutenticatedRoute>
                                <ListTodosComponent />
                            </AutenticatedRoute>
                        } />
                        <Route path="/todo/:id" element={
                            <AutenticatedRoute>
                                <TodoComponent />
                            </AutenticatedRoute>
                        } />
                        <Route path="/logout" element={
                            <AutenticatedRoute>
                                <LogoutComponent />
                            </AutenticatedRoute>
                        } />

                        <Route path="*" element={<ErrorComponent />} />
                    </Routes>
                    <FooterComponent />
                </BrowserRouter>
            </AuthProvider>

        </div>
    );
}