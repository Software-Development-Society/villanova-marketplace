import React from "react";
import FormInput from "../FormInput/FormInput";

const FormBox = (props) => {
    return (
        <>
            <form>
                <h1>{props.title}</h1>
                <FormInput for="forlabel" label="label" type="text" name='name'></FormInput>
            </form>
        </>
    )
}

export default FormBox;