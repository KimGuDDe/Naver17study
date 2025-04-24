import { Alert } from '@mui/material';
import React, { useState } from 'react';

const SevenApp = () => {
  const [starArray, setStarArray] = useState([
    {
      starName: '김우빈',
      starAge: '22세',
      starPhoto: '2.jpg',
      starAddress: '서울시 강남구',
      starPhone: '010-2222-3333',
    },
    {
      starName: '설현',
      starAge: '25세',
      starPhoto: '15.jpg',
      starAddress: '서울시 강동구',
      starPhone: '010-2222-3331',
    },
    {
      starName: '신민아',
      starAge: '24세',
      starPhoto: '17.jpg',
      starAddress: '서울시 강서구',
      starPhone: '010-2223-3333',
    },
    {
      starName: '신세경',
      starAge: '23세',
      starPhoto: '18.jpg',
      starAddress: '서울시 강북구',
      starPhone: '010-2222-3312',
    },
    {
      starName: '배수지',
      starAge: '21세',
      starPhoto: '19.jpg',
      starAddress: '서울시 서초구',
      starPhone: '010-2222-3123',
    },
  ]);
  return (
    <div>
      <Alert severity="success">SevenApp - 스타 리스트</Alert>
      <table className="table table-bordered" style={{ width: '400px' }}>
        <tbody>
        {
          starArray.map((star, idx) =>
          <>             
              <tr>
                <td rowSpan={4} style={{ width: '100px', textAlign: 'center', verticalAlign: 'middle' }}>
                  <img
                    src={require(`../image2/${star.starPhoto}`)}
                    alt={star.starName}
                    style={{ width: '80px', height: '100px' }}
                  />
                </td>
                <td>이름: {star.starName}</td>
              </tr>
              <tr>
                <td>나이: {star.starAge}</td>
              </tr>
              <tr>
                <td>주소: {star.starAddress}</td>
              </tr>
              <tr>
                <td>핸드폰: {star.starPhone}</td>
              </tr>            
          
          </>)
        }   
        </tbody>
      </table>
    </div>
  );
};

export default SevenApp;