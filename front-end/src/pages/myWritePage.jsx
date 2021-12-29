import React, { useEffect } from 'react';
import { connect } from "react-redux";

import { useNavigate } from 'react-router-dom';

import { AiFillLike } from "react-icons/ai"
import { fetchInterviewTags } from "../redux/indexAction.js"

import { Center, VStack, Button, Box, Flex, Link, HStack, Spacer } from "@chakra-ui/react";

function MyWritePage({ fetchInterviewTags, loading, interviewTags }){

    const navigator = useNavigate();

    const goMyRevisedPage = () => {
        navigator("/username/myRevisedPage")
    }

    useEffect(() => fetchInterviewTags(),[])

    return (
        <div>
            <Center>
                <Box w = "70%">
                    <Center w = "300px" h = "100px"
                        bgGradient='linear(to-r, #E6F0FF, #5078E7)' color = "black"
                    >
                        내가 작성한 게시물
                    </Center>
                    <VStack spacing={8} mt = "40px">
                    {
                        interviewTags && interviewTags.map(interview => {
                            return (
                                <Flex w = "100%">
                                <Box key = {interview.id}
                                    fontWeight = "bold" w = "80%" h = "80px" 
                                    pl = "10px" display = "flex" alignItems = "center"
                                    border = "5px solid #5078E7"
                                >
                                    <Link to = {`${interview.id}/pre-answer`}>{interview.question}</Link>
                                    <Spacer />
                                    <HStack p = "15px">
                                        <AiFillLike />
                                        <Box>{interview.thumbCount}</Box>
                                    </HStack>
                                </Box>
                                
                                <Spacer />

                                <Center w = "10%" h = "80px" bg = "#5078E7" color = "white" cursor = "pointer" onClick = {goMyRevisedPage}>
                                    수정
                                </Center>
                                </Flex>
                            )   
                        })
                    }
                    </VStack>
                </Box>
            </Center>
            
        </div>
    )
}

const mapStateToProps = ({ interviewTags }) => {
    return {
        interviewTags : interviewTags.items.interviews
    }
}

const mapDispatchToProps = {
    fetchInterviewTags    
}

export default connect(mapStateToProps, mapDispatchToProps)(MyWritePage);
