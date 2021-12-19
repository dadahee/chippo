import React, { useEffect } from 'react';
import { connect } from "react-redux";

import { Center, VStack, Button, Box, Flex, HStack, Spacer } from "@chakra-ui/react";
import { MdPerson } from "react-icons/md";

function MyPage({ logined }){

    if (logined === false) return (<div>로그인하셔야합니다...</div>) 

    return (
        <Center>
            <VStack spacing={16} w = "70%">
                <Flex w = "100%">
                    <MdPerson size = "2.2em"/>
                    <Box pl = "20px" pr = "100px" fontSize= "24px">
                        {/* 로그인 유저 데이터 넣기 */}
                        황준승
                    </Box>
                
                    <Button variant="primary"> 닉네임 바꾸기 </Button>
                </Flex>

                <Flex w = "100%">
                    <Center w = "300px" h = "150px"
                        bgGradient='linear(to-r, #E6F0FF, #5078E7)' color = "black"
                    >
                        내가 작성한 게시물
                    </Center>

                    <Spacer />
                    
                    <Center w = "300px" h = "150px"
                        bgGradient='linear(to-r, #E6F0FF, #5078E7)' color = "black"
                    >
                        내가 작성한 게시물
                    </Center>
                </Flex>

                <Button variant="danger"> 탈퇴하기 </Button>
            </VStack>

            
        
        </Center>
    )
}

const mapStateToProps = ({ logined }) => {
    return {
        logined : logined.login
    }
}

export default connect(mapStateToProps)(MyPage);