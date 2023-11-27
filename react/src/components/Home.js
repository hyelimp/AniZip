import React from "react";
import Container from 'react-bootstrap/Container';
import Carousel from 'react-bootstrap/Carousel';
import Tab from 'react-bootstrap/Tab';
import Tabs from 'react-bootstrap/Tabs';
import 'bootstrap/dist/css/bootstrap.css';
import '../css/home.css';

// Carousels 맨 위에 Examples
// https://react-bootstrap.netlify.app/docs/components/carousel/



const Home = () => {    
    return(   
        <>
        <div className="Banner">
              <Container>
                    <div className="carousel_tabs_cont">
                        <div className="carouselcont">
                        <Carousel fade>
                        <Carousel.Item>
                                <img
                                className="d-block"
                                src="/images/photo10.jpg"
                                alt="가케구루이"
                                />
                                <Carousel.Caption>                                
                                </Carousel.Caption>
                            </Carousel.Item>
                            <Carousel.Item>
                                <img
                                className="d-block"
                                src="/images/banner1.jpg"
                                alt="코스프레 크루 모집"
                                />
                                <Carousel.Caption>                                
                                </Carousel.Caption>
                            </Carousel.Item>
                            <Carousel.Item>
                            <img
                                className="d-block"
                                src="/images/banner2.jpg"
                                alt="게시판 오픈"
                                />
                                <Carousel.Caption>                                
                                </Carousel.Caption>
                            </Carousel.Item>
                            
                            </Carousel>
                            </div>
                    </div>
                    </Container>
                  </div>

                
            <div className="wrapper">          
            <Container className="tab">      
            <div className="tabscont">
            <Tabs
               defaultActiveKey="information"
                id="uncontrolled-tab-example"
                className="mb-3">
                <Tab eventKey="notice" title="공지사항" className="inform">
                <ul>
                    <li><a>회원가입, 회원탈퇴 관련</a><span className='date'>2023-06-18</span></li>
                    <li><a>자막 안보이는 현상과 모바일 기기에서의 버퍼링 관련 공지</a><span className='date'>2023-06-19</span></li>
                    <li><a>커뮤니티 게시판 open!</a><span className='date'>2023-06-20</span></li>
                    <li><a>새로운 애니메이션이 추가 되었습니다</a><span className='date'>2023-06-21</span></li>
                    <li><a>서버점검 안내</a><span className='date'>2023-06-22</span></li>                    
                </ul>
                </Tab>
                
                <Tab eventKey="information" title="커뮤니티 인기게시글" className="inform">
                <ul>
                    <li><a> 1. 바이올렛누나 나죽어</a><span className='date'>2023-11-18</span></li>
                    <li><a> 2. 솔직히 원피스는 띵작이다 ㅇㅈ?</a><span className='date'>2023-11-17</span></li>
                    <li><a> 3. 보석의 나라 캐릭터중에 누가 제일 좋아? </a><span className='date'>2023-11-10</span></li>
                    <li><a> 4. 보석의 나라 굿즈 보석가격 실화냐?</a><span className='date'>2023-11-01</span></li>
                    <li><a> 5. 서울 코스프레 하러 같이갈 사람 모집~~~</a><span className='date'>2023-10-24</span></li>                       
                  </ul>
                </Tab>                
            </Tabs>
            </div>
            </Container>
            </div>
         
                 
            {/* react jquery 적용 예시 */}
            <div className="content1">
                <Container className="ccont1">
                <p className="mainp1">새로들어온 애니메이션</p>
                
                    <img className="d-block1 "
                                src="/images/photo1.jpg"
                                alt="너의 이름은" />
                
                    <img className="d-block2"
                                src="/images/photo7.jpg"
                                alt="귀멸의 칼날" />
                
                    <img className="d-block3"
                                src="/images/phto12.jpg"
                                alt="토이스토리"/>
                </Container>    
           
            <Container className="ccont2">
                <p className="ccont2p1">너의 이름은</p>
                 <p className="ccont2p2">귀멸의 칼날</p>
                 <p className="ccont2p3">토이스토리</p>
                </Container>
                </div>

                <div className="content3">
                <Container className="ccont3">                
                    <img className="d-block1 "
                                src="/images/photo3.jpg"
                                alt="슬램 덩크" />
                
                    <img className="d-block2"
                                src="/images/photo8.jpg"
                                alt="소드아트 온라인" />
                
                    <img className="d-block3"
                                src="/images/photo11.jpg"
                                alt="너에게 닿기를"/>
                </Container>    
           
            <Container className="ccont4">
                <p className="ccont4p4">슬램 덩크</p>
                 <p className="ccont4p5">소드아트 온라인</p>
                 <p className="ccont4p6">너에게 닿기를</p>
                </Container>
            </div>



                
    </>     
    );
    
};

export default Home;
