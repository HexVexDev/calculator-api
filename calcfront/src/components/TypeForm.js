import React, { useState } from "react";
import axios from 'axios';

const TypeForm = () => {
    const [type_name, setType_name] =useState('');

    const handleSubmit = (event) =>{
        event.preventDefault();
        const type = {
            type_name:type_name,
        };
        axios.post(`http://localhost:8080/types`,type)
            .then((response) => {
                console.log(response);
                
            })
            .catch((error) => {
                console.error(error);
            });

    }

    return (
        <form id="typeForm" onSubmit={handleSubmit}>
            <label htmlFor="type_name">Type:</label>
            <select id="types" onChange={(event) => setType_name(event.target.value)}>
                <option value="sedan">Sedan</option>
                <option value="suv">SUV</option>
                <option value="hatchback">Hatchback</option>
                <option value="truck">Truck</option>
            </select>

            <button type="submit">Submit</button>
        </form>
    );
}

export default TypeForm;