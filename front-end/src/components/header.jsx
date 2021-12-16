import React, { useEffect, useRef } from 'react';
import { useNavigate , useLocation } from 'react-router-dom';

import { Button, HStack, Image } from "@chakra-ui/react";
import { Flex, Spacer } from '@chakra-ui/layout';

import { Header } from './theme/common.style.js';

import DarkModeComponent from "./darkComponent.jsx";


function ChippoHeader(){
    const navigator = useNavigate();

    const goHomeUrl = () => navigator("/");
    const goLoginUrl = () => navigator("/login");

    // 로그인 페이지 방문 시 헤더 제거
    if (window.location.pathname === "/login") return null;

    return (
        <div>
            <Header>
                <Flex> 
                    <HStack spacing = "24px" onClick = {goHomeUrl} cursor = "pointer">
                        <Image 
                            objectFit="cover" 
                            boxSize="64px" 
                            src= {process.env.PUBLIC_URL + '/img/logo.png'} 
                            alt="chippo_logo" 
                        />
                        <h1>CHIPPO</h1>
                    </HStack>
                    <Spacer />
                    <HStack spacing = "48px">
                        <Button variant="primary"> 새 글 작성 </Button>
                        <Button variant="primary" onClick = {goLoginUrl}> 로그인 </Button>   
                    </HStack>
                </Flex>
            </Header>
            <DarkModeComponent />
        </div>
    )
}

export default ChippoHeader;