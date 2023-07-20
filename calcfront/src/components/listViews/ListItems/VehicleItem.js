import React,{useState} from 'react';
import UpdateVehicle from '../../updates/UpdateVehicle';

const VehicleItem = (props) => {
    const [updateState,setUpdateState] = useState(-1);

    
    return (
        
        <tr>
            {updateState === props.id && <UpdateVehicle id={props.id}/>}
        <td>{props.id}</td>
        <td>{props.vehicle_slug}</td>
        <td>{props.vehicle_name}</td>
        <td>{props.vehicle_year}</td>
        <td>{props.vehicle_price}</td>
        <td>{props.vehicle_vin}</td>
        <td>{props.vehicle_make}</td>
        <td>{props.vehicle_model}</td>
        <td><button class="btn btn-success btn-number" onClick={()=> handleEdit(props.id)}>Edit</button></td>
        </tr>
    );

    function handleEdit(id){
        setUpdateState(id);
        console.log(props.id);
        console.log(props.vehicle_model)
    }
};
export default VehicleItem;