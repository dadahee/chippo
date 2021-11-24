import React from 'react';
import { Button, HStack } from "@chakra-ui/react"
import { Flex, Spacer } from '@chakra-ui/layout';

import { Header, LogoImg } from './theme/header.style.js'

function ChippoHeader(){
    return (
        <Header>
            <Flex> 
                <HStack spacing = "24px">
                    <LogoImg />
                    <div>CHIPPO</div>
                </HStack>
            <Spacer />
                <HStack spacing = "48px">
                    <Button bg = "#5078E7" color = "white">새 글 작성</Button>
                    <Button bg = "#5078E7" color = "white">로그인</Button>   
                </HStack>
            </Flex>
        </Header>
    )
}

export default ChippoHeader;