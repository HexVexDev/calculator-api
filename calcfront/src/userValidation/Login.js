import React,{useState} from 'react';
import axios from 'axios';
import {useNavigate} from 'react-router-dom';

const Login = ({cookies}) =>{
  //Start user credentials
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const navigate=useNavigate();
  //Handle login event, wait for API response for authorization
  const submitLogin = async (event) => {

    event.preventDefault();
    const authCredentials = {
      username: username,
      password: password
    };
    try {
      
      const response = await axios.post('http://localhost:8080/login', authCredentials);
  
      if (response.status === 200) {
        const token = response.headers['authorization']; // Access the 'Authorization' header
        //Formatting of the token
        const formatToken = token.slice(7);
        cookies.set("authorization",formatToken); // Setting cookie for authorization
        cookies.set("user",authCredentials.username)
        return navigate('/dashboard');
      } else {
        
        console.error('Login error:', response.statusText);
      }
    } catch (error) {
      console.error('Login error:', error);
    }
  };

  if(!cookies.get("authorization")){
  return(
    <div>
    <form id='loginform' onSubmit={submitLogin}>
          <div class="form-group">
              <label htmlFor='username'>Username:</label>
              <input
                type='text'
                id='username'
                class ='form-control'
                placeholder='Ingrese su usuario'
                onChange={(event) => setUsername(event.target.value)}
              ></input>
              </div>
              <div class="form-group">
              <label htmlFor='password'>Password:</label>
              <input
                type='password'
                id='pass'
                class ='form-control'
                placeholder='Ingrese su clave'
                onChange={(event) => setPassword(event.target.value)}
              ></input>
              </div>
              <button type='submit' class= 'btn btn-primary'>Login</button>
            </form>
            <button onClick={()=>navigate('/register')}>No tengo cuenta papu</button>
            </div>
            );
  }else{
    return navigate('/dashboard');
  }
            
            
}
export default Login;