import { Alert } from '@mui/material';
import React from 'react';
import posting from '../data/PostingData.json';
import './mystyle.css';

const ThreeApp = () => {
    const deal = posting.deal;
    return (
        <div>
            <Alert severity='success' icon={false}
             style={{fontSize:'25px'}}>ThreeApp - Json 데이터 출력</Alert>
             <div className='maindiv'>
                <h5><b>오늘의 딜</b></h5>
                {
                    deal.map((item,i)=>
                        <div key={i} className='photodiv'>
                            <img alt='' className='photodiv'/>
                            <br/>
                            <div style={{color:'gray', fontSize:'14px'}}>{item.company}</div>
                            <div style={{color:'gray', fontSize:'16px'}}>
                                [오늘의 딜]{item.title}</div>
                                <span style={{color:'#00ffff'}}>{item.sale}</span>
                                <span style={{color:'#00ffff'}}>{item.sale}</span>
                        </div>)
                }
             </div>
        </div>
    );
};

export default ThreeApp;