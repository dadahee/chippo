import React, { useEffect } from 'react';
import { connect } from "react-redux";

import { useParams } from 'react-router';
import { useNavigate } from 'react-router-dom';
import { MdPerson } from "react-icons/md";

import { Center, Box, VStack, Button, Textarea, HStack, Spacer } from "@chakra-ui/react"

import { fetchInterviewId } from "../redux/indexAction.js"

function CardNews({ fetchInterviewId, loading, interviewId, interviewUser }){
    const params = useParams();
    const navigator = useNavigate();

    const linkToAnswerEvent = () => {
        navigator(`/interviews/${params.interviewId}/answer`);
    }

    useEffect(() => fetchInterviewId(params.interviewId),[])

    return (
        <div>
            <Center>
                <VStack w = "70%" spacing = {4}>
                    
                    <Box w = "100%" h = "100px" color = "black" fontWeight = "bold"
                        bgGradient = "linear(to-r, #E6F0FF, #5078E7)"
                        alignItems = "center" pl = "2%" pt = "20px"
                    >   
                        <Box display = "flex">
                            <MdPerson size = "1.5em"/>
                            <Box pl = "10px">{interviewUser && interviewUser.nickname}</Box>
                        </Box>
                        <Box mt = "10px">{interviewId.question}</Box>
                        
                    </Box>
                    <Textarea h = "300px" size='lg'
                        placeholder='나라면 어떻게 답변했을까요? 답변을 간단히 적어보세요' />
                </VStack>
            </Center>

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
            
            
        </div>
    )
}

const mapStateToProps = ({ interviewId }) => {
    return {
        interviewId : interviewId.items,
        interviewUser : interviewId.items.user,
    }
}

const mapDispatchToProps = {
    fetchInterviewId    
}

export default connect(mapStateToProps, mapDispatchToProps)(CardNews);