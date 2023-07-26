import React from 'react';


const ModelItem = ({ model_id, model_name, model_slug,make_name,type_name }) => {

    
    return (
        
        <tr>
        <td>{model_id}</td>
        <td>{model_name}</td>
        <td>{model_slug}</td>
        {make_name&&<td>{make_name}</td>}
        {type_name&&<td>{type_name}</td>}
       
        </tr>
    );

  
};
export default ModelItem;