import React,{useState} from 'react';
import axios from 'axios';
import {useNavigate} from 'react-router-dom';

const Register = ({cookies}) =>{
  //Start user credentials
  const [username, setUsername] = useState('');
  const [pass, setPass] = useState('');
  const [passconfirm,setPassconfirm] = useState('');
  const navigate=useNavigate();
  //Handle login event, wait for API response for authorization
  const submitRegister = async (event) => {
    event.preventDefault();
    const userData = {
      username: username,
      pass: pass
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
              <label htmlFor='username'>Username:</label>
              <input
                type='text'
                id='username'
                onChange={(event) => setUsername(event.target.value)}
              ></input>
              <label htmlFor='password'>Password:</label>
              <input
                type='password'
                id='pass'
                onChange={(event) => setPass(event.target.value)}
              ></input>
              <input
                type='password'
                id='passconfirm'
                onChange={(event) => setPassconfirm(event.target.value)}
              ></input>
              <button type='submit'>Register</button>
            </form>
            </div>
            );

            
            
}
export default Register;