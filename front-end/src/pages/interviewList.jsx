import React, { useState }  from 'react';
import { Center, Box, VStack } from "@chakra-ui/react"
import { useParams, Route, Routes, Link } from "react-router-dom";

import { Section } from '../components/theme/common.style.js';
import CardNews from "./cardNews.jsx";

function InterviewList(){
    const params = useParams();

    const [interviewList, setinterviewList] = useState([
        {_id : 1, context : "해당 프로젝트를 할 때 리액트를 선택한 이유는 무엇인가?"},
        {_id : 2, context : "spring mvc 패턴이란 ?"},
        {_id : 3, context : "javascript의 var, const, let의 차이는 무엇입니까??"},
        {_id : 4, context : "함수형 프로그래밍에 대해 간략하게 설명해보세요"},
    ])

    return (
        <div>
            <Section>
                <Center>
                    <VStack w = "80%" spacing = {4}> 
                        <Box 
                            color = "#5078E7" w = "200px" h = "150px" 
                            textAlign = "center" lineHeight = "150px"
                            fontSize = "32px" fontWeight = "bold"
                        > 
                            {params.name} 
                        </Box>
                        {
                            interviewList.map(interview => {
                                return (

                                    <Box key = {interview._id}
                                        color = "#5078E7" fontWeight = "bold"
                                        border = "1px solid black" w = "100%" h = "100px" 
                                        pl = "10px" display = "flex" alignItems = "center"
                                        border = "5px solid #E6F0FF"
                                    >
                                        <Link to = {interview._id}  >{interview.context}</Link>
                                    </Box>   
                                    
                                    
                                )
                            })
                        }
                    </VStack>
                </Center>
            </Section>
        </div>
    )
}

export default InterviewList;