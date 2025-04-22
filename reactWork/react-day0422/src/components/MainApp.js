import React, { useState } from 'react';
import OneApp from './OneApp';
import TwoApp from './TwoApp';
import ThreeApp from './ThreeApp';
import FourApp from './FourApp';
import FiveApp from './FiveApp';
import SixApp from './SixApp';
import SevenApp from './SevenApp';
import EightApp from './EightApp';

const MainApp = () => {
    const [idx, setIdx] = useState(8); 

    const handleAppChange = (e) => {
        setIdx(Number(e.target.value));
    };

    return (
        <div>
            <h3 className='alert alert-danger'>리액트 수업 2025-04-22</h3>
            <label>
                <input 
                    type='radio' 
                    value={1} 
                    name='selectapp' 
                    checked={idx === 1} 
                    onChange={handleAppChange}
                />OneApp
            </label>
            &nbsp;&nbsp;
            <label>
                <input 
                    type='radio' 
                    value={2} 
                    name='selectapp' 
                    checked={idx === 2} 
                    onChange={handleAppChange}
                />TwoApp
            </label>
            &nbsp;&nbsp;
            <label>
                <input 
                    type='radio' 
                    value={3} 
                    name='selectapp' 
                    checked={idx === 3} 
                    onChange={handleAppChange}
                />ThreeApp
            </label>
            &nbsp;&nbsp;
            <label>
                <input 
                    type='radio' 
                    value={4} 
                    name='selectapp' 
                    checked={idx === 4} 
                    onChange={handleAppChange}
                />FourApp
            </label>
            &nbsp;&nbsp;
            <label>
                <input 
                    type='radio' 
                    value={5} 
                    name='selectapp' 
                    checked={idx === 5} 
                    onChange={handleAppChange}
                />FiveApp
            </label>
            &nbsp;&nbsp;
            <label>
                <input 
                    type='radio' 
                    value={6} 
                    name='selectapp' 
                    checked={idx === 6} 
                    onChange={handleAppChange}
                />SixApp
            </label>
            &nbsp;&nbsp;
            <label>
                <input 
                    type='radio' 
                    value={7} 
                    name='selectapp' 
                    checked={idx === 7} 
                    onChange={handleAppChange}
                />SevenApp
            </label>
            &nbsp;&nbsp;
            <label>
                <input 
                    type='radio' 
                    value={8} 
                    name='selectapp' 
                    checked={idx === 8} 
                    onChange={handleAppChange}
                />EightApp
            </label>
            <div style={{marginTop:'20px'}}>
                {idx === 1 ? <OneApp/> : 
                 idx === 2 ? <TwoApp/> : 
                 idx === 3 ? <ThreeApp/> : 
                 idx === 4 ? <FourApp/> : 
                 idx === 5 ? <FiveApp/>:
                 idx === 6 ? <SixApp/>:
                 idx === 7 ? <SevenApp/>:
                 <EightApp/>}
            </div>
        </div>
    );
};

export default MainApp;