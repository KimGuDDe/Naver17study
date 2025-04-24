import { Alert } from '@mui/material';
import React, { useRef } from 'react';
import cate from '../data/CateData.json';
import posting from '../data/PostingData.json';
import './mystyle.css';

const TwoApp = () => {
    const navData=cate.navData;
    const CateData = cate.categoryData;
    const mainPhotoRef = useRef(null);
    return (
        <div>
            <Alert severity='success' icon={false}
             style={{fontSize:'25px'}}>TwoApp - Json 데이터 출력</Alert>
             <div className='nav_container'>
                <ui className='nav_category'>
                {
                    navData.map((item,i)=>
                    <li key={i}>
                        <div>
                            <img alt='' src={item.img} className='imgcategory'
                            onClick={(e)=>mainPhotoRef.current.src=e.target.src}/>
                        </div>
                        <div>{item.title}</div>
                    </li>
                    )
                }
                </ui>
             </div>
             <div className='nav_container'>
                <ui className='nav_category'>
                {
                    navData.map((item,i)=>
                    <li key={i}>
                        <div>
                            <img alt='' src={item.img} className='imgcategory'
                            onClick={(e)=>mainPhotoRef.current.src=e.target.src}/>
                        </div>
                        <div>{item.title}</div>
                    </li>
                    )
                }
                </ui>
             </div>

             {/* 아이콘 클릭 시 작은 이미지 가져와서 출력 */}
             <div>
                <img alt='' src={require(`../image/noimage.png`)}
                style={{width :'300px',height:'300px',border:'5px inset gray',margin:'10px 300px'}} ref={mainPhotoRef}/>
             </div>
        </div>
    );
};

export default TwoApp;