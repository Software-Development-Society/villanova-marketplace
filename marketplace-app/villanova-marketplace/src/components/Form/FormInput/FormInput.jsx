import React from "react";

const FormInput = (props) => {

    return (
        <>
            <label for={props.for}>{props.label}</label>
            <input type={props.type} name={props.name}></input>
        </>
    )
}

export default FormInput;