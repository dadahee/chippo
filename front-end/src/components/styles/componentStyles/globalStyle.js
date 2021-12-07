import { extendTheme } from '@chakra-ui/react'
import { mode, darken, whiten } from '@chakra-ui/theme-tools'

export const GlobalStyles = extendTheme({
    styles: {
      global: (props) => ({
        body : {
          fontFamily: "'IBM Plex Sans KR', sans-serif",
          color: props.colorMode === "dark" ? "white" : "black"
        },
        
        section : {},

        header : {
            color : '#5078E7',
            fontSize : '32px',
            fontStyle : 'italic',
            p : '10px',
        },

        footer : {},
      }),
    },
  })
