import { extendTheme } from "@chakra-ui/react"

const theme = extendTheme({
  components: {
    Button: {
      variants: {
        "normal": {
          bg: "#5078E7",
          color : "white",
          _hover : { bg: '#E6F0FF', color: '#5078E7' }
        },
      },
    },
  },
})

export { theme }
