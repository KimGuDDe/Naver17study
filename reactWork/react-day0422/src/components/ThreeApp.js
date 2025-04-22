import React, { useState } from 'react';
import photo1 from '../image2/1.jpg';
import photo2 from '../image2/2.jpg';
import photo3 from '../image2/3.jpg';

const ThreeApp = () => {

    const [show, setShow] = useState(true); 
    const [photo, setPhoto] = useState(photo1);
    const [size, setSize] = useState(350); 
    const [borderStyle, setBorderStyle] = useState('solid pink'); 

    // 사진 크기 조절
    const increaseSize = () => setSize(prev => Math.min(prev + 10, 500)); 
    const decreaseSize = () => setSize(prev => Math.max(prev - 10, 100)); 

    // 테두리 스타일
    const borderChange = (e) => {
        setBorderStyle(e.target.value);
    };

    return (
        <div>
            <h3 className='alert alert-success'>ThreeApp</h3>
            <h1 style={{color: 'pink'}}>오늘의 문제</h1>
            <br/>
            <hr/>
            <div>
                <h3 className='box1'>리액트 문제 다 풀면 복습 100% 보장</h3>
                <br/><br/>
            </div>
            <div style={{ marginBottom: '10px', width:'1000px'}}>
                <label>
                    <input 
                        type='checkbox' 
                        checked={show} 
                        onChange={(e) => setShow(e.target.checked)} 
                    /> 사진 보이기  /  숨기기
                </label>
                <button className='button' onClick={decreaseSize}>작게</button>
                <button className='button' onClick={increaseSize}>크게</button>
                <select className='select'
                onChange={(e)=>setPhoto(e.target.value)}>
                    <option value={photo1}>사진 1</option>
                    <option value={photo2}>사진 2</option>
                    <option value={photo3}>사진 3</option>
                </select>
                <select className='select' onChange={borderChange}>
                    <option value="solid pink">실선 핑크</option>
                    <option value="dashed red">점선 레드</option>
                    <option value="dotted blue">점선 블루</option>
                </select>
                <br/><br/>
                <div>
                {show && (
                    <img src={photo} alt="" className="photo"
                            style={{width: `${size}px`, border: `5px ${borderStyle}`}} 
                    />
                )}
                </div>
            </div>            
        </div>
    );
};

export default ThreeApp;