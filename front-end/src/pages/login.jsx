import React, { useRef, useEffect } from 'react';
import GoogleLogin from 'react-google-login';
import NaverLogin from 'react-naver-login';

import { useNavigate } from 'react-router-dom';
import { Button, HStack, Image, Center, VStack } from "@chakra-ui/react";

import { LoginPage, NaverLoginButton, NaverLoginImage } from '../components/styles/css.js';

function Login(){
    const navigate = useNavigate();

    const loginOkBtnClick = () => {
        navigate("/username");
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
                clientId: "",
                callbackUrl: "http://localhost:3000/oauth/callback/naver",
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
                <HStack spacing = "24px">
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
                    clientId = ""
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
            
        </LoginPage>
        
    )
}

export default Login;