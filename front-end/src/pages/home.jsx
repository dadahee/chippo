import React, { useEffect, useState } from 'react';

import { Box, Center, SimpleGrid } from '@chakra-ui/layout';
import { Tabs, TabList, TabPanels, Tab, TabPanel, Image } from "@chakra-ui/react"

import { Section } from '../components/theme/common.style.js';

function Home(){
    const tabList = ["기업별", "스택별", "직무별"];

    const [ companyImages, setcompanyImages ] = useState([
        "kakao.png", 
        "naver.png", 
        "deliver.png", 
        "line.png", 
        "coupang.png"
    ]) 

    const [ stackImages, setstackImage ] = useState([]);

    const [ jobImages, setjobImage ] = useState([]); 

    useEffect(() => {})

    return (
        <Section >
            <Center>
                <Tabs w= "80%" p = {4}>
                <TabList 
                    w = "100%" 
                    h = "50px" 
                    bgGradient = "linear(to-r, #E6F0FF, #5078E7)" >
                    {
                        tabList.map((tab) => {
                            return <Tab w = "100px">{tab}</Tab>
                        })
                    }
                </TabList>
                <TabPanels bg = "white">
                    {
                        tabList.map((tab) => {
                            return (
                                <TabPanel>
                                    { tab === "기업별" && <HomeTabPanel images = {companyImages}/> }
                                    { tab === "스택별" && <HomeTabPanel images = {stackImages}/> }
                                    { tab === "직무별" && <HomeTabPanel images = {jobImages}/> }
                                </TabPanel>
                            )
                                
                        })
                    }
                </TabPanels>
                </Tabs>
            </Center>
        </Section>
    )
}

function HomeTabPanel({ images }){
    return (
        <SimpleGrid columns = {3} spacing = {8} minChildWidth = "30%">
            {
                images.map((img) => {
                    return (
                        <Image 
                            objectFit="contain" 
                            htmlHeight = "200px"
                            htmlWidth = "300px"
                            src= {process.env.PUBLIC_URL + `img/company/${img}`} 
                            alt="chippo_logo" 
                        />
                    )
                })
            }
        </SimpleGrid>
    )
}


export default Home;