import React,{useState} from 'react';
import { Route,Routes} from 'react-router-dom';
import Cookies from 'universal-cookie';
import Register from './userValidation/Register';
import DropdownSelector from './components/DropdownSelector';
import Login from './userValidation/Login';
import {useNavigate} from 'react-router-dom';
import axios from 'axios';

const App = () => {
  const cookies = new Cookies();

  return (

    <Routes>
          <Route exact path="/" element={<Login cookies={cookies} />} />
          <Route exact path="/dashboard" element={<DropdownSelector cookies={cookies} />} />
          <Route exact path="register" element={<Register cookies={cookies} />} />

    </Routes>
  );
};

export default App;