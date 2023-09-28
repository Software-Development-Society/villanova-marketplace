import {useState} from 'react';
import styles from './SignUpPage.css';
import {TextField} from "@mui/material";

const SignUpPage = ({isOpen}) => {

    return(
        isOpen && (
                <div>
                    <h2>Name</h2>
                    <TextField id="outlined-required" label="First Name" variant="outlined" />
                    <TextField id="outlined-required" label="Last Name" variant="outlined" />
                </div>
        )
    );
}

export default SignUpPage;