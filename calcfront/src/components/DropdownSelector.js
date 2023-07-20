import React, { useState, useEffect } from 'react';
import axios from 'axios';
import VehicleForm from './VehicleForm';
import MakeForm from './MakeForm';
import ModelForm from './ModelForm';
import TypeForm from './TypeForm';
import VehicleList from './listViews/VehicleList';
import ModelList from './listViews/ModelList';
import MakeList from './listViews/MakeList';
import TypeList from './listViews/TypeList';


function DropdownSelector() {
  const [data, setData] = useState([]);
  const [view,setView] = useState('');

  const handleViewChange = (e) => {
    setView(e.target.value);
  };

  useEffect(() => {
    if (view) {
      axios.get(`http://localhost:8080/${view}`)
        .then((response) => {
          console.log(response.data);
          setData(response.data);
        })
        .catch((error) => {
          console.error(error);
        });
    }
  }, [view]);

  return (
    <div>
    <div> 
      <select onChange={handleViewChange}> 
        <option value="makes" id="make">Makes</option> 
        <option value="models" id="model" selected>Models</option> 
        <option value="vehicles" id="vehicle">Vehicles</option> 
        <option value="types" id="type">Types</option> 
      </select>
    </div>

      <div>
        {view === 'vehicles' && <VehicleList data ={data}/>}
        {view === 'models' && <ModelList data ={data}/>}
        {view === 'makes' && <MakeList data ={data}/>}
        {view === 'types' && <TypeList data ={data}/>}
      </div>
      
        <div>
          <h2>Add a new item</h2>
          {view === 'vehicles' && <VehicleForm />}
          {view === 'models' && <ModelForm />}
          {view === 'makes' && <MakeForm />}
          {view === 'types' && <TypeForm />}
        </div>
        
      </div>
      
      
  );
}

export default DropdownSelector;