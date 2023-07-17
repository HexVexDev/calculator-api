import React, { useContext, useState, useEffect } from 'react';
import { AppContext } from '../context/AppContext';
import axios from 'axios';

function ItemList() {
  const { view } = useContext(AppContext);
  const [data, setData] = useState('');

  useEffect(() => {
    if (view) {
      const viewString = typeof view === 'object' ? JSON.stringify(view) : String(view);
      
      axios.get(`http://localhost:8080/${viewString}`)
        .then((response) => {
          console.log(response.data);
          setData(JSON.stringify(response.data));
        })
        .catch((error) => {
          console.error(error);
        });
    }
  }, [view]);

  return (
    <div>
      <div>
        <h5>{data}</h5>
      </div>
      <div>
        <h1>{view}</h1>
      </div>
    </div>
  );
}

export default ItemList;