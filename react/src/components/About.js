import React, { useEffect } from "react";
import AOS from "aos";
import Container from 'react-bootstrap/Container';
import "../css/About.css";
import "../css/aos.css";



// https://react-bootstrap.netlify.app/docs/components/buttons

const About = () => {
    useEffect(()=>{
      AOS.init({duration: 2000});
    })
  
    return ( 
      <Container className="abaout_container">
      <>
      <div className="about_borad1">
        <h1>
      <p data-aos="fade-right" className="fade_right">
        회사소개
      </p>   
      </h1>
        <p data-aos="fade-left" className="sub_1">최고의 애니메이션 중계 서비스</p>
        <p data-aos="fade-left" className="sub_2">
        AniZip는 애니메이션 분야의 지속적인 발전을 고려하여 다양한 애니메이션 중계서비스를 중점으로 혁신적인 서비스를 제공합니다. 
        최신 기술과 창의적인 솔루션을 결합하여 고객들에게 고품질의 애니메이션 반응형 웹/앱 서비스를 제공하며, 이를 통해 애니메이션 콘텐츠를 소개합니다.


      </p> 
      </div>
      <hr/>
      <Container className="about_F1">
      <img data-aos="fade-up"></img>
          <p className="Fh1" data-aos="fade-down">고객지향</p><br/>
          <p className="Fh2" data-aos="fade-down">
          고객 지향은 AniZip의 핵심 가치로, 고객의 의견을 소중히 <br /> 여기고 지속적인 피드백을 통해 서비스를 개선하고 있습니다. <br />
          AniZip은 신뢰와 소통을 강화하여 고객과의 긍정적인 관계를<br /> 구축하며, 항상 사용자들의 만족을 최우선으로 고려합니다. <br />고객들이 편안하게 서비스를 이용하고 신뢰할 수 있는 <br />파트너로서 자리매김하고자 노력하고 있습니다.</p>
      </Container>
      <hr/>
      <Container className="about_F2">
      <img data-aos="fade-up"></img>
          <p className="Fh3" data-aos="fade-down">지속성장</p><br/>
          <p className="Fh4" data-aos="fade-down">
          AniZip은 지속적인 성장을 추구하며 혁신과 개선에 주력합니다. 시장 동향을 세밀히 분석하고 유연한 전략을 통해 지속적인 성과를 창출하고 있습니다. 
          팀원들과의 긍정적인 협업과 고객 중심의 접근으로 기업의 지속적인 발전을 지원하고 있습니다.

</p>
      </Container>
      <hr/>
      <Container className="about_F3">
      <img data-aos="fade-up"></img>
          <p className="Fh5" data-aos="fade-down">상생추구</p><br/>
          <p className="Fh6" data-aos="fade-down">        
    AniZip은 상생을 추구하여 파트너 및 이해관계자들과 긍정적이고<br/> 지속적인 협력을 지향합니다. 상호 이익을 고려한 협업을 통해<br/> 지속적인 성공을 이루어내며,
    사회적 가치 창출에 기여합니다.<br/> AniZip의 비전은 지속 가능하고 공정한 경제 환경을 조성하여 모든 <br/>이해관계자들이 함께 성장하는 것에 초점을 맞추고 있습니다.</p>
      </Container>
      {/* <Container className="about_F4">
  
      </Container> */}
      </>
      </Container>
      
    );
  };
  
  export default About;