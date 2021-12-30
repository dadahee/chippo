import React, { useState, useEffect }  from 'react';
import { connect } from "react-redux";

import { Center, Box, VStack, Image, Spacer, HStack } from "@chakra-ui/react"
import { Link, useLocation } from "react-router-dom";

import { AiFillLike } from "react-icons/ai"
import { fetchInterviewTags } from "../redux/indexAction.js"

import { naverInterviewLists } from "../data.js";

function useQuery(){
    const { search } = useLocation();

    return React.useMemo(() => new URLSearchParams(search), [search]);
}

function InterviewList({ fetchInterviewTags, loading, interviewTags }){
    const query = useQuery();

    useEffect(() => fetchInterviewTags(),[])

    return (
        <div>
            <Center>
                <VStack w = "70%" spacing = {4}> 
                    <Image 
                        objectFit = "contain" 
                        htmlHeight = "200px"
                        htmlWidth = "300px"
                        src = {process.env.PUBLIC_URL + `img/${query.get("tag_type")}.png`} 
                        alt = "chippo_logo" 

                        fallback = { <Center h = "200px" fontWeight = "bold" p = "10px">{query.get("tag_type")}</Center> }
                    />
                {
                    (query.get("tag_type") === "naver") 
                    ? naverInterviewLists.interviews.map(interview => {
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
                    : interviewTags && interviewTags.map(interview => {
                        
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

export default connect(mapStateToProps, mapDispatchToProps)(InterviewList);