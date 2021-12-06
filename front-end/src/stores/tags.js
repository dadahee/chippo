export const loadTags = (state) => {
    return (
        { type : "LOAD_TAGS", payload : state }
    )
}

export const initState = {
    tabList : [],
    companyImages : [],
    stackImages : [],
    jobImages : [],  
}

const reducer = (state = initState, action) => {
    switch(action.type){
        case "LOAD_TAGS":
            return { ...state };
        default:
            return state;
    }
}

export default reducer;