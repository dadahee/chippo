import styled from '@emotion/styled';
import emotionReset from 'emotion-reset';

const Header = styled.header`
    color : #5078E7;
    font-size : 32px;
    font-family: 'IBM Plex Sans KR', sans-serif;
    font-weight: bold;
    font-style: italic; 
    padding : 10px;
    border-bottom: 1px solid #5078E7;
`

const Section = styled.section`
    font-size : 32px;
`

const LoginTitle = styled.div`

    height : 100vh;
    color : #5078E7;
    background-color: #E6F0FF;
    font-family: 'IBM Plex Sans KR', sans-serif;
    font-weight: bold;
    font-style: italic; 
    font-size : 72px;
    text-align : center;
    padding-top : 2em; 
`

const SectionUseBox = styled.section`
    color : #5078E7;
    font-family: 'IBM Plex Sans KR', sans-serif;
    font-weight: bold;
    font-size : 24px;
`

const SectionUseText = styled.section`
    color : #5078E7;
    font-family: 'IBM Plex Sans KR', sans-serif;
    font-size : 16px;
`

export {
    Header,
    Section,
    LoginTitle,
    SectionUseBox,
    SectionUseText,
}