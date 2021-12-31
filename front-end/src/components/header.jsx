import React from 'react';
import { connect } from "react-redux";

import { useNavigate , useLocation } from 'react-router-dom';

import { Button, HStack, Image, Box, Heading } from "@chakra-ui/react";
import { Flex, Spacer } from '@chakra-ui/layout';

import { MdPerson } from "react-icons/md";

import { doLogin, doLogout } from "../redux/indexAction.js";

import { Header } from "./styles/css.js"

import DarkModeComponent from "./darkComponent.jsx";


function ChippoHeader({ logined, doLogout }){
    const { pathname } = useLocation();
    const navigator = useNavigate();

    const goHomeUrl = () => navigator("/")
    const goLoginUrl = () => navigator("/login");

    const goMyPage = () => {
        if (logined) navigator("/username")
        else navigator("/login")
    }
    const goWriting = () => {
        if (logined) navigator("/writing");
        else navigator("/login")
    }

    // 로그아웃 시 
    const goLogoutHome = () => {
        navigator("/");
        doLogout();
    }

    // 로그인 페이지 방문 시 헤더 제거
    if (window.location.pathname === "/login") return null;
    if (window.location.pathname === "/404") return null;

    return (
        <>
        <Header>
                <Flex> 
                    <HStack spacing = "24px" onClick = {goHomeUrl} 
                            cursor = "pointer" color ="#5078E7">
                        <Image 
                            objectFit="cover" 
                            boxSize="64px" 
                            src= {process.env.PUBLIC_URL + '/img/logo.png'} 
                            alt="chippo_logo" 
                        />
                        <Heading>CHIPPO</Heading>
                    </HStack>
                    <Spacer />
                    <HStack spacing = "48px">
                        <Button variant="primary" onClick = {goWriting}> 새 글 작성 </Button>
                        {
                            (logined)
                            ? 
                            ( 
                                <>
                                    <Box display = "flex" cursor= "pointer" onClick = {goMyPage}>
                                        <MdPerson size = "1.8em" />
                                        <Box pl = "20px" fontSize= "20px" cursor= "pointer">
                                            황준승
                                        </Box>
                                    </Box>
                                    
                                    <Button variant="primary" onClick = {goLogoutHome}> 
                                    로그아웃 
                                    </Button> 
                                </>
                                
                            )  
                            : <Button variant="primary" onClick = {goLoginUrl}> 로그인 </Button>   
                        }
                    </HStack>
                </Flex>
                </Header>
            <DarkModeComponent />
        </>
    )
}

const mapStateToProps = ({ logined }) => {
    return {
        logined : logined.login
    }
}

const mapDispatchToProps = {
    doLogin,
    doLogout,    
}


export default connect(mapStateToProps, mapDispatchToProps)(ChippoHeader);