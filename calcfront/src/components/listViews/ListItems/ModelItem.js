import React from 'react';


const ModelItem = ({ id, model_name, model_slug, model_make, model_type }) => {

    
    return (
        
        <tr>
        <td>{id}</td>
        <td>{model_name}</td>
        <td>{model_slug}</td>
        <td>{model_make}</td>
        <td>{model_type}</td>
       
        </tr>
    );

  
};
export default ModelItem;