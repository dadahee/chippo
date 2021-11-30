import React, { useEffect, useState , useRef } from 'react';
import { Link } from 'react-router-dom';

import { Center, SimpleGrid } from '@chakra-ui/layout';
import { Tabs, TabList, TabPanels, Tab, TabPanel, Image } from "@chakra-ui/react"

import { Section } from '../components/theme/common.style.js';

function Home(){
    const tabList = useRef(["company", "stack", "job"]);

    const [ companyImages, setcompanyImages ] = useState([
        "kakao", 
        "naver", 
        "deliver", 
        "line", 
        "coupang"
    ]) 

    const [ stackImages, setstackImage ] = useState([
        "spring",
        "reactjs",
        "nodejs",
        "vuejs",
        "django",
    ]);

    const [ jobImages, setjobImage ] = useState([
        "front-end",
        "back-end",
        "Android",
        "data-engineer",
        "ios",
    ]); 

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
                        tabList.current.map((tab) => {
                            return (
                                <Tab w = "100px">
                                    {tab === "company" && "기업별"}
                                    {tab === "stack" && "스택별"}
                                    {tab === "job" && "직무별"}
                                </Tab>
                            )
                        })
                    }
                </TabList>
                <TabPanels bg = "white">
                    {
                        tabList.current.map((tab) => {
                            return (
                                <TabPanel>
                                    { tab === "company" && <HomeTabPanel images = {companyImages} tab = {tab}/> }
                                    { tab === "stack" && <HomeTabPanel images = {stackImages} tab = {tab}/> }
                                    { tab === "job" && <HomeTabPanel images = {jobImages} tab = {tab}/> }
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

function HomeTabPanel({ images, tab }){

    return (
        <SimpleGrid columns = {3} spacing = {8} minChildWidth = "30%">
            {
                images.map((img) => {
                    return (
                        <Link to = {`/${img}`}>
                            <Image 
                                objectFit="contain" 
                                htmlHeight = "200px"
                                htmlWidth = "300px"
                                src= {process.env.PUBLIC_URL + `img/${tab}/${img}.png`} 
                                alt="chippo_logo" 

                                fallback = { <Center h = "200px" fontWeight = "bold">{img}</Center> }
                            />
                        </Link>
                    )
                })
            }
        </SimpleGrid>
    )
}


export default Home;