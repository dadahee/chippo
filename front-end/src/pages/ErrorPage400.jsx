import React from 'react';

import { useNavigate } from 'react-router-dom';

import { Image, Box, Center , VStack, Button, HStack } from '@chakra-ui/react'

function ErrorPage400(){
    const navigator = useNavigate();

    const goHomeUrl = () => {
        navigator("/")
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
                  올바르지 않은 형식이에요.
                </Box>
                <Box fontSize = "20px">
                  요청을 처리하는데 실패했어요. 
                  입력하신 정보를 다시 한 번 확인해주세요. 
                  (에러코드: 400)
                </Box>

                <HStack spacing={20}>
                    <Button variant="primary" w = "200px" onClick={goHomeUrl}>홈으로</Button>
                </HStack>
                
              </VStack>
              
        </Center>
    )
}

export default ErrorPage400;