import { Alert, Button } from '@mui/material';
import React, { useRef, useState } from 'react';

const FourApp = () => {

    const [count,setCount] = useState(1); //변경될때마다 랜더링
    const numberRef = useRef(1); //변경이 되어도 랜더링 발생 X

    const countIncreEvent=()=>{
        setCount(count+1);
        console.log("count 변수값 증가 :"+count);        
    }

    const numberIncreEvent=()=>{
        numberRef.current=numberRef.current+1
        console.log("numberRef 증가 :" + numberRef.current);        
    }

    return (
        <div>
            <Alert severity='success'>FourApp - state 변수와 ref 변수 차이점</Alert>

            <Button variant='contained' severity='success'
            onClick={countIncreEvent}>count 변수 증가</Button>
            <b style={{fontSize:'4em',marginLeft:'20px'}}>{count}</b>
            <br/><br/>
            <Button variant='contained' severity='info'
            onClick={numberIncreEvent}>numberRef 변수 증가</Button>
            <b style={{fontSize:'4em',marginLeft:'20px'}}>{numberRef.current}</b>
        </div>
    );
};

export default FourApp;