import { mode, darken, whiten } from '@chakra-ui/theme-tools'

export const ButtonStyles = {
    // style object for base or default style
    baseStyle: {},

    // styles for different sizes ("sm", "md", "lg")
    sizes: {},

    // styles for different visual variants ("outline", "solid")
    variants: {
        // 다크 모드 일때 아닐 때 bg : props.colorMode === 'dark' ? 'primary' : 'secondary',
        primary: (props) => ({
            bg : "primary",
            color : "white",
            _hover : {
                bg : mode(darken("primary", 20), whiten("primary", 20))(props),
                transform : "scale(1.02)"
            },
        }),

        danger: (props) => ({
            bg : "danger",
            color : "white",
            _hover : {
                bg : mode(darken("danger", 20), whiten("danger", 20))(props),
                transform : "scale(1.02)"
            },
        }),

        
    },
    // default values for `size` and `variant`
    defaultProps: {
    },
  }