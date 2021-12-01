import React from 'react';

import { useNavigate } from 'react-router-dom';
import { Button, HStack, Image, Center, VStack } from "@chakra-ui/react";

import { LoginTitle } from '../components/theme/common.style.js';

function Login(){
    const navigate = useNavigate();

    const loginOkBtnClick = () => {
        navigate("/username");
    }

    return (
        <div> 
            <LoginTitle>
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
                    <Button variant = "normal" onClick = {loginOkBtnClick}>구글 인증 임시</Button>
                    <Button variant = "normal" onClick = {loginOkBtnClick}>네이버 인증 임시</Button>
                </VStack>
                
            </LoginTitle>
        </div>
    )
}

export default Login;