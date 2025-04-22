import React, { useState } from 'react';
import photo1 from '../image/30.jpg';
import photo2 from '../image/31.jpg';
import photo3 from '../image/2.jpg';
import photo4 from '../image/3.jpg';

const TwoApp = () => {
    const [photo,setPhoto]=useState(photo2);
    const [borderWidth,setBorderWidth]=useState(5);
    const [borderColor,setBorderColor]=useState('tomato');
    const [show,setShow] = useState(true);

    const colorChange = (e) =>{
        setBorderColor(e.target.value)
    }

    return (
        <div>
            <h3 className='alert alert-success'>TwoApp</h3>
            {
            show &&
            <img alt='' src={photo} style={{width:'200px',border:`${borderWidth}px solid ${borderColor}`}}/>
            }            
            <br/><br/>
            <b>보이기 / 숨기기</b>
            &nbsp;&nbsp;
             <label>
                <input type='checkbox' defaultChecked
                onClick={(e) => setShow(e.target.checked)}/>
             </label>
            <br/><br/>
            <b>사진 변경 : </b>     

            <select style={{width:'150px'}}
            onChange={(e)=>setPhoto(e.target.value)}>
                <option value={photo1}>사진 1</option>
                <option value={photo2} selected>사진 2</option>
                <option value={photo3}>사진 3</option>
                <option value={photo4}>사진 4</option>
            </select>
            <b>테두리선 굵기 변경 : </b>
            <input type='number' min="1" max="20" value={borderWidth}
            onChange={(e)=>setBorderWidth(Number(e.target.value))}/>
            <br/>
            <b>테두리선 색상 변경</b>
            <br/>
            <label>
                <input type='radio' name='bcolor' defaultValue={'#66cdaa'}
                onChange={colorChange}/>아쿠아마린
            </label>
            &nbsp;&nbsp;
            <label>
                <input type='radio' name='bcolor' defaultValue={'#ffc0cb'}
                onChange={colorChange}/>파스텔핑크
            </label>
            &nbsp;&nbsp;
            <label>
                <input type='radio' name='bcolor' defaultValue={'tomato'}
                onChange={colorChange}  defaultChecked/>토마토
            </label>
            &nbsp;&nbsp;
            <label>
                <input type='radio' name='bcolor' defaultValue={'#9acd32'}
                onChange={colorChange}/>옐로그린
            </label>
            &nbsp;&nbsp;
        </div>
    );
};

export default TwoApp;