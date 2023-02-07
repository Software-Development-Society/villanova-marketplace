import { createContext, useState } from "react";

const AuthContext = createContext({
    //this will be the jwt token
    token: '',
    //this should be updated to reflect our app
    userData:{
        userId: '',
        name: '',
        email: '',
    },
    isLoggedIn: false,
    login: (token, userData) => {},
    logout: () => {}
});

export const AuthContextProvider = (props) => {
    const initialToken = localStorage.getItem('token');
    const initialUserData = localStorage.getItem('userData');
    const [token, setToken] = useState(initialToken);
    const [userData, setUserData] = useState(initialUserData ? JSON.parse(initialUserData) : null);
    
    const userIsLoggedIn = !!token;
    
    const loginHandler = (token, userData) => {
        setToken(token);
        setUserData(userData);
        localStorage.setItem('token', token);
        localStorage.setItem('userData', JSON.stringify(userData));
    };
    
    const logoutHandler = () => {
        setToken(null);
        setUserData(null);
        localStorage.clear();
    }
    
    const contextValue = {
        token: token,
        userData: userData,
        isLoggedIn: userIsLoggedIn,
        login: loginHandler,
        logout: logoutHandler
    }
    
    return <AuthContext.Provider value={contextValue}>
        {props.children}
    </AuthContext.Provider>
}

export default AuthContext;