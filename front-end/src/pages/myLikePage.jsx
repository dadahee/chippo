import React, { useEffect } from 'react';
import { connect } from "react-redux";

import { AiFillLike } from "react-icons/ai"
import { fetchInterviewTags } from "../redux/indexAction.js"

import { naverInterviewLists } from '../data.js';

import { Center, VStack, Button, Box, Flex, Link, HStack, Spacer } from "@chakra-ui/react";

function MyLikePage({ fetchInterviewTags, loading, interviewTags }){

    useEffect(() => fetchInterviewTags(),[]);

    return (
        <div>
            <Center>
                <Box w = "70%">
                    <Center w = "300px" h = "100px"
                        bgGradient='linear(to-r, #E6F0FF, #5078E7)' color = "black"
                    >
                        내가 좋아요한 게시물
                    </Center>
                    <VStack spacing={8} mt = "40px">
                    {
                        naverInterviewLists.interviews.map(interview => {
                            return (
                                <Box key = {interview.id}
                                fontWeight = "bold" w = "100%" h = "100px" 
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

export default connect(mapStateToProps, mapDispatchToProps)(MyLikePage);