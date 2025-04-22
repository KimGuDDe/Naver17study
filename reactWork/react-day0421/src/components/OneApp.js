//초창기 Component 모두 클래스 형태
//Hooks 문법이 React v16.8 에서 새로 도입 - > 일반 함수형태로 벼경
//초기 함수 형태 -> 상태 저장을 하는 state 기능 X
//Hooks 문법이 추가된 이후부터 일반 함수에서도 상태 유지를 위한 state 기능 추가.
//클래스에서는 라이프 사이클이 엄청 복잡 (Hooks 문법 이후 라이플 사이클 엄청 단순)

import { Component } from "react";
import car11 from "../mycar11.png";
//return 안에 있는 구문들은 html 태그가 아니라 JSX 태그이다

//HTML 과 JSX 의 차이점
//1. 모든 요소는 짝이 맞아야 한다(<br>,><img> 등등 다 짝지가 있다)
//2. 특성 이름이 HTML 언어 사양이 아닌 DOM API 에 기반을 둔다
//3. 

//첫 예제는 클래스로 시작

class OneApp extends Component
{
    constructor(props){
        super(props);
        //생성자는 클래스명과 상관없이 무조건 construtor
    }
    render(){
        return (
            // 부모태그는 무조건 하나만 가능
            // 태그 안에서 직접 스타일을 추가하는 방법
            <div style={{backgroundColor:'orange',width:'250px',height:'200px'}}>
                <h2 style={{color:'blue', backgroundColor:'yellow'}}>OneApp 컴포넌트</h2>
                <br/>
                {/*<br/> 단독태그는 왼쪽처럼 바로 닫기*/}
                {/*public 의 이미지 나타내는 방법 - 경로로 가능 -권장 안함*/}
                <img alt="" src="mycar13.png" style={{width:'100px'}}></img>

                {/*src 의 이미지는 import 후 가져오거나 require 명령어를 이용한다*/}
                <img alt="" src={car11} style={{width:'100px'}}></img>
            </div>
        )
    }
}

export {OneApp} // 여러 번 사용 가능, import 할 때 {OneApp} 으로만 import 가능
// export default OneApp; // default 는 단 한 번만 사용 가능, 이 경우 import 시에 내 마음대로 이름 정해도 됌.