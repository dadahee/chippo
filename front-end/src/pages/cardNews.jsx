import React from 'react';
import { useParams } from 'react-router';
import { useNavigate } from 'react-router-dom';

import { Center, Box, VStack, Button, Textarea, HStack, Spacer } from "@chakra-ui/react"

import { SectionUseBox } from '../components/theme/common.style.js';

function CardNews(){
    const params = useParams();
    const navigator = useNavigate();

    const linkToAnswerEvent = () => {
        navigator(`/interviews/${params.interviewId}/answer`);
    }

    return (
        <div>
            <SectionUseBox>
                <Center>
                    <VStack w = "70%" spacing = {4}>
                        <Box w = "100%" h = "100px" color = "black"
                            bgGradient = "linear(to-r, #E6F0FF, #5078E7)"
                            display = "flex" alignItems = "center" pl = "10px" 
                        >
                        
                        </Box>
                        <Textarea h = "300px" size='lg'
                         placeholder='나라면 어떻게 답변했을까요? 답변을 간단히 적어보세요' />

                    </VStack>
                    
                </Center>
            </SectionUseBox>

            <SectionUseBox>
                <Center>
                    <HStack w = "70%" spacing = {4} mt = {5}>
                        <Spacer />
                        <Button 
                            w = "200px" variant = "primary"
                            onClick = {linkToAnswerEvent}
                        >
                            작성자 답변 보기
                        </Button>
                        <Button 
                            w = "200px" variant = "primary"
                            onClick = {linkToAnswerEvent}
                        >
                            내 답변 제출하기
                        </Button>
                    </HStack>
                </Center>
            </SectionUseBox>
            
        </div>
    )
}

export default CardNews;