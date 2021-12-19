import React from 'react';
import { connect } from "react-redux";

import { useNavigate , useLocation, Link } from 'react-router-dom';

import { Button, HStack, Image, Box } from "@chakra-ui/react";
import { Flex, Spacer } from '@chakra-ui/layout';

import { MdPerson } from "react-icons/md";

import { doLogin, doLogout } from "../redux/indexAction.js";

import DarkModeComponent from "./darkComponent.jsx";


function ChippoHeader({ logined, doLogout }){

    const { pathname } = useLocation();
    const navigator = useNavigate();

    const goHomeUrl = () => navigator("/");
    const goLoginUrl = () => navigator("/login");
    const goMyPage = () => navigator(`${pathname}/myPage`)

    // 로그인 페이지 방문 시 헤더 제거
    if (window.location.pathname === "/login") return null;

    return (
        <div>
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
                        {
                            (logined)
                            ? 
                            ( 
                                <>
                                    <Box display = "flex" onClick = {goMyPage}>
                                        <MdPerson size = "1.5em"/>
                                        <Box p1 = "20px" fontSize= "20px">
                                            {/* 로그인 유저 데이터 넣기 */}
                                            황준승
                                        </Box>
                                    </Box>
                                    
                                    <Button variant="primary" onClick = {doLogout}> 
                                    로그아웃 
                                    </Button> 
                                </>
                                
                            )  
                            : <Button variant="primary" onClick = {goLoginUrl}> 로그인 </Button>   
                        }
                    </HStack>
                </Flex>
            <DarkModeComponent />
        </div>
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