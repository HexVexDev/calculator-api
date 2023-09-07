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
import {useNavigate} from 'react-router-dom';
import Cookies from 'universal-cookie';


function DropdownSelector({cookies}) {

  const [data, setData] = useState([]);
  const [view,setView] = useState('');
  const [formState,setFormState] = useState(false);
  const navigate=useNavigate();
  const jwtToken = 'Bearer '+ cookies.get("authorization");
  const apiInstance = axios.create({
    baseURL: 'http://localhost:8080/', // Replace with your API base URL
    headers: {
      common: {
        'Content-Type': 'application/json', // JSON content header
        Authorization: jwtToken ? `Bearer ${jwtToken}` : '', // Add the Authorization header with the token if it exists
      },
    },
  });


  const handleViewChange = (e) => {
    setView(e.target.value);
  };
  const handleLogout = () => {
   cookies.remove("authorization");
   cookies.remove("user");
   return navigate('/');

  };


  useEffect(() => {
    if(!cookies.get("authorization")){
      return navigate('/');
      }else{ 
    if (view) {
        apiInstance.get(view)
        .then((response) => {
          if(!response.status ===200){
            return navigate('/');
          }else{
          console.log("Full response data ");
          console.log(response.data);
          console.log("------------------");
          setData(response.data);
        }
        })
        .catch((error) => {
          console.error(error);
        });
    }
  }
}, [view]);
  return (
    <div>
      <p>Hello {cookies.get("user")}</p>
      <button onClick={handleLogout}>Logout</button>
    <div> 
      <select onChange={handleViewChange} class='form-control form-control-lg'> 
        <option value="makes" id="make">Makes</option> 
        <option value="models" id="model" selected>Models</option> 
        <option value="vehicles" id="vehicle">Vehicles</option> 
        <option value="types" id="type">Types</option> 
      </select>
    </div>

      <div>
        {view === 'vehicles' && <VehicleList data ={data} apiInstance={apiInstance}/>}
        {view === 'models' && <ModelList data ={data} apiInstance={apiInstance}/>}
        {view === 'makes' && <MakeList data ={data} apiInstance={apiInstance}/>}
        {view === 'types' && <TypeList data ={data} apiInstance={apiInstance}/>}
      </div>
      
        <div>
          <h2>Add a new item</h2>
          <button onClick={() =>setFormState(true)}>+</button>
          {formState ?(
            <>
          {view === 'vehicles' && <VehicleForm setFormState={setFormState} apiInstance={apiInstance}/>}
          {view === 'models' && <ModelForm setFormState={setFormState} apiInstance={apiInstance}/>}
          {view === 'makes' && <MakeForm setFormState={setFormState} apiInstance={apiInstance}/>}
          {view === 'types' && <TypeForm setFormState={setFormState} apiInstance={apiInstance}/>}
          </>
          ):(
            <></>
          )}
          
        </div>
        
      </div>
      
      
  );

}


export default DropdownSelector;