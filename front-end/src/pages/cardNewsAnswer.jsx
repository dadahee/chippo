import React, { useEffect } from 'react';
import { connect } from "react-redux";

import { useParams } from 'react-router';

import { MdPerson } from "react-icons/md";
import { Center, Box, VStack, Textarea, Container, Button } from "@chakra-ui/react"

import { fetchInterviewId } from "../redux/indexAction.js"

function CardNewsAnswer({ fetchInterviewId, loading, interviewId, interviewUser, interviewComments }){
    const params = useParams();

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
                </VStack>
            </Center>

            <Center>
                <VStack w = "70%" spacing = {4}>
                    <Box w = "100%">
                        <Container mt = {4} maxW='container.xl'> 작성자 답안 </Container>
                        <Box bg = "#E6F0FF" color = "black"
                            mt = {4} borderRadius = "30px" p = "20px" > 
                            {interviewId.answer}
                        </Box>

                        <Container mt = {4} maxW='container.xl'> 추가 정보 </Container>
                        <Box bg = "#E6F0FF" color = "black"
                            mt = {4} borderRadius = "30px" p = "20px" > 
                            {interviewId.extraInfo}
                        </Box>
                        
                        <Box textAlign="right">
                            <Textarea mt = {4} h = "100px" size='lg' />
                            <Button variant="primary">댓글 작성하기</Button>
                        </Box>
                        
                    </Box>
                </VStack>
            </Center>
        
            <Center>
                <VStack w = "70%" spacing = {4}>

                    {
                        interviewComments && interviewComments.map(comment => {
                            return (
                                <Box w = "100%" borderLeft = "5px solid #5078E7" p = "10px">
                                    <Box display = "flex">
                                        <MdPerson size = "1.5em"/>
                                        <Box pl = "10px">{comment.user.nickname}</Box>
                                    </Box>
                                    <Box mt = "10px">{comment.content}</Box>
                                </Box>
                            )
                        })
                    }
                </VStack>
            </Center>
        </div>
    )
}



const mapStateToProps = ({ interviewId }) => {
    return {
        interviewId : interviewId.items,
        interviewUser : interviewId.items.user,
        interviewComments : interviewId.items.comments,
    }
}

const mapDispatchToProps = {
    fetchInterviewId    
}

export default connect(mapStateToProps, mapDispatchToProps)(CardNewsAnswer);