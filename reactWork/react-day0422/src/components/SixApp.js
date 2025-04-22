import { Switch } from '@mui/material';
import React, { useEffect, useState } from 'react';

const SixApp = () => {
    //style 을 이용해서 이미지 보이기/숨기기
    const [visible,setVisible] = useState('visible');
    //const [visible,setVisible] = useState('hidden');

    const [count,setCount] = useState(1);
    const [number,setNumber] = useState(100);

    // useEffect(()=>{
    //     console.log("state 변수가 변경될 때마다 호출")
    // });

    // useEffect(()=>{
    //     console.log("처음 로딩 시 딱 한번만 호출")
    // },[]);

    // useEffect(()=>{
    //     console.log("count가 변경될 때마다 처리할 코드를 넣어주세요")
    // },[count]);

    // useEffect(()=>{
    //     console.log("number가 변경될 때마다 처리할 코드를 넣어주세요")
    // },[number]);

    useEffect(()=>{
        console.log("count 와 number 가 변경될 때 처리할 코드 호출")
    },[count,number]);
    return (
        <div>
            <h3 className='alert alert-success'>SixApp</h3>
            <h3 style={{backgroundColor:'yellow', width:'360px'}}>MUI Switch,Require,useEffect</h3>
            <br/>
            <Switch defaultChecked color='info'
            onChange={(e)=>setVisible(e.target.checked?'visible':'hidden')}/>
            <br/>
            <img alt='' src={require('../image2/12.jpg')}
            style={{width:'200px',visibility:visible}}/> 
            <hr/>
            <h1>count : {count}</h1>
            <h1>number : {number}</h1>

            <button onClick={()=>setCount(count+1)}>count 1 증가</button>
            <br/>
            <button onClick={()=>setNumber(number+10)}>number 10 증가</button>
            <br/>
            <button onClick={()=>{
                setCount(count+2);
                setNumber(number+5);
            }}>count + 2, Number + 5</button>
        </div>
    );
};

export default SixApp;