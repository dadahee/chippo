import React, { useEffect, useState } from 'react';

import { Box, Center, SimpleGrid } from '@chakra-ui/layout';
import { Tabs, TabList, TabPanels, Tab, TabPanel, Image } from "@chakra-ui/react"

import { Section } from '../components/theme/common.style.js';

function Home(){
    const tabList = ["기업별", "스택별", "직무별"];
    // const [imgJson, setimgJson] = useState({});

    useEffect(() => {
        // setimgJson(homeTabDummy[0]);
    })

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
                            return <TabPanel><p>{tab}</p></TabPanel>
                        })
                    }
                </TabPanels>
                </Tabs>
            </Center>
        </Section>
    )
}

function HomeTabPanel(){
    
    return (
        <SimpleGrid columns = {3} spacing = {8} minChildWidth = "30%">
            {/* <Image 
                objectFit="contain" 
                htmlHeight = "200px"
                htmlWidth = "300px"
                src= {process.env.PUBLIC_URL + kakao.카카오이미지} 
                alt="chippo_logo" 
            /> */}

        </SimpleGrid>
    )
}


export default Home;