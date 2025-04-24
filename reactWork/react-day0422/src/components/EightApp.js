import { Alert } from '@mui/material';
import React from 'react';

const EightApp = () => {

    const names=['이효리','강호동','김녹엽','장원영','원하늘']
    const cars=['1번차','2번차','3번차','4번차','5번차','6번차','7번차','8번차','9번차','10번차','11번차','12번차','13번차','14번차','15번차']

    // 방법 1
    const nameList = names.map((erum,idx)=><h5 key={idx}>{idx}:{erum}</h5>)    
    const numbers = Array.from({ length: 10 }, (_, i) => i + 1);

    return (
        <div>
            <h3 className='alert alert-success'>EightApp</h3>
            <h3 className='alert alert-info' style={{width:'200px'}}>Map 반복문</h3>
            {nameList}

            {/* 배열 반복문 직접 넣기 */}
            {
                names.map((erum,idx)=><Alert key={idx}
                severity='secondary'>
                {idx}:{erum}
                <img alt='' src={require(`../image/${idx+1}.jpg`)} style={{width:'200px'}}/>
                </Alert>)
            }
            <hr/>
            <h5> 배열 변수 없이 1 부터 10 까지 반복하기 </h5>
            <ul>
            {numbers.map((number) => (
            <li key={number}>{number}</li>
            ))}
            </ul>

            <h5>mycar 폴더 만들고 이미지 넣어서 1부터 15까지 이미지 출력</h5>
            <div style={{width: '1200px', height: '1000px', display: 'flex', flexWrap: 'wrap', gap: '20px'}}>
            {
                cars.map((carName,idx)=><Alert key={idx}
                severity='info' icon={false}
                style={{display: 'flex', alignItems: 'center', width: '350px',margin: '10px 0',}}>
                    {carName}
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <img alt='' src={require(`../carimage/mycar${idx+1}.png`)} style={{width : '200px', height : '150px'}}/>
                </Alert>)
            }
            </div>
        </div>
    );
};

export default EightApp;