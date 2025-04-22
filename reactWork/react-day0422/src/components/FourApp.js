import React from 'react';
import styled from "styled-components";
import {DeleteForever, AddIcCall, Apple, DeleteForeverOutlined, DeleteForeverRounded, DeleteForeverTwoTone, Face4, PhoneAndroidOutlined, PhotoAlbum } from "@mui/icons-material";

const FourApp = () => {
    
    const Title = styled.h2`
        color:orange;
        font-size:1.5em;
        background-color : yellow;
        width : 500px;
        `;

    const MyButton = styled.button`
            color:blue;
            background-color : purple;
            border:5px inset green;
        `;

    const TomatoButton=styled(MyButton)`
            color : tomato;
            border-color : tomato;
        `;     
    return (
        <div>
            <h3 className='alert alert-success'>FourApp</h3>
            <Title>Hello React!</Title>
            <Title>안녕하세요</Title>

            <button type='button'>기본 버튼 모양</button>
            <br/>
            <MyButton>myButton 모양</MyButton>
            <br/>
            <TomatoButton>토마토 버튼</TomatoButton>
            <h5>Material Icons</h5>
            <DeleteForever/>
            <DeleteForeverRounded/>
            <DeleteForeverOutlined/>
            <DeleteForeverTwoTone/>
            <PhotoAlbum/>
            <PhoneAndroidOutlined/>
            <AddIcCall style={{color:'pink',fontSize:'30px'}}/>
            <Apple style={{color:'red'}}/>
            <Face4 style={{fontSize:'3em'}}/>
        </div>
    );
};

export default FourApp;