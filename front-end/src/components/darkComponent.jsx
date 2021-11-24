import React from 'react';

import { IconButton } from "@chakra-ui/button";
import { useColorMode } from '@chakra-ui/color-mode';
import { FaSun, FaMoon } from "react-icons/fa"
import { Flex, Spacer } from '@chakra-ui/layout';

function DarkModeComponent(){
    const { colorMode, toggleColorMode } = useColorMode();
    
    const isDark = colorMode === "dark";

    return (
        <Flex p = {8}>
            <Spacer />
            <IconButton 
                w = "48px"
                h = "48px"
                icon = {isDark ? <FaSun /> : <FaMoon />}
                isRound = "true"
                onClick = {toggleColorMode}
            >
            </IconButton>
        </Flex>        
    )
}

export default DarkModeComponent