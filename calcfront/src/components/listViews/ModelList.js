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
        <ModelItem  key={model.model_id}
        model_id={model.model_id}
        model_name={model.model_name}
        model_slug={model.model_slug}
        make_name={model.fk_model_make?.make_name}
        type_name={model.fk_model_type?.type_name}/>
    ))}
    </tbody>
</table>

    );

}

export default ModelList;