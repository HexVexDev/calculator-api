import React from 'react';
import MakeItem from './ListItems/MakeItem';

const MakeList = ({data}) =>{

    return(
<table className='table'>
      
      <thead className="thead-light">
    <tr>
      <th scope="col">Make ID</th>
      <th scope="col">Make Name</th>
      <th scope="col">Make Slug</th>
    </tr>
  </thead>
    <tbody>
    {data.map((dat) => (
        <MakeItem id={dat.id} key={dat.id} make_slug={dat.make_slug} make_name={dat.make_name}
          />
    ))}
    </tbody>
</table>

    );

}

export default MakeList;