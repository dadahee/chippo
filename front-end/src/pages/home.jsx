import React, { useEffect, useState } from 'react';
import { useSelector, useDispatch } from 'react-redux';

import { Link } from 'react-router-dom';

import { Center, SimpleGrid } from '@chakra-ui/layout';
import { Tabs, TabList, TabPanels, Tab, TabPanel, Image } from "@chakra-ui/react"

import { Section } from '../components/theme/common.style.js';
import { loadTags } from "../stores/tags.js"

function Home(){
    const dispatch = useDispatch();

    const [tabList, settabList] = useState(["company", "stack", "job"]);
    const [companyImages, setcompanyImages] = useState([]);
    const [stackImages, setstackImages] = useState([]);
    const [jobImages, setjobImages] = useState([])
    
    useEffect(() => {
        const initState = {
            tabList : ["company", "stack", "job"],
            companyImages : [ "kakao", "naver", "deliver", "line", "coupang" ],
            stackImages : [ "spring", "reactjs", "nodejs", "vuejs", "django" ],
            jobImages : [ "front-end", "back-end", "android", "data-engineer", "ios"]  
        }

        const tags = dispatch(loadTags(initState)).payload;
        
        setcompanyImages(tags.companyImages);
        setstackImages(tags.stackImages);
        setjobImages(tags.jobImages)
    },[])


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
                        tabList.map((tab) => {
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