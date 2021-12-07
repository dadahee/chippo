import { extendTheme } from '@chakra-ui/react';
import { ButtonStyles as Button } from './componentStyles/buttonStyle.js';
import { GlobalStyles as styles } from './componentStyles/globalStyle.js';

export const customTheme = extendTheme({
    colors : {
        primary: "#5078E7",
        secondary: "#E6F0FF",
        danger: "#DF465D",
    },

    styles,

    components : {
        Button,
    }
}) 