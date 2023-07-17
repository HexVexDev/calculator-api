import React, { useState,useContext } from 'react';
import { AppContext } from '../context/AppContext';

const Dropdown = () => {
    const {dispatch} = useContext(AppContext);

    const handleViewChange = (e) => {
        const selectedView = e.target.value;
        dispatch({
            type: 'CHG_VIEW',
            payload: selectedView,
          });  
      };
    return (
      <div> 
        <select 
        onChange={handleViewChange}> 
        <option value="makes" id="make">Makes</option> 
        <option value="models" id="model" selected>Models</option> 
        <option value="vehicles" id="vehicle" selected>Vehicles</option> 
        <option value="types" id="type">Types</option> 
        </select>
      </div>
    );
  };
  
  export default Dropdown;