import React, { useEffect, useState } from 'react';
import { Button, colors } from '@mui/material';
import img1 from '../image2/3.jpg'

const SevenApp = () => {
    
    const [count,setCount] = useState(1);
    const [show,setShow] = useState(true);

    useEffect(() => {
        count%3===0?setShow(false):setShow(true);
      }, [count]);

    return (
        <div>
            <h3 className='alert alert-success'>SevenApp</h3>
            <h3 style={{backgroundColor:'green', width:'150px'}}>useEffect</h3>
            <h5>count 가 3 의 배수일 때마다 사진 숨기기</h5>

            <Button variant='contained' color='success'
            onClick={()=>{
                setCount(count+1);
                // 비동기 특성 상 순서대로 진행이 안됨
                // count%3===0?setShow(true):setShow(false);
            }}>count 증가</Button>
            <br/>
            <b style={{fontSize: '4em', color:'red'}}>{count}</b>
            <br/><br/>
            {
                show &&
                <img alt='' src={img1} style={{width:'300px'}}/>                
            }
        </div>
    );
};

export default SevenApp;