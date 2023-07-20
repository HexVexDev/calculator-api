import React from 'react';
import TypeItem from './ListItems/TypeItem';

const TypeList = (props) =>{

    return(
<table className='table'>
      
      <thead className="thead-light">
    <tr>
      <th scope="col">Type ID</th>
      <th scope="col">Type Name</th>
    </tr>
  </thead>
    <tbody>
    {props.data.map((dat) => (
        <TypeItem id={dat.id} key={dat.type_id} type_name={dat.type_name}
         />
    ))}
    </tbody>
</table>

    );

}

export default TypeList;