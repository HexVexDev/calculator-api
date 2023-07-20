import React, { useState, useEffect } from "react";
import axios from 'axios';

const UpdateMake = (props) => {

    const [make_id,setVehicle_id] = useState('');
    const [make_slug, setMake_slug] =useState('');
    const [make_name, setMake_name] =useState('');

    const handleSubmit = (event) =>{
        event.preventDefault();
        setVehicle_id(props.id);
        const vehicle = {
            vehicle_id:vehicle_id,
            vehicle_slug:vehicle_slug,
            vehicle_name:vehicle_name,
            vehicle_year:parseInt(vehicle_year),
            vehicle_price:parseInt(vehicle_price),
            vehicle_vin:vehicle_vin,
            fk_vehicle_make: vehicle_Make,
            fk_vehicle_model: vehicle_Model
        };
        axios.put(`http://localhost:8080/vehicles`,vehicle)
            .then((response) => {
                console.log(response);
                
            })
            .catch((error) => {
                console.error(error);
            });

    }

    return (
        <tr>
        <form id="makeForm" onSubmit={handleSubmit}>
            <td>
            <label htmlFor="make_name">Make Name:</label>
            </td>
            <td>
            <input type="text" id="make_name" name="make_name" required onChange={(event) => setMake_name(event.target.value)} />
            </td>
          <td>
            <label htmlFor="make_slug">Make Slug:</label>
          </td>
          <td>
            <input type="text" id="make_slug" name="make_slug" onChange={(event) => setMake_slug(event.target.value)} required />
          </td>
      
          <td>
            <button type="submit">Done</button>
          </td>
        </form>
      </tr>
    );
}

export default UpdateMake;