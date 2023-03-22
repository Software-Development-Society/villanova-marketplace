import { useContext, useState } from 'react'
import reactLogo from './assets/react.svg'
import './App.css'
import AuthContext from './context/auth-context';
import Login from './pages/Login/Login';
import { Route, Routes } from 'react-router-dom';
import Navbar from './components/Navbar/Navbar';


function App() {
  //This dictates whether or not the user is logged in. 
  //Also holds stored info in browser for the duration of the session.
  const authCtx = useContext(AuthContext);

  return (
    <div className="App">
        <Navbar />
        
    </div>
  )
}

export default App;
