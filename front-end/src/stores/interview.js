export const loadTags = (state) => {
    return (
        { type : "LOAD_INTERVIEWS", payload : state }
    )
}

export const initState = {
    interviewList : [],
};

const reducer = (state = initState, action) => {
    switch(action.type){
        case "LOAD_INTERVIEWS":
            return { ...state };
        default:
            return state;
    }
}

export default reducer;