import React, { useState } from "react";
import RegisInput from "../RegisInput/RegisInput";
import "./RegisForm.css"

const RegisForm = () => {
    const [formInfo, setFormInfo] = useState({
        firstName: "",
        lastName: "",
        age: 0
    });
    
    const formHandler = () => {
        
    }
    
    return (
        <form className="form-box">
            <RegisInput type="text" label="First Name" ></RegisInput>
            <RegisInput type="text" label="Last Name" ></RegisInput>
            <RegisInput type="number" label="Age" ></RegisInput>
            <button>Submit</button>
        </form>
    )
}


export default RegisForm