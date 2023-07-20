import React, { useState } from "react";
import axios from 'axios';

const MakeForm = () => {
    const [make_name, setMake_name] = useState('');

    const handleSubmit = (event) => {
        event.preventDefault();
        const make = {
            make_name: make_name,
            make_slug: make_name.toLowerCase()
        };
        axios.post(`http://localhost:8080/makes`, make)
            .then((response) => {
                console.log(response);
            })
            .catch((error) => {
                console.error(error);
            });
    }

    return (
        <form id="makeForm" onSubmit={handleSubmit}>
            <label htmlFor="make_name">Make:</label>
            <select id="makes" onChange={(event) => setMake_name(event.target.value)}>
                <option value="Toyota">Toyota</option>
                <option value="Honda">Honda</option>
                <option value="Ford">Ford</option>
                <option value="Chevrolet">Chevrolet</option>
                <option value="Nissan">Nissan</option>
                <option value="BMW">BMW</option>
                <option value="Volkswagen">Volkswagen</option>
                <option value="Hyundai">Hyundai</option>
                <option value="Mercedes">Mercedes-Benz</option>
                <option value="Kia">Kia</option>
            </select>

            <button type="submit">Submit</button>
        </form>
    );
}

export default MakeForm;