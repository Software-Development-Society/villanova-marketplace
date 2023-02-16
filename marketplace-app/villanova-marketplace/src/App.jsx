import { useContext, useState } from 'react'
import reactLogo from './assets/react.svg'
import './App.css'
import AuthContext from './context/auth-context';
import Login from './pages/Login/Login';
import { Route, Routes } from 'react-router-dom';
import TestComponent from './components/TestComponent/TestComponet';
import FormBox from './components/Form/FormBox/FormBox';

function App() {
  //This dictates whether or not the user is logged in. 
  //Also holds stored info in browser for the duration of the session.
  const authCtx = useContext(AuthContext);

  return (
    <div className="App">
        <Routes>
          <Route path='/' element={authCtx.isLoggedIn ? <h1>You are logged in</h1> : <h1>You are not logged in</h1>} />
          <Route path='/login' element={<Login></Login>} />
        </Routes>
        <TestComponent></TestComponent>
        <FormBox title='form1'></FormBox>
        <FormBox title='form2'></FormBox>
        
    </div>
  )
}

export default App;
