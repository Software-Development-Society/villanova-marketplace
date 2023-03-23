import React, { useEffect, useState } from "react";
import RegisInput from "../RegisInput/RegisInput";
import "./RegisForm.css"

const RegisForm = () => {
    const [validForm, setValidForm] = useState(false);
    
    const [formInfo, setFormInfo] = useState({
        firstName: "",
        lastName: "",
        major:"",
        classYear: 0
    });
    
    useEffect(()=>{
        //console.log(formInfo.firstName.length, formInfo.lastName.length, formInfo.classYear, formInfo.major.length)
        if(formInfo.firstName.length > 2 && formInfo.lastName.length > 1 && (formInfo.classYear === "2023" || formInfo.classYear === "2024" || formInfo.classYear === "2025" || formInfo.classYear === "2026") && formInfo.major.length > 2){
            setValidForm(true);
        } else {
            setValidForm(false);
        }
    }, [formInfo])
    
    
    return (
        <form className="form-box">
            <RegisInput objVal="firstName" type="text" label="First Name" setFormInfo={setFormInfo} ></RegisInput>
            <RegisInput objVal="lastName" type="text" label="Last Name" setFormInfo={setFormInfo} ></RegisInput>
            <RegisInput objVal="major" type="text" label="Major" setFormInfo={setFormInfo} ></RegisInput>
            <RegisInput objVal="classYear" type="number" label="Class Year" setFormInfo={setFormInfo}></RegisInput>
            <button disabled={!validForm} >Submit</button>
            {JSON.stringify(formInfo)}
        </form>
    )
}


export default RegisForm