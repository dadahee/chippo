import React from 'react';

import { Center, VStack, Button, Box, Flex, Link, HStack, Spacer } from "@chakra-ui/react";

import { MdPerson } from "react-icons/md";

function MyWithdrawlPage(){
    return (
        <Center>
            <Box w = "70%">
                <Flex>
                    <MdPerson size = "1.8em" />
                    <Box pl = "10px" fontSize= "20px">
                        {/* 로그인 유저 데이터 넣기 */}
                        황준승 님이 나눠주신 멋진 의견이 이렇게 많아요!! 
                    </Box>
                </Flex>
                <Box pt = "20px" fontSize = "20px">한 번 더 둘러보는 건 어때요??</Box>
                
                <Center pt = "100px" fontSize= "24px" fontWeight="bold"> 지금 바로 탈퇴하실 경우 기존에 작성한 게시물은 삭제 되지 않습니다. </Center>
                <Center fontSize= "24px" fontWeight="bold"> 그래도 탈퇴 하시겠습니까? </Center>
                <Center pt= "50px">
                    <Button variant="primary">좀 더 둘러보기</Button>
                    <Button variant="danger" ml = "50px">지금 바로 탈퇴</Button>
                </Center>
            </Box>
            
        </Center>
    )
}

export default MyWithdrawlPage;