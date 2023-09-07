import React,{useState} from 'react';
import axios from 'axios';
import {useNavigate} from 'react-router-dom';

const Register = ({cookies}) =>{
  //Start user credentials
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [passconfirm,setPassconfirm] = useState('');
  const navigate=useNavigate();
  //Handle login event, wait for API response for authorization
  const submitRegister = async (event) => {
    event.preventDefault();
    const userData = {
      username: username,
      password: password
    };
    try {
      
      const response = await axios.post('http://localhost:8080/register', userData);
  
      if (response.status === 200) {
        const token = response.headers['authorization']; // Access the 'Authorization' header
        //Formatting of the token
        const formatToken = token.slice(7);
        cookies.set("authorization",formatToken); // Setting cookie for authorization
        cookies.set("user",userData.username)
        return navigate('/dashboard');
      } else {
        
        console.error('Register error:', response.statusText);
      }
    } catch (error) {
      console.error('Register error:', error);
    }
  };

  return(
    <div>
    <form id='registerform' onSubmit={submitRegister}>
            <div class="form-group">
              <label htmlFor='username'>Username:</label>
              <input
                type='text'
                id='username'
                class ='form-control'
                placeholder='Escoja un nombre de usuario'
                onChange={(event) => setUsername(event.target.value)}
              ></input>
              </div>
              <div class="form-group">
              <label htmlFor='password'>Password:</label>
              <input
                type='password'
                id='pass'
                class ='form-control'
                placeholder='Escoja su clave'
                onChange={(event) => setPassword(event.target.value)}
              ></input>
              </div>
              <div class="form-group">
              <label htmlFor='password'>Password confirmation:</label>
              <input
                type='password'
                id='passconfirm'
                class ='form-control'
                placeholder='Ingrese su clave de nuevo'
                onChange={(event) => setPassconfirm(event.target.value)}
              ></input>
              </div>
              <button type='submit'>Register</button>
            </form>
            </div>
            );

            
            
}
export default Register;