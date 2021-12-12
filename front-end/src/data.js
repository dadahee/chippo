const interviewList = [
    {
        _id : 1, 
        context : "해당 프로젝트를 할 때 리액트를 선택한 이유는 무엇인가?",
        answer_context : {
            ownWriter : { 
                answer : "리액트가 좋아서", 
                addInfo : "면접 분위기는 전체적으로 좋았습니다." 
            },
            other : [
                {user : "대서양돛단배", data : "리액트 밖에 몰라서...?"},
                {user : "태평양낚시배", data : "내일 면접보러 가는 데 많은 도움이 될 것 같습니다. 감사합니다!!"},
            ]
        }
    },
    {
        _id : 2, 
        context : "spring mvc 패턴이란 ?",
        answer_context : {
            ownWriter : { 
                answer : "리액트가 좋아서", 
                addInfo : "면접 분위기는 전체적으로 좋았습니다." 
            },
            other : [
                {user : "대서양돛단배", data : "리액트 밖에 몰라서...?"},
                {user : "태평양낚시배", data : "내일 면접보러 가는 데 많은 도움이 될 것 같습니다. 감사합니다!!"},
            ]
        }
    },
    {
        _id : 3, 
        context : "javascript의 var, const, let의 차이는 무엇입니까??",
        answer_context : {
            ownWriter : { 
                answer : "리액트가 좋아서", 
                addInfo : "면접 분위기는 전체적으로 좋았습니다." 
            },
            other : [
                {user : "대서양돛단배", data : "리액트 밖에 몰라서...?"},
                {user : "태평양낚시배", data : "내일 면접보러 가는 데 많은 도움이 될 것 같습니다. 감사합니다!!"},
            ]
        }
    },
    {
        _id : 4, 
        context : "함수형 프로그래밍에 대해 간략하게 설명해보세요",
        answer_context : {
            ownWriter : { 
                answer : "리액트가 좋아서", 
                addInfo : "면접 분위기는 전체적으로 좋았습니다." 
            },
            other : [
                {user : "대서양돛단배", data : "리액트 밖에 몰라서...?"},
                {user : "태평양낚시배", data : "내일 면접보러 가는 데 많은 도움이 될 것 같습니다. 감사합니다!!"},
            ]
        }
    },
];

const kakaoInterviewLists = {
    interviews : [
        {
            id : 0,
            user : {
                id : 0, 
                nickname : "구희승"
            },
            question : "해당 프로젝트를 할 때 리액트를 선택한 이유는 무엇인가?",
            interviewTags : [
                {
                    id : 0,
                    type : "kakao",
                    name : "string"
                }
            ],
            thumbCount : 0,
            updatedAt : "2021-12-03"
        },
        {
            id : 1,
            user : {
                id : 0, 
                nickname : "구다희"
            },
            question : "spring mvc 패턴이란 ?",
            interviewTags : [
                {
                    id : 0,
                    type : "kakao",
                    name : "string"
                }
            ],
            thumbCount : 1,
            updatedAt : "2021-12-03"
        },
        {
            id : 2,
            user : {
                id : 0, 
                nickname : "정재원"
            },
            question : "javascript의 var, const, let의 차이는 무엇입니까??",
            interviewTags : [
                {
                    id : 0,
                    type : "kakao",
                    name : "string"
                }
            ],
            thumbCount : 2,
            updatedAt : "2021-12-03"
        },
        {
            id : 3,
            user : {
                id : 0, 
                nickname : "황준승"
            },
            question : "함수형 프로그래밍에 대해 간략하게 설명해보세요",
            interviewTags : [
                {
                    id : 0,
                    type : "kakao",
                    name : "string"
                }
            ],
            thumbCount : 3,
            updatedAt : "2021-12-03"
        },
    ]
}

const homeTags = [
    {
        tabList : ["company", "stack", "job"],
        tags : {
            company : ["kakao", "naver", "deliver", "line", "coupang"],
            stack : ["spring", "reactjs", "nodejs", "vuejs", "django"],
            job : ["front-end","back-end","android","ios","data-engineer"], 
        }
    }
]

export {
    interviewList,
    homeTags,
    kakaoInterviewLists,
}