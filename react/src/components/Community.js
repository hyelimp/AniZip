import React, { Component } from 'react';
import Container from 'react-bootstrap/Container';
import ReactPlayer from "react-player";
import Button from 'react-bootstrap/Button';
import '../css/react_player.css';


// https://react-bootstrap.netlify.app/docs/components/buttons

class Community extends Component {
    render() {
        return (
            <div>
                <Container>
                <div className="videoName">
                    <h1>시원한 바다 동영상입니다!
                    <Button variant="outline-primary" href="/">홈으로Go!</Button>
                    </h1>
                </div>
                <div className='player'>
                    <ReactPlayer
                    // 컴포넌트에서 public 경로에 있는 동영상 위치 지정
                    url={process.env.PUBLIC_URL + '/video/sea.mp4'}
                    // 플레이어 크기(폭, 가로)
                    width='100%'
                    // 플레이어 크기(높이, 세로)
                    height='100%'
                    // 자동 실행 설정(true)
                    playing={true}                   
                    // 음소거 설정(true)
                    // 참고로, 자동 재생 설정은 playing과 muted를 true로 설정해야 합니다.
                    muted={true}
                    // 플레이어 컨트롤 노출 설정(true)
                    controls={true}
                    // 반복 재생 설정(true)
                    loop={true}
                    />
                </div>
                </Container>                
            </div>
     );
   }
}


export default Community;