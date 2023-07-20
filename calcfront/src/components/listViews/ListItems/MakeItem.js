import React from 'react';


const MakeItem = (props) => {

    
    return (
        
        <tr>
        <td>{props.id}</td>
        <td>{props.make_name}</td>
        <td>{props.make_slug}</td>
       
        </tr>
    );

  
};
export default MakeItem;