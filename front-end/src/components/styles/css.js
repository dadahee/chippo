import styled from '@emotion/styled';

const Header = styled.header`
    color : #5078E7;
    font-size : 32px;
    font-weight: bold;
    font-style: italic; 
    padding : 10px;
    border-bottom: 1px solid #5078E7;
`

const LoginPage = styled.div`
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

const NaverLoginButton = styled.button`
    padding: 0.6em 1.0em;
    border-radius: 0.25em;
    font-size: 0.8rem;
    margin-top: 0.7em;
    
    display: flex;
    align-items: center;
    font-weight: 600;
    box-shadow: 0 3px 10px rgb(0 0 0 / 0.2);
    background-color: #03C75A;
    color: white;
`

const NaverLoginImage = styled.img`
    position : relative;
    height : 1.8rem;
    width : 2.0rem;
    left : -8px;

`

export {
    Header,
    LoginPage,
    NaverLoginButton,
    NaverLoginImage,

}