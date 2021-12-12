import React, { useState, useEffect }  from 'react';
import { connect } from "react-redux";

import { Center, Box, VStack, Image } from "@chakra-ui/react"
import { useParams, Link, useLocation } from "react-router-dom";

import { kakaoInterviewLists } from "../data.js";

function useQuery(){
    const { search } = useLocation();

    return React.useMemo(() => new URLSearchParams(search), [search]);
}

function InterviewList(){
    const query = useQuery();

    useEffect(() => {},[])

    return (
        <div>
            <Center>
                <VStack w = "80%" spacing = {4}> 
                    <Image 
                        objectFit = "contain" 
                        htmlHeight = "200px"
                        htmlWidth = "300px"
                        src = {process.env.PUBLIC_URL + `img/${query.get("tag_type")}.png`} 
                        alt = "chippo_logo" 

                        fallback = { <Center h = "200px" fontWeight = "bold" p = "10px">{query.get("tag_type")}</Center> }
                    />
                    {
                        kakaoInterviewLists.interviews.map(interview => {
                            
                            return (
                                <Box key = {interview.id}
                                    color = "#5078E7" fontWeight = "bold"
                                    border = "1px solid black" w = "100%" h = "100px" 
                                    pl = "10px" display = "flex" alignItems = "center"
                                    border = "5px solid #E6F0FF"
                                >
                                    <Link to = {`${interview.id}/pre-answer`}>{interview.question}</Link>
                                </Box>
                            )   
                        })
                    }
                </VStack>
            </Center>
            
        </div>
    )
}

export default InterviewList;