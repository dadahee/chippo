import React from 'react';

import { useNavigate } from 'react-router-dom';

import { Image, Box, Center , VStack, Button, HStack } from '@chakra-ui/react'

function ErrorPage403(){
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
                src= {process.env.PUBLIC_URL + '/img/403.png'} 
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
                    이런 방파제를 만났어요!!
                </Box>
                <Box fontSize = "20px">
                    요청하신 액션은 권한이 없어요. 
                    아쉽지만 이전으로 돌아가 주세요. 
                    (에러코드: 403)
                </Box>

                <HStack spacing={20}>
                    <Button variant="primary" w = "200px" onClick={goHomeUrl}>홈으로</Button>
                </HStack>
                
              </VStack>
              
        </Center>
    )
}

export default ErrorPage403;