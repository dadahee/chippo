import React, { useState }  from 'react';
import { Center, Box, VStack } from "@chakra-ui/react"
import { useParams, Link, } from "react-router-dom";

import { Section } from '../components/theme/common.style.js';
import { interviewList } from "../data.js";

function InterviewList(){
    const params = useParams();

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
                                        <Link to = {JSON.stringify(interview._id)}>{interview.context}</Link>
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