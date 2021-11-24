import React, { useEffect, useState } from 'react';

import { Box, Center, SimpleGrid } from '@chakra-ui/layout';
import { Tabs, TabList, TabPanels, Tab, TabPanel } from "@chakra-ui/react"

import { Section } from '../components/theme/common.style.js';

function Home(){
    // App 전체에서 state설정, redux로 관리 
    useEffect(() => {},[])

    return (
        <Section >
            <HomeTab />
        </Section>
    )
}

function HomeTab(){
    return (
        <Center>
            <Tabs w= "80%" p = {4}>
            <TabList
                w = "100%" 
                h = "50px" 
                bgGradient = "linear(to-r, #E6F0FF, #5078E7)" 
            >
                <Tab w = "100px">기업별</Tab>
                <Tab w = "100px">스택별</Tab>
                <Tab w = "100px">직무별</Tab>
            </TabList>

            <TabPanels>
                <TabPanel>
                 <HomeTabPanel />
                </TabPanel>
                <TabPanel>
                <p>two!</p>
                </TabPanel>
                <TabPanel>
                <p>three!</p>
                </TabPanel>
            </TabPanels>
            </Tabs>
            
        </Center>
    )
}

function HomeTabPanel(){
    return (
        <SimpleGrid columns = {3} spacing = {10} minChildWidth = "30%">
            <Box bg = "tomato" height = "80px" />
            <Box bg = "tomato" height = "80px" />
            <Box bg = "tomato" height = "80px" />
            <Box bg = "tomato" height = "80px" />
            <Box bg = "tomato" height = "80px" />

        </SimpleGrid>
    )
}


export default Home;