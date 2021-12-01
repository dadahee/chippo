import React from 'react';

import { useParams } from 'react-router';

import { Center, Box, VStack, Textarea, Container, Button, Spacer } from "@chakra-ui/react"

import { interviewList } from "../data.js";
import { SectionUseBox, SectionUseText } from '../components/theme/common.style.js';

function CardNewsAnswer(){
    const params = useParams();

    const choiceInterview = interviewList.find(interview =>{
        return interview._id === parseInt(params.interviewId)
    })

    const { answer, addInfo } = choiceInterview.answer_context.ownWriter;

    return (
        <div>
            <SectionUseBox>
                <Center>
                    <VStack w = "80%" spacing = {4}>
                        <Box w = "100%" h = "150px" color = "black"
                            bgGradient = "linear(to-r, #E6F0FF, #5078E7)"
                            display = "flex" alignItems = "center" pl = "20px" 
                        >
                            {choiceInterview.context}
                        </Box>
                    </VStack>
                </Center>
            </SectionUseBox>

            <SectionUseText>
                <Center>
                    <VStack w = "80%" spacing = {4}>
                        <Box w = "100%">
                            <Container mt = {4} maxW='container.xl'> 작성자 답안 </Container>
                            <Box bg = "#E6F0FF" h = "200px" color = "black"
                                mt = {4} borderRadius = "30px" p = "20px" 
                            > { answer }
                            </Box>

                            <Container mt = {4} maxW='container.xl'> 추가 정보 </Container>
                            <Box bg = "#E6F0FF" h = "100px" color = "black"
                                mt = {4} borderRadius = "30px" p = "20px" 
                            > { addInfo }
                            </Box>
                            
                            <Box textAlign="right">
                                <Textarea mt = {4} h = "100px" size='lg' />
                                <Button>댓글 작성하기</Button>
                            </Box>
                            
                        </Box>
                    </VStack>
                </Center>
            </SectionUseText>
        </div>
    )
}

export default CardNewsAnswer;