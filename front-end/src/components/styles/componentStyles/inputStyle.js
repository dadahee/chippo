export const InputStyles = {
    baseStyle: {
    },
  
    variants: {
        primary : (props) => ({
            field: {

                bg : props.colorMode === "dark" ? "black" : "white",
                border: '3px solid',
                borderColor: '#5078E7',
            }
            
        })
    }
}