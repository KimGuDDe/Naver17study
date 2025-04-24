import { Alert } from '@mui/material';
import React, { useState } from 'react';
import './mystyle.css';

const ThreeApp = () => {
  const [mycarArray, setMycarArray] = useState([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]);

  // 자동차 번호 추가 이벤트
  const addMessageEvent = (e) => {
    if (e.key === 'Enter') {
      const value = e.target.value.trim();
      const num = parseInt(value);
      setMycarArray(mycarArray.concat(num));
      e.target.value = '';
    }
  };

  // 자동차 삭제
  const deleteCar = (num) => {
    if (window.confirm(`해당 자동차(${num})를 삭제할까요?`)) {
      setMycarArray(mycarArray.filter((car) => car !== num));
    }
  };

  return (
    <div>
      <Alert severity="success">ThreeApp</Alert>
      <h6>추가할 자동차 번호 입력 (1~15)</h6>
      <input
        type="text"
        className="form-control"
        placeholder="input car number (1-15)"
        autoFocus
        onKeyUp={addMessageEvent}
      />
      <br />
      <h6 style={{ backgroundColor: 'lightblue' }}>
        자동차 목록 (총 {mycarArray.length}대)
      </h6>
      <div style={{ display: 'flex', flexWrap: 'wrap' }}>
        {mycarArray.map((num, idx) => {
          let imgSrc;
          try {
            imgSrc = require(`../mycar/mycar${num}.png`);
          } catch (error) {
            console.error(`이미지 로드 실패: mycar${num}.png`, error);
            imgSrc = null;
          }

          return imgSrc ? (
            <div key={idx} style={{ margin: '5px' }}>
              <img
                alt={`Car ${num}`}
                src={imgSrc}
                className="mycar"
                onDoubleClick={() => deleteCar(num)}
              />
            </div>
          ) : (
            <div key={idx} style={{ margin: '5px', color: 'red' }}>
              Car {num} 이미지 없음
            </div>
          );
        })}
      </div>
    </div>
  );
};

export default ThreeApp;