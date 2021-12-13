import React, { useEffect, useState } from 'react';
import { connect } from "react-redux";

import { Link } from 'react-router-dom';

import { Center, SimpleGrid } from '@chakra-ui/layout';
import { Tabs, TabList, TabPanels, Tab, TabPanel, Image } from "@chakra-ui/react"

import { fetchTags } from "../redux/indexAction.js"

function Home({ fetchTags, loading, homeTags }){
    
    useEffect(() => fetchTags(),[])   

    return (
        <>
            <Center>
                <Tabs w = "80%" p = {4}>
                <TabList w = "100%" h = "50px" bgGradient = "linear(to-r, #E6F0FF, #5078E7)" color = "black">
                {
                    homeTags.map(tag => {
                        return tag.tabList.map(tab => {
                            return (
                                <Tab w = "100px">
                                    {tab === "company" && "기업별"}
                                    {tab === "stack" && "스택별"}
                                    {tab === "job" && "직무별"}
                                </Tab>
                            )
                        })
                    })
                }
                </TabList>
                <TabPanels bg = "white">
                {
                    homeTags.map(hometag => {
                        const { company, stack, job } = hometag.tags;
                        
                        return hometag.tabList.map(tab => {
                            return (
                                <TabPanel>
                                    {tab === "company" &&  <HomeTabPanel images = {company} />}
                                    {tab === "stack" &&  <HomeTabPanel images = {stack} />}
                                    {tab === "job" &&  <HomeTabPanel images = {job} />}
                                </TabPanel>
                            )
                        })
 
                    })
                }

                </TabPanels>
                </Tabs>

            </Center>
        </>
    )
}

function HomeTabPanel({ images }){

    return (
        <SimpleGrid columns = {3} spacing = {8} minChildWidth = "30%" color = "black" fontSize = "24px">
            {
                images.map((img) => {
                    return (
                        <Link to = {`/interviews?tag_type=${img}`}>
                            <Image 
                                objectFit="contain" 
                                htmlHeight = "200px"
                                htmlWidth = "300px"
                                src= {process.env.PUBLIC_URL + `img/${img}.png`} 
                                alt="chippo_logo" 

                                fallback = { <Center h = "200px" fontWeight = "bold" p = "10px">{img}</Center> }
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