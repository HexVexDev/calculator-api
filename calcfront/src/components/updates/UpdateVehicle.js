import React, { useState, useEffect } from "react";
import axios from 'axios';

const UpdateVehicle = (props) => {
    const [makedata, setMakedata] = useState([]); // Initialize with an empty array
    const [modeldata, setModeldata] = useState([]); // Initialize with an empty array
    const [vehicle_id,setVehicle_id] = useState('');
    const [vehicle_slug, setVehicle_slug] =useState('');
    const [vehicle_name, setVehicle_name] =useState('');
    const [vehicle_year, setVehicle_year] =useState('');
    const [vehicle_price, setVehicle_price] =useState('');
    const [vehicle_vin, setVehicle_vin] =useState('');
    const [vehicle_Make, setVehicle_Make] =useState('');
    const [vehicle_Model, setVehicle_Model] =useState('');

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
        <form id="vehicleForm" onSubmit={handleSubmit}>
            <td>
            <label htmlFor="vehicle_slug">Vehicle Slug:</label>
            </td>
            <td>
            <input type="text" id="vehicle_slug" name="vehicle_slug" required onChange={(event) => setVehicle_slug(event.target.value)} />
            </td>
          <td>
            <label htmlFor="vehicle_name">Vehicle Name:</label>
          </td>
          <td>
            <input type="text" id="vehicle_name" name="vehicle_name" onChange={(event) => setVehicle_name(event.target.value)} required />
          </td>
      
          <td>
            <label htmlFor="vehicle_year">Vehicle Year:</label>
          </td>
          <td>
            <input type="number" id="vehicle_year" name="vehicle_year" onChange={(event) => setVehicle_year(event.target.value)} required />
          </td>
      
          <td>
            <label htmlFor="vehicle_price">Vehicle Price:</label>
          </td>
          <td>
            <input type="number" id="vehicle_price" name="vehicle_price" onChange={(event) => setVehicle_price(event.target.value)} required />
          </td>
      
          <td>
            <label htmlFor="vehicle_vin">Vehicle VIN:</label>
          </td>
          <td>
            <input type="text" id="vehicle_vin" name="vehicle_vin" required onChange={(event) => setVehicle_vin(event.target.value)} />
          </td>
      
          <td>
            <label htmlFor="vehicleMake">Vehicle Make:</label>
          </td>
          <td>
            <select id="makes" onChange={(event) => setVehicle_Make(event.target.value)}>
              {makedata.map((make) => (
                <option key={make.id} value={make}>{make.make_name}</option>
              ))}
            </select>
          </td>
      
          <td>
            <label htmlFor="vehicleModel">Vehicle Model:</label>
          </td>
          <td>
            <select id="models" onChange={(event) => setVehicle_Model(event.target.value)}>
              {modeldata.map((model) => (
                <option key={model.id} value={model}>{model.model_name}</option>
              ))}
            </select>
          </td>
      
          <td>
            <button type="submit">Done</button>
          </td>
        </form>
      </tr>
    );
}

export default UpdateVehicle;