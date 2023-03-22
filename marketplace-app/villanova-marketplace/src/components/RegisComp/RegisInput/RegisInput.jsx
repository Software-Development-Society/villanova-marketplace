import React from "react";
import "./RegisInput.css"

const RegisInput = (props) => {
    return(
        <>
            <label for={props.label}> {props.label} </label>
            <input type={props.type} name={props.label}></input>
        </>
    )
}

export default RegisInput