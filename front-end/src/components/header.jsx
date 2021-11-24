import React from 'react';
import { Button, HStack } from "@chakra-ui/react";
import { Flex, Spacer } from '@chakra-ui/layout';

import { Header, LogoImg } from './theme/header.style.js';

function ChippoHeader(){
    return (
        <Header>
            <Flex> 
                <HStack spacing = "24px">
                    <LogoImg />
                    <h1>CHIPPO</h1>
                </HStack>
                <Spacer />
                <HStack spacing = "48px">
                    <Button variant="normal"> 새 글 작성 </Button>
                    <Button variant="normal"> 로그인 </Button>   
                </HStack>
            </Flex>
        </Header>
    )
}

export default ChippoHeader;