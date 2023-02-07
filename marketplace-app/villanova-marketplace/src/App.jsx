import { useContext, useState } from 'react'
import reactLogo from './assets/react.svg'
import './App.css'
import AuthContext from './context/auth-context';
import Login from './pages/Login/Login';

function App() {
  //This dictates whether or not the user is logged in. 
  //Also holds stored info in browser for the duration of the session.
  const authCtx = useContext(AuthContext);

  return (
    <div className="App">
      {authCtx.isLoggedIn ? <h1>You are logged in</h1> : <h1>You are not logged in</h1>}
      <Login></Login>
    </div>
  )
}

export default App;
