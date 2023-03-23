import React from "react";
import "./RegisInput.css"

const RegisInput = (props) => {
    const valHandler = (event) => {
        //console.log(event.target.value)
        props.setFormInfo((prevState)=>{
            return {
                ...prevState,
                [props.objVal]: event.target.value,
            }
        })
    }
    
    return(
        <>
            <label for={props.label}> {props.label} </label>
            <input type={props.type} name={props.label} onChange={valHandler}></input>
        </>
    )
}

export default RegisInput