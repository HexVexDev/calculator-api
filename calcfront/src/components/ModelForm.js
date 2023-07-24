import React, { useState, useEffect } from "react";
import axios from 'axios';

const ModelForm = ({setFormState}) => {
    const [makedata, setMakedata] = useState([]); // Initialize with an empty array
    const [typedata, setTypedata] = useState([]); // Initialize with an empty array
    const [model_name, setModel_name] =useState('');
    const [model_slug, setModel_slug] =useState('');
    const [model_Make, setModel_make] =useState([]);
    const [model_Type, setModel_type] =useState([]);
   

    useEffect(() => {
        axios.get(`http://localhost:8080/makes`)
            .then((response) => {
                console.log(response.data);
                setMakedata(response.data);
                console.log(makedata); // Note that this log will still show the initial value due to closure.
            })
            .catch((error) => {
                console.error(error);
            });

        axios.get(`http://localhost:8080/types`)
            .then((response) => {
                console.log(response.data);
                setTypedata(response.data);
                console.log(typedata); // Note that this log will still show the initial value due to closure.
            })
            .catch((error) => {
                console.error(error);
            });
    }, []); // Added the closing parenthesis for useEffect

    const handleSubmit = (event) =>{
        event.preventDefault();
    
        const model = {
            model_name:model_name,
            model_slug:model_slug,
            fk_model_make:{},
            fk_model_type:{}
        }
        const mockmodel = {
            model:model,
            make_id:parseInt(model_Make.id),
            type_id: parseInt(model_Type.id),
           
        }

        console.log(mockmodel)
        axios.post(`http://localhost:8080/models`,mockmodel)
            .then((response) => {
                console.log(response);
                
            })
            .catch((error) => {
                console.error(error);
            });
            setFormState(false);
    }

    return (
        <form id="modelForm"  onSubmit={handleSubmit}>
            <label htmlFor="model_name">Model name:</label>
            <input type="text" id="model_name" name="model_name" onChange={(event) => setModel_name(event.target.value)} required  />

            <label htmlFor="model_slug">Model slug:</label>
            <input type="text" id="model_slug" name="model_slug" onChange={(event) => setModel_slug(event.target.value)} required />

            <label htmlFor="modelMake">Model make:</label>
            <select id="makes"  onChange={(event) => setModel_make(makedata.find(make => make.id === parseInt(event.target.value)))}>
                {makedata.map((make) => (
                    <option key={make.id} value={make.id}>{make.make_name}</option>
                ))}
            </select>

            <label htmlFor="modelType">Model Type:</label>
            <select id="types" onChange={(event) => setModel_type(typedata.find(type => type.id === parseInt(event.target.value)))}>
                {typedata.map((type) => (
                    <option key={type.id} value={type.id}>{type.type_name}</option>
                ))}
            </select>

            <button type="submit">Submit</button>
        </form>
    );
}

export default ModelForm;