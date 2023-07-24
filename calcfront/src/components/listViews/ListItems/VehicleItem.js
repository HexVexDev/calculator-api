import React,{useEffect, useState} from 'react';
import UpdateVehicle from '../../updates/UpdateVehicle';
import axios from 'axios';

const VehicleItem = ({id,vehicle_make,vehicle_model,vehicle_name,vehicle_price,vehicle_slug,vehicle_vin,vehicle_year}) => {
    const [updateState,setUpdateState] = useState(false);
   useEffect(()=>{

   },[updateState]);
    
    return (
        <>
        <tr>
          {updateState ? (
            <td colSpan="8">
              <UpdateVehicle
                id={id}
                vehicle_make={vehicle_make}
                vehicle_model={vehicle_model}
                vehicle_name={vehicle_name}
                vehicle_price={vehicle_price}
                vehicle_slug={vehicle_slug}
                vehicle_vin={vehicle_vin}
                vehicle_year={vehicle_year}
                setUpdateState={setUpdateState} // Pass the state setter to the child component
              />
            </td>
          ) : (
            <>
              <td>{id}</td>
              <td>{vehicle_slug}</td>
              <td>{vehicle_name}</td>
              <td>{vehicle_year}</td>
              <td>{vehicle_price}</td>
              <td>{vehicle_vin}</td>
              <td>{vehicle_make}</td>
              <td>{vehicle_model}</td>
              <td>
                <button
                  className="btn btn-success btn-number"
                  onClick={() => setUpdateState(true)}
                >
                  Edit
                </button>
              </td>
              <td>
                <button
                  className="btn btn-success btn-number"
                  onClick={() => handleDelete(id)}
                >
                  Delete
                </button>
              </td>
            </>
          )}
        </tr>
      </>
    );

    function handleDelete(id){
        axios.delete(`http://localhost:8080/vehicles/${id}`)
        .then((response) => {
          console.log(response.data);
        })
        .catch((error) => {
          console.error(error);
        });
    }
};
export default VehicleItem;