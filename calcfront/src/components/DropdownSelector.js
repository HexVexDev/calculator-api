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
  const [formState,setFormState] = useState(false);
 

  const handleViewChange = (e) => {
    setView(e.target.value);
  };

  useEffect(() => {
    if (view) {
      axios.get(`http://localhost:8080/${view}`)
        .then((response) => {
          console.log("Full response data ");
          console.log(response.data);
          console.log("------------------");
          setData(response.data);
        })
        .catch((error) => {
          console.error(error);
        });
    }
  }, [view,formState]);

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
          <button onClick={() =>setFormState(true)}>+</button>
          {formState ?(
            <>
          {view === 'vehicles' && <VehicleForm setFormState={setFormState}/>}
          {view === 'models' && <ModelForm setFormState={setFormState}/>}
          {view === 'makes' && <MakeForm setFormState={setFormState}/>}
          {view === 'types' && <TypeForm setFormState={setFormState}/>}
          </>
          ):(
            <></>
          )}
          
        </div>
        
      </div>
      
      
  );
}

export default DropdownSelector;