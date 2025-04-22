import React, { useState } from 'react';
import photo1 from '../image/1.jpg';
import './mystyle.css';

const OneApp = () => {
    const [erum, setErum] = useState('이해성');
    const [nai, setNai] = useState(20);

    const style1 = {
        color: 'green',
        backgroundColor: '#fcfc00',
        width: '400px',
        border: '5px groove tomato',
        textAlign: 'center'
    };

    return (
        <div>
            <h3 className='alert alert-success'>OneApp</h3>
            <h5 style={style1}>스타일 적용방법(변수로 지정하기)</h5>
            <h5 style={{color: 'red', fontFamily: 'Single Day',
                border: '3px inset gold'}}>스타일 적용방법2</h5>
            <h5 className='myfont'>스타일 적용방법3</h5>
            <img alt='' src={photo1} style={{width: '300px'}} />
            <h6>이름과 나이 입력하기</h6>
            <h2 style={{backgroundColor: 'orange'}}>
                이름: {erum}
                <br/>
                나이: {nai}세
            </h2>
            <input 
                type='text' 
                placeholder='erum 입력' 
                value={erum} 
                onChange={(e) => setErum(e.target.value)} 
            />
            <input 
                type='text' 
                placeholder='nai 입력' 
                value={nai}  // 수정: {{nai}} → {nai}
                onChange={(e) => setNai(e.target.value)} 
            />
        </div>
    );
};

export default OneApp;