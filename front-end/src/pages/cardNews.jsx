import React from 'react';
import { useParams } from 'react-router';

import { Center, Box, VStack, Button, Textarea, HStack, Spacer } from "@chakra-ui/react"

import { interviewList } from "../data.js";
import { SectionUseBox } from '../components/theme/common.style.js';

// 오늘 아침 6시까지 
// 1. 주관식 카드 내용
// 2. 모범답안 + 유저 답안 리스트

// 3. 마이 페이지
// 4. 작성한 게시물 리스트
// 5. 좋아요한 게시물

function CardNews(){
    const params = useParams();

    const choiceInterview = interviewList.find(interview =>{
        return interview._id === parseInt(params.interviewId)
    }).context

    return (
        <div>
            <SectionUseBox>
                <Center>
                    <VStack w = "80%" spacing = {4}>
                        <Box w = "100%" h = "150px" color = "black"
                            bgGradient = "linear(to-r, #E6F0FF, #5078E7)"
                            display = "flex" alignItems = "center" pl = "10px" 
                        >
                            {choiceInterview}
                        </Box>
                        <Textarea h = "300px" size='lg'
                         placeholder='나라면 어떻게 답변했을까요? 답변을 간단히 적어보세요' />

                    </VStack>
                    
                </Center>
            </SectionUseBox>

            <SectionUseBox>
                <Center>
                    <HStack w = "80%" spacing = {4} mt = {5}>
                        <Spacer />
                        <Button w = "250px" variant = "normal">작성자 답변 보기</Button>
                        <Button w = "250px" variant = "normal">내 답변 제출하기</Button>
                    </HStack>
                </Center>
            </SectionUseBox>
            
        </div>
    )
}

export default CardNews;