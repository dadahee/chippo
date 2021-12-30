import React from 'react';

import { useNavigate } from 'react-router-dom';

import { Image, Box, Center , VStack, Button, HStack } from '@chakra-ui/react'

function ErrorPage401(){
    const navigator = useNavigate();

    const goLoginUrl = () => {
        navigator("/login")
    }

    return (
        <Center>
              <Image
                minW = "100%"
                minH = "100%"
                left = {0}
                right = {0}
                top = {0}
                bottom = {0}
                position= "fixed"
                objectFit= "cover"
                src= {process.env.PUBLIC_URL + '/img/401.png'} 
              />

              
              <VStack 
                spacing={20}
                position = "absolute"
                color = "white"
                fontFamily = "'IBM Plex Sans KR', sans-serif"
                top = "200px"
                fontWeight= "bold"
              >
                <Box fontSize = "48px">
                    아직 파도가 되기 전
                </Box>
                <Box fontSize = "20px">
                    요청하신 액션은 로그인이 필요해요. 
                    지금 5초만에 로그인 해보세요. 
                    (에러코드: 401)
                </Box>

                <HStack spacing={20}>
                    <Button variant="primary" w = "200px" onClick={goLoginUrl}>로그인페이지로</Button>
                </HStack>
                
              </VStack>
              
        </Center>
    )
}

export default ErrorPage401;