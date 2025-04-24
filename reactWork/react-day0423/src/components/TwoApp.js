import { Alert } from '@mui/material';
import React, { useState } from 'react';
import { DeleteForeverOutlined } from '@mui/icons-material'

const TwoApp = () => {
    const [msg,setMsg]=useState(["안녕하세요","비트캠프","Happy Day"]);
    const addMessageEvent=(e)=>{
        if(e.key==='Enter'){
        // alert(e.target.value+","+e.key);

        //React 는 배열에 추가 시 push 가 아닌 concat 으로 추가
        setMsg(msg.concat(e.target.value));
        e.target.value="";
        }
    }

    //삭제
    const deleteMessage=(i)=>{
        //배열 데이타 삭제 방법
        // 방법 1 : slice 
            // setMsg(
            //     [...msg.slice(0,1),
            //     ...msg.slice(i+1,msg.length)
            //     ]
            // )
        // 방법 2 : filter (i 번만 빼고 배열로 리턴턴)
            setMsg(msg.filter((m,idx)=>idx!==i));
    }

    return (
        <div>
            <Alert severity='success'>TwoApp</Alert>
            <h6>추가할 메세지 입력</h6>
            <input type='text' className='form-control'
            placeholder='input message' autoFocus
            onKeyUp={addMessageEvent}/>
            <br/>
            <h6 style={{backgroundColor:'orange'}}>msg 배열 데이터 (총 {msg.length}개)</h6>
            {
                msg.map((m,i)=>
                <h5 key={i}>
                    {i+1} : {m}

                    <DeleteForeverOutlined
                    style={{float:'right',cursor:'pointer',color:'red'}}
                    onClick={() => deleteMessage(i)}/>
                </h5>)
            }
        </div>
    );
};

export default TwoApp;