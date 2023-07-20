import React from 'react';
import ModelItem from './ListItems/ModelItem';

const ModelList = ({data}) =>{
    return(
<table className='table'>
      
      <thead className="thead-light">
    <tr>
      <th scope="col">Model ID</th>
      <th scope="col">Model Name</th>
      <th scope="col">Model Slug</th>
      <th scope="col">Model Make</th>
      <th scope="col">Model Type</th>
    </tr>
  </thead>
    <tbody>
    {data.map((model) => (
        console.log(model)
    ))}
    </tbody>
</table>

    );

}

export default ModelList;