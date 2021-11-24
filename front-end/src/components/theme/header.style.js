import styled from '@emotion/styled';

import logo from './img/logo.png'

const Header = styled.header`
    color : #5078E7;
    font-size : 32px;
    font-family: 'IBM Plex Sans KR', sans-serif;
    font-weight: bold;
    font-style: italic; 
    padding : 10px;
    border-bottom: 1px solid #5078E7;
`
// 다크모드 화이트 모드 시 두 개의 버전이 필요할 수도??
const LogoImg = styled.div`
    width : 48px;
    height : 48px;
    background-image : url(${logo});
    background-size : cover;
    background-position: center;
`

export {
    Header,
    LogoImg,
}