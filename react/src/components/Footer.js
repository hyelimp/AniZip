import React from "react";
import Container from 'react-bootstrap/Container';
import '../css/footer.css';

const url = "https://comicw.co.kr/";

const Footer = () => {
    return(
        <div className="Foot">
            <Container className="foot_container">
                
                <img
                    className="f_logo"
                    src="/images/icon.png"
                    alt="푸터로고"
                    />
                <p className="f_address">회사 주소 : 서울 구로구 경인로 557 삼영빌딩 4층 401호 <br /> 연락처 : 010-1234-7979
                <br />
                COPYRIGNT &copy; PARK HYE LIM ALL RIGHTS RESERVED.</p>
                <br />
                <button className="f_btn" onClick={()=>{window.open(url)}} >코믹월드 웹사이트 바로가기</button>
            </Container>
        </div>
    );
};

export default Footer;