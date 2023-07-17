import React from 'react';
import { AppProvider } from './context/AppContext';
import ItemList from './components/ItemList';
import Dropdown from './components/Dropdown';
const App = () => {
    return (
        <AppProvider>
            <div className='container'>
                <h3 className='mt-3'>Vehicle</h3>
                <div className='row '>
                    <div className='col-sm'>
                        <Dropdown />
                    </div>
                </div>
                <div className='row '>
                    <div className='col-sm'>
                        <ItemList />
                    </div>
                </div>
            </div>
        </AppProvider>
    );
};
export default App;