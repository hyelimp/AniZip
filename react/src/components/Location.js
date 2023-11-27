import '../css/location.css';
import Bus from "../images_src/location_bus_icon.svg";
import Subway from "../images_src/location_subway_icon.svg";
import Nav from "../images_src/location_navigation_icon.svg";
import Park from "../images_src/location_parking_icon.svg";
import LocationImage from "../images_src/location_image.jpg";


//  맨위에 global kakao를 선언해서, kakao를 글로벌로 선언해서 사용합니다.
/* global kakao */
import React, {useEffect} from "react";
import Container from "react-bootstrap/Container";

const location_name = "AniZip";

export default function Map(){
    useEffect(()=>{
        kakaoMapScript();
    }, []);


    const kakaoMapScript = () => {
        let container = document.getElementById("map");
        let options = {
            center: new kakao.maps.LatLng(37.5030698, 126.8789856),
            level: 5,
        };
        // map 변수에 kakao map 정보를 대입해 줍니다.
        const map = new kakao.maps.Map(container, options);

        // 마커가 표시될 위치를 설정해 줍니다.
        let markerPosition = new kakao.maps.LatLng(
            37.5030698, 126.8789856
        );

        // 마커를 생성해 줍니다.
        let marker = new kakao.maps.Marker({
            position: markerPosition,
        });

        // 마커를 지도 위에 표시해 줍니다.
        marker.setMap(map);
    };

    return(
        <>
            <Container>
                <div className="location_common">
                    <h1>{location_name} 찾아오시는 길</h1>
                    {/* 카카오맵 정보가 들어올 id 속성값으로 map을 div 영역에 정의해 줍니다 */}
                    <div id="map"></div>
                    <div className="location_information">
                        <h2>LOCATION INFORMATION</h2>
                        <h2><small>애니집(AniZip) 정보</small></h2><br /><br />
                        <h3>대표전화번호</h3>
                        <h3><small>010-1234-7979</small></h3>
                        <br /> <br />   <h3>주소</h3>
                        <h3><small>(08216)서울 구로구 경인로 557 삼영빌딩 4층 401호</small></h3>
                      
                    </div>
                    <div className='location_information_add'>
                        {/* 교통(traffic) 정보 추가 */}
                        <div className='location_traffic'>
                          <div className='traffic_details'>
                            <img src={Bus} alt="버스 아이콘" />
                            <h2>버스</h2>                            
                          </div>
                        <h2><small className='traffic_h2'>구로역, 구로기계공구상가<br></br> 일반 지선버스 : 5630, 6613, 구로09 <br/>간선버스: 571, 654</small></h2>            
                        </div>
                        <div className='location_traffic'>
                            <div className='traffic_details'>
                            <img src={Subway} alt="지하철 아이콘"/>
                            <h2>지하철</h2>
                            </div>            
                            <h2><small className='traffic_h2'>1호선 구로역 하차<br></br>3번 출구로 나와서 638m 지점</small></h2>
                        </div>
                        <div className='location_traffic'>
                            <div className='traffic_details'>
                            <img src={Nav} alt="네비게이션 아이콘"/>
                            <h2>내비게이션 정보</h2>
                            </div>
                            <h2><small className='traffic_h2'>네비게이션 "AniZip" 검색</small></h2>
                        </div>
                        <div className='location_traffic'>
                            <div className='traffic_details'>
                            <img src={Park} alt="주차 아이콘"/>
                            <h2>주차안내</h2>
                            </div>
                            <h2><small className='traffic_h2'>AniZip 고객안내센터 1층 주차장 이용</small></h2>
                        </div>
                    </div>
                </div>                     
                </Container>    
                <Container>
                    <hr />
                    <div className='location_common'>
                        <h1>회사 위치 이미지 : 약도</h1>    
                        <img className='company_image' src={LocationImage}/>
                    </div>
                </Container>
             
        </>        
    );
}



