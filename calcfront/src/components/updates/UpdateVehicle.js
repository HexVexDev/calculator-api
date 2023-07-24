import React, { useState, useEffect } from "react";
import axios from 'axios';

const UpdateVehicle = ({id,vehicle_make,vehicle_model,vehicle_name,vehicle_price,vehicle_slug,vehicle_vin,vehicle_year,setUpdateState}) => {
    const [makedata, setMakedata] = useState([]); // Initialize with an empty array
    const [modeldata, setModeldata] = useState([]); // Initialize with an empty array
    const [nvehicle_id,setVehicle_id] = useState(id);
    const [nvehicle_slug, setVehicle_slug] =useState(vehicle_slug);
    const [nvehicle_name, setVehicle_name] =useState(vehicle_name);
    const [nvehicle_year, setVehicle_year] =useState(vehicle_year);
    const [nvehicle_price, setVehicle_price] =useState(vehicle_price);
    const [nvehicle_vin, setVehicle_vin] =useState(vehicle_vin);
    const [nvehicle_Make, setVehicle_Make] =useState(vehicle_make);
    const [nvehicle_Model, setVehicle_Model] =useState(vehicle_model);

    useEffect(() => {
        axios.get(`http://localhost:8080/makes`)
            .then((response) => {
                console.log(response.data);
                setMakedata(response.data);
                console.log(makedata); // Note that this log will still show the initial value due to closure.
            })
            .catch((error) => {
                console.error(error);
            });

        axios.get(`http://localhost:8080/models`)
            .then((response) => {
                console.log(response.data);
                setModeldata(response.data);
                console.log(modeldata); // Note that this log will still show the initial value due to closure.
            })
            .catch((error) => {
                console.error(error);
            });
    }, []); // Added the closing parenthesis for useEffect

    const handleSubmit = (event) =>{
        event.preventDefault();
        const vehicle = {
            vehicle_id:nvehicle_id,
            vehicle_slug:nvehicle_slug,
            vehicle_name:nvehicle_name,
            vehicle_year:parseInt(nvehicle_year),
            vehicle_price:parseInt(nvehicle_price),
            vehicle_vin:nvehicle_vin,
            fk_vehicle_make:'' ,
            fk_vehicle_model: ''
        };
        const mockvehicle={
          vehicle:vehicle,
          make_id:nvehicle_Make,
          model_id:nvehicle_Model
        }
        console.log(mockvehicle)
        axios.put(`http://localhost:8080/vehicles`,mockvehicle)
            .then((response) => {
                console.log(response);
                
            })
            .catch((error) => {
                console.error(error);
            });
            setUpdateState(false);
    }

    return (
        <tr>
          <td colSpan="8">
        <form id="vehicleForm" onSubmit={handleSubmit}>   
            <label htmlFor="vehicle_slug">Vehicle Slug:</label>
            <input type="text" id="vehicle_slug" name="vehicle_slug" required onChange={(event) => setVehicle_slug(event.target.value)} />
            <label htmlFor="vehicle_name">Vehicle Name:</label>
            <input type="text" id="vehicle_name" name="vehicle_name" onChange={(event) => setVehicle_name(event.target.value)} required />
            <label htmlFor="vehicle_year">Vehicle Year:</label>
            <input type="number" id="vehicle_year" name="vehicle_year" onChange={(event) => setVehicle_year(event.target.value)} required />
            <label htmlFor="vehicle_price">Vehicle Price:</label>
            <input type="number" id="vehicle_price" name="vehicle_price" onChange={(event) => setVehicle_price(event.target.value)} required />
            <label htmlFor="vehicle_vin">Vehicle VIN:</label>
            <input type="text" id="vehicle_vin" name="vehicle_vin" required onChange={(event) => setVehicle_vin(event.target.value)} />
            <label htmlFor="vehicleMake">Vehicle Make:</label>
            <select id="makes" onChange={(event) => setVehicle_Make(event.target.value)}>
              {makedata.map((make) => (
                <option key={make.id} value={make.id}>{make.make_name}</option>
              ))}
            </select>
            <label htmlFor="vehicleModel">Vehicle Model:</label>
            <select id="models" onChange={(event) => setVehicle_Model(event.target.value)}>
              {modeldata.map((model) => (
                <option key={model.id} value={model.model_id}>{model.model_name}</option>
              ))}
            </select>
            <button type="submit">Done</button>
        </form>
        </td>
      </tr>
    );
}

export default UpdateVehicle;