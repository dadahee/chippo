import { 
    FETCH_TAGS_SUCCESS,
    FETCH_TAGS_FAILURE,
    FETCH_TAGS_REQEUST,
} from './types.js';

import { homeTags } from '../../data.js';

const fetchTagsSuccess = (comment) => {
    return {
        type: FETCH_TAGS_SUCCESS,
        payload : comment
    }
}

const fetchTagsFailure = (error) => {
    return {
        type : FETCH_TAGS_FAILURE,
        payload : error
    }
}

const fetchTagsRequest = () => {
    return {
        type : FETCH_TAGS_REQEUST,
    }
} 

const fetchTagApi = (homeTags) => {
    return new Promise((res, rej) => {
        if(homeTags) res(homeTags);
        else rej("에러 발생");
    })
}

export const fetchTags = () => {
    return (dispatch) => {
        dispatch(fetchTagsRequest());
        fetchTagApi(homeTags)
            .then(res => dispatch(fetchTagsSuccess(res)))
            .catch(err => dispatch(fetchTagsFailure(err)))
    }
}