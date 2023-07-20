import React from 'react';
import { AppProvider } from './context/AppContext';
import DropdownSelector from './components/DropdownSelector';
const App = () => {
    return (
        <AppProvider>
            <div className='container'>
                <div className='row '>
                    <div className='col-sm'>
                        <DropdownSelector />
                    </div>
                </div>
            </div>
        </AppProvider>
    );
};
export default App;