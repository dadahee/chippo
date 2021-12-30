import React from 'react';

import { useNavigate } from 'react-router-dom';

import { Image, Box, Center , VStack, Button, HStack } from '@chakra-ui/react'

function ErrorPage404(){
    const navigator = useNavigate();

    const goHomeUrl = () => {
        navigator("/")
    }

    const goBefore = () => {
        navigator(-1);
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
                src= {process.env.PUBLIC_URL + '/img/404.png'} 
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
                    파도가 길을 잃을 때가 있죠
                </Box>
                <Box fontSize = "20px">
                    요청하신 페이지/정보를 찾는데 실패했어요. 
                    하지만 걱정 말아요.
                    길을 잃었다면 다시 찾아줄게요. 
                    (에러코드: 404)
                </Box>

                <HStack spacing={20}>
                    <Button variant="primary" w = "200px" onClick={goHomeUrl}>홈으로</Button>
                </HStack>
                
              </VStack>
              
        </Center>
    )
}

export default ErrorPage404;