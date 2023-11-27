import axios from "axios";
import React from "react";
import '../css/login.css';
import Container from 'react-bootstrap/Container';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Button from "react-bootstrap/Button";
import { Input } from "reactstrap";



const Login = () => {

    const fn_signIn = () => {
        var submitYN = false;

        const memberId = document.getElementById('memberId').value;
        const memberPw = document.getElementById('memberPw').value;

        if(document.getElementById("memberId").value.length < 1){
            alert("아이디를 입력해 주세요!");
            document.getElementById("memberId").focus()
            return;
        }

        if(document.getElementById("memberPw").value.length < 1){
            alert("비밀번호를 입력해 주세요!");
            document.getElementById("memberPw").focus()
            return;
        }

        if(!submitYN){
            var submitYN = true;

            const form = new FormData()
            form.append('memberId', memberId)
            form.append('memberPw', memberPw)

            console.log("click login");

            axios.post('http://localhost:9003/loginAction.do',
            form,{
                headers:{
                    'Content-type':'application/json',
                }
            }
            )
            .then((res) => {
                console.log(res.data);
                if(res.data != "N"){
                    alert(res.data + " 회원님, 환영합니다!");
                    // sessionStorage에 id 저장 처리함
                    sessionStorage.setItem("member_id", memberId);
                    // sessionStorage에 name 저장 처리함
                    sessionStorage.setItem("name", res.data);
                    document.location.href="/Home";
                } else{
                    alert("회원 정보가 없습니다!");
                   }
                 })
                 .catch()
                }
            }
          return (
        <>
           <div className="login_header">
                <p className="loginText">로그인</p>
           </div>
           {/* https://react-bootstrap.netlify.app/docs/layout/grid */}
           <Container fluid="sm">
            <Row className="login_row">
                <Col md={{span:4, offset:4}} id="login_div" >
                {/* https://react-bootstrap.netlify.app/docs/forms/form-control */}                
            <Form id='loginForm'>
                <Form.Group className="form-group mb-4">
                {/* https://reactstrap.github.io/?path=/docs/components-forms--input */}
                 <Input type="id" id="memberId" placeholder="아이디를 입력해 주세요!" />
                </Form.Group>
                <Form.Group className="form-group mb-4">
                <Input type="password" id="memberPw" placeholder="비밀번호를 입력해 주세요!" />
                </Form.Group>
                <div className="form-group d-grid mb-5">
                    <Button id="id_btn" variant="primary" size="lg" onClick={fn_signIn} >로그인</Button>
                </div>
            </Form>
                </Col>
            </Row>
           
           </Container>
        </>
    );
};

export default Login;