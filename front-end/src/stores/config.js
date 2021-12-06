// 액션
const increase = () => {
    return (
        { type : "INCREASE" }
    )
}

const initState = {
    number : 0,
}

const reducer = (state = initState, action) => {
    switch(action.type){
        case "INCREASE":
            return {number:state.number + 1};
        default:
            return state;
    }
}

export {
    reducer
}