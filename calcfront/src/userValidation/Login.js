import React,{useState} from 'react';
import axios from 'axios';
import {useNavigate} from 'react-router-dom';

const Login = ({cookies}) =>{
  //Start user credentials
  const [username, setUsername] = useState('');
  const [pass, setPass] = useState('');
  const navigate=useNavigate();
  //Handle login event, wait for API response for authorization
  const submitLogin = async (event) => {

    event.preventDefault();
    const authCredentials = {
      username: username,
      pass: pass
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
              <button type='submit'>Login</button>
            </form>
            <button onClick={()=>navigate('/register')}>No tengo cuenta papu</button>
            </div>
            );
  }else{
    return navigate('/dashboard');
  }
            
            
}
export default Login;