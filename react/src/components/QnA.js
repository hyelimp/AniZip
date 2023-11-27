import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import Accordion from 'react-bootstrap/Accordion';
import '../css/qna.css';
import { Container } from 'react-bootstrap';
import { useState } from 'react';
import Button from "react-bootstrap/Button";
import { Link } from 'react-router-dom';
import axios from 'axios';




const QnA = () => {
  const storedName = sessionStorage.getItem('name');
  const [eventTitle, setEventTitle] = useState(storedName || ''); 
  const [eventCounts, setEventCounts] = useState('');
  const [eventWriter, setEventWriter] = useState('');
  const [eventNumber, setEventNumber] = useState('');

  const handleSubmit = async () => {
    // 각 입력 필드의 상태를 확인하여 빈 값이 있는지 여부를 검사
    if (eventTitle.trim() === '') {
      alert("제목을 입력해주세요");
      return;
    }

    if (eventCounts.trim() === '') {
      alert("내용을 입력해주세요!");
      return;
    }

    if (eventWriter.trim() === '') {
      alert("이름을 입력해주세요");
      return;
    }

    if (eventNumber.trim() === '') {
      alert("번호를 입력해주세요!");
      return;
    }

    try {
      // Axios를 사용하여 Spring Boot API에 데이터 전송
      const data = {
        qnatitle: eventTitle,
        qnacontent: eventCounts,
        qnawriter: eventWriter,
        qnanumber: eventNumber
      };

      const response = await axios.post('http://localhost:9003/QnA/', data);
      
      alert("성공적으로 제출되었습니다!");
      console.log('API Response:', response.data);
      
   
      // 성공적으로 전송되면 콘솔에 응답 출력
      console.log('API Response:', response.data);
    } catch (error) {
      // 오류 발생 시 오류 내용 출력
      console.error('API Error:', error.message);
    }

  };


  

  return (
    <>
    <div className='QnA_fullbody' >
    <div className='QaA_body'>
      <Accordion className='qnaAccordion'>
        <Accordion.Item eventKey="0">
          <Accordion.Header> 신청하기전에 꼭 읽어주세요! (클릭)</Accordion.Header>
          <Accordion.Body className='accordion-body'>
            서울 코믹월드에서 열리는 행사에 참여할 코스프레 크루를 모집합니다! <br />
            열정적이고 창의적인 코스프레 팬들을 기다리고 있으며, 다양한 캐릭터와 스타일로 행사를 빛낼 분들을 환영합니다.<br />
            참가신청은 아래 양식으로만 가능하며,
            선택된 크루에는 특별 혜택과 함께 즐거운 경험을 선사할 예정입니다.
            <br />함께 서울 코믹월드를 더욱 화려하게 만들어봐요!
          </Accordion.Body>
        </Accordion.Item>
      </Accordion>
      <Container>
        <div className='secondbody'>
            <h1 className='QnATitleh2'>참가신청서</h1>
          <div className='QnATitle'>
            <h2 className='QnAmaintitle'>제목</h2>
            <div>
              <input
              placeholder='제목을 입력해 주세요'
              className='input_title'
              type='text'npm 
              value={eventTitle || ''}
              onChange={(event) => setEventTitle(event.target.value)}
            ></input>
            </div>
            <h2 className='QnAContent'>내용</h2>
            <input
              placeholder='신청하게 된 계기를 입력해 주세요'
              className='input_content'
              type='text'
              value={eventCounts || ''}
              onChange={(event) => setEventCounts(event.target.value)}
            ></input>
            <h3 className='QnAwriter'>작성자 이름</h3>
            <input
              placeholder='신청자 이름을 적어주세요. '
              className='input_writer'
              type='text'
              value={eventWriter || ''}
              onChange={(event) => setEventWriter(event.target.value)}
            ></input>
            <h4 className='QnAnumber'>작성자 전화번호</h4>
            <input
              placeholder='연락받을 전화번호를 입력해주세요'
              className='input_number'
              type='text'
              value={eventNumber || ''}
              onChange={(event) => setEventNumber(event.target.value)}
            ></input>
            <Button className='sbtn' variant="light" onClick={handleSubmit}>신청하기</Button>
          <Link to="/">
            <Button className='cbtn' variant="light" type='button'>취소</Button>
          </Link>
          </div>
         
        </div>
        
      </Container>
      
      </div>
      </div>
    </>
  );
};

export default QnA;