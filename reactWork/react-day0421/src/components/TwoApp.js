//단축키 rsf

// import React from 'react';

// function TwoApp(props) {
//     return (
//         <div>
            
//         </div>
//     );
// }

// export default TwoApp;

//단축키 rsc
import React from 'react';
import "./mystyle.css"
import food1 from "../food/11.jpg";
import food2 from "../food/8.jpg";

const TwoApp = () => {
    let msg = "Have a nice day!"; //출력 가능 태그 내에서 수정 불가능능
    return (
        <div>
            <h2>TwoApp 컴포넌트</h2>
            <img alt='' src={food1} className='photo1'></img>
            <br></br>
            <br></br>
            <img alt='' src={food2} className='photo2'></img>
            {/* h5의 배경색 글자색 너비 글꼴 모두 변경해보기 style 로 */}
            <h5 style={{backgroundColor:'blue', width:'200px', color:'pink',fontFamily:'PlayWrite AU SA'}}>{msg}</h5>
        </div>        
    );
};

export default TwoApp;