import { React, useState } from "react";
import "./Searchbar.css"

const Searchbar = ()=> {
    return (
        <div className="searchBox">
            <input
                className="search"
                type="text"
                placeholder="Search"
            />

            <button className="searchButton">Submit</button>
        </div>
    )
}

export default Searchbar
