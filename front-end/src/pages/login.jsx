import React, { useRef, useEffect } from 'react';
import { connect } from "react-redux";

import GoogleLogin from 'react-google-login';

import { useNavigate } from 'react-router-dom';
import { HStack, Image, Center, VStack, Button } from "@chakra-ui/react";

import { LoginPage, NaverLoginButton, NaverLoginImage } from '../components/styles/css.js';

import { doLogin, doLogout } from "../redux/indexAction.js";

function Login({ logined, doLogin, doLogout }){
    const navigator = useNavigate();

    const goHomeUrl = () => navigator("/");

    const goLoginAndHome = () => {
        doLogin();
        goHomeUrl();
    }
    
    const responseGoogle = (response) => {
        console.log(response);
        console.log(response.profileObj);
    }

    const naverRef = useRef();

    useEffect(() => {
        const naverScript = document.createElement("script");
        naverScript.src = "https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.2.js";
        naverScript.type = "text/javascript";
        document.head.appendChild(naverScript);

        naverScript.onload = () => {
            const naverLogin = new window.naver.LoginWithNaverId({
                clientId: "0z1iMRiVzf35XmtJQDEb",
                callbackUrl: "http://localhost:3000/oauth2/authorization/naver",
                callbackHandle: true,
                isPopup: true,
                loginButton: {
                    color : "green",
                    type : 3,
                    height: 20,
                }
            });
            naverLogin.init();
            naverLogin.logout(); //네이버 로그인이 계속 유지되는 경우가 있음, 초기화시 로그아웃
        }
    }, [])

    const handleClick = () => {
        naverRef.current.children[0].click();
    }

    return (
    
        <LoginPage>
            <Center>
                <HStack spacing = "24px" onClick = {goHomeUrl} cursor = "pointer">
                    <Image 
                        objectFit="cover" 
                        boxSize="100px" 
                        src= {process.env.PUBLIC_URL + '/img/logo.png'} 
                        alt="chippo_logo" 
                    /> 
                    <h1>CHIPPO</h1>
                </HStack>
            </Center>
            <br />
            <VStack>
                
                <GoogleLogin 
                    clientId = "467415209681-9up8i9t57pl38fo1corrlo97s35ereqn.apps.googleusercontent.com"
                    buttonText = "구글 아이디로 로그인"
                    onSuccess = {responseGoogle}
                    onFailure = {responseGoogle}
                    cookiePolicy = {'single_host_origin'}
                />
                <div ref = {naverRef} id = "naverIdLogin" style = {{display : "none"}}></div>
                <NaverLoginButton onClick = {handleClick}>
                <NaverLoginImage src = {process.env.PUBLIC_URL + '/img/naverLogo.png'}/>
                    네이버 아이디로 로그인
                </NaverLoginButton>
            </VStack>
            <Button 
                variant = "primary"
                onClick = {goLoginAndHome}
            > 임시 로그인 버튼
            </Button>
        </LoginPage>
    )
}

const mapStateToProps = ({ logined }) => {
    return {
        logined : logined
    }
}

const mapDispatchToProps = {
    doLogin,
    doLogout,    
}

export default connect(mapStateToProps, mapDispatchToProps)(Login);