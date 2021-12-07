import React, { useEffect, useState } from 'react';
import { connect } from "react-redux";

import { Link } from 'react-router-dom';

import { Center, SimpleGrid } from '@chakra-ui/layout';
import { Tabs, TabList, TabPanels, Tab, TabPanel, Image } from "@chakra-ui/react"

import { Section } from '../components/theme/common.style.js';

import { fetchTags } from "../redux/indexAction.js"

function Home({ fetchTags, loading, homeTags }){
    
    useEffect(() => {
        fetchTags();
    },[])   

    return (
        <div>
            {
                homeTags.map(tag => {
                    return (<div>
                        {JSON.stringify(tag.tabList)}
                    </div>)
                })
            }
            {/* <Center>
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
            </Center> */}
        </div>
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

const mapStateToProps = ({ homeTags }) => { 
    return {
        homeTags : homeTags.items
    }
}

const mapDispatchToProps = {
    fetchTags
}


export default connect(mapStateToProps, mapDispatchToProps)(Home);