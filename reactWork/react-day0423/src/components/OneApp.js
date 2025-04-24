import React from 'react';
import { Alert } from '@mui/material'
import "./mystyle.css";

const OneApp = () => {
        let color = ["red","green","pink","orange","yellow","white","tomato","gold"];
        let snoopydata = [{"photo":"s1.jpg","title":"영식이","addr":"서울 강남구"},
                        {"photo":"s3.jpg","title":"순자이","addr":"제주 애월읍"},
                        {"photo":"s4.jpg","title":"호식이","addr":"서울 강동구"},
                        {"photo":"s5.jpg","title":"영숙이","addr":"부산 해운대구"}                      
                        ];
                     
    return (
        <div>
            <Alert severity='success'>OneApp(MAP 연습)</Alert>
            {
                color.map((color,idx)=>
                          <div key={idx} style={{backgroundColor:color}} className='box'></div>)
            }
            <br style={{clear:'both'}}/><br/>
            <table className='table table-bordered' style={{width : '400px'}}>
                <thead>
                    <tr className='table-danger'>
                        <th>이름</th> <th>사진</th> <th>주소</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        snoopydata.map((data,idx)=>
                        <tr key={idx}>
                            <td>{data.title}</td>
                            <td>
                                <img alt="" src={require(`../snoopy/${data.photo}`)}
                                style={{width:'50px'}}></img>
                            </td>
                            <td>{data.addr}</td>
                        </tr>)
                    }
                </tbody>
            </table>
        </div>
    );
};

export default OneApp;