import { 
    FETCH_COMMENTS,
    FETCH_COMMENTS_REQEUST,
    FETCH_COMMENTS_SUCCESS,
    FETCH_COMMENTS_FAILURE 
} from "./types.js";

const fetchCommentSuccess = (comment) => {
    return {
        type: FETCH_COMMENTS_SUCCESS,
        payload : comment
    }
}

const fetchCommentsFailure = (error) => {
    return {
        type : FETCH_COMMENTS_FAILURE,
        payload : error
    }
}

const fetchCommentRequest = () => {
    return {
        type : FETCH_COMMENTS_REQEUST,
    }
} 

export const fetchComments = () => {
    return (dispatch) => {
        dispatch(fetchCommentRequest());
        fetch("https://jsonplaceholder.typicode.com/comments")
            .then(res => res.json())
            .then(comment => {
                dispatch(fetchCommentSuccess(comment));
            })
            .catch(error => {
                dispatch(fetchCommentsFailure(error));
            })

    }
}