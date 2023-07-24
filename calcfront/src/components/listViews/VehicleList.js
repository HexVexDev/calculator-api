import React from 'react';
import VehicleItem from './ListItems/VehicleItem';

const VehicleList = ({data}) =>{

    return(
<table className='table'>
      
      <thead className="thead-light">
    <tr>
      <th scope="col">Vehicle ID</th>
      <th scope="col">Vehicle Slug</th>
      <th scope="col">Vehicle Name</th>
      <th scope="col">Vehicle Year</th>
      <th scope="col">Vehicle Price</th>
      <th scope="col">Vehicle VIN</th>
      <th scope="col">Vehicle Make</th>
      <th scope="col">Vehicle Model</th>
    </tr>
  </thead>
    <tbody>
    {data.map((dat) => (
        <VehicleItem id={dat.id} key={dat.id} vehicle_slug={dat.vehicle_slug} vehicle_name={dat.vehicle_name}
        vehicle_year={dat.vehicle_year} vehicle_price={dat.vehicle_price} vehicle_vin={dat.vehicle_vin} vehicle_make={dat.fk_vehicle_make}
        vehicle_model={dat.fk_vehicle_model}  />
    ))}
    </tbody>
</table>

    );

}

export default VehicleList;