import { useContext, useEffect, useRef, useState } from "react";
import { Triangle } from "react-loader-spinner";
import { useNavigate, useSearchParams } from "react-router-dom";
import { MicrosoftLoginButton } from "react-social-login-buttons";
import AuthContext from "../../context/auth-context";
import SignUpPage from "../../components/SignUpPage/SignUpPage.jsx";

const Login = (props) =>{
    const [isLoading, setIsLoading] = useState(false);

    const [isSignUpModalOpen, setIsSignUpModalOpen] = useState(false);

    const openSignUpModal = () => {
        setIsSignUpModalOpen(true);
    }
    
    const loginHandler = () =>{
        setIsLoading(true);
        fetch('http://localhost:5000/auth/test').then(async response =>{
            try {
                const text = await response.text()
                if(text === "Good"){
                    //console.log("Good");
                    window.location = ('http://localhost:5000/auth/login');
                }
            } catch (error) {
                console.log(error);
                setError(true);
                setIsLoading(false);
            }
        }).catch(error => {
            console.log(error);
            setError(true);
            setIsLoading(false);
        })
    }
    const [failedAuth, setFailedAuth] = useState(false);
    const [error, setError] = useState(false);
    
    
    const [tokenParams] = useSearchParams();
    
    const authCtx = useRef(useContext(AuthContext));
    const navigate = useRef(useNavigate());
    const [contextHolder, setContextHolder] = useState(authCtx.current.userData);
    
    useEffect(() => {
        if(tokenParams.get("failed")){
            setFailedAuth(true);
        }
    }, [tokenParams]);
    useEffect(() => {
        let token = tokenParams.get("token");
        if(token){
            fetch('http://localhost:5000/auth/verify', {
                headers:{
                    'Authorization': "Bearer " + token
                }
            }).then(response => {
                //console.log(response.status)
                if(response.status === 500 || response.status === 401){
                    navigate.current('/login');
                    setError(true);
                    setIsLoading(false);
                    return
                } 
                setError(false);
                response.json().then(responseJson =>{
                    let firstTime = tokenParams.get("firsttime");
                    //console.log(firstTime);
                    //console.log(responseJson);
                    if(responseJson.email){
                        const token = responseJson.token;
                        const userData = {
                            userId: responseJson.userId, 
                            email: responseJson.email, 
                            name:responseJson.name,
                            classYear: responseJson.classYear,
                            major: responseJson.major,
                            wishList: responseJson.wishList,
                            registrationComplete: responseJson.registrationComplete
                        };
                        console.log(userData, "here")
                        authCtx.current.login(token, userData);
                        setContextHolder(authCtx.current.userData);
                        navigate.current('/login');
                        // if(firstTime){
                        //     navigate.current('/dashboard?f=true');
                        // } else {
                        //     navigate.current('/dashboard');
                        // }
                        setIsLoading(false);
                    }
                })
            }).catch(err =>{
                setError(true);
            })
        }
    }, [tokenParams, authCtx]);
    
    return(
        // <div className="login">
        //     <div className="login-button">
        //         {!isLoading ? <MicrosoftLoginButton onClick={loginHandler}></MicrosoftLoginButton> : <Triangle wrapperStyle={{justifyContent:'center'}} height='200' width='200' color='white'></Triangle>}
        //         {failedAuth && <p variant="h6" sx={{width:"50vw", textAlign:"center", position:"absolute", right:"25%", color:"#ffcab1",fontFamily: "system-ui", fontWeight: "500",}}>You are not in the @villanova.edu domain and have not been authorized.<br></br><br></br>If this is an error, contact me using the button below.</p>}
        //         {error && <p variant="h6" sx={{width:"50vw", textAlign:"center", position:"absolute", right:"25%", color:"#ffcab1",fontFamily: "system-ui", fontWeight: "500",}}>There has been an error, please try again.<br></br><br></br>If this continues, please contact me using the button below.</p>}
        //         <p>{JSON.stringify(contextHolder)}</p>
        //     </div>
        // </div>
        <div>
            <button onClick={openSignUpModal}>Open</button>
            <SignUpPage isOpen={isSignUpModalOpen}/>
        </div>
    )
}

export default Login;