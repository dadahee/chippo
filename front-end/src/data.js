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
const naverInterviewLists = {
    interviews : [
        {
            id : 0,
            user : {
                id : 0, 
                nickname : "구희승"
            },
            question : "가비지 컬렉션에 대해 설명해보세요",
            interviewTags : [
                {
                    id : 0,
                    type : "naver",
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
            question : "리버스 프락시란 무엇인가요?",
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
            question : "Q. Call by value, Call by reference의 차이에 대해 설명해 보세요.",
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

const idInterview = {
    "id": 0,
    "user": {
      "id": 0,
      "nickname": "구희승"
    },
    "question": "해당 프로젝트를 할 때 리액트를 선택한 이유는 무엇인가?",
    "answer": "string",
    "extraInfo": "string",
    "preAnswer": {
      "id": 0,
      "content": "string",
      "user": {
        "id": 0,
        "nickname": "string"
      },
      "updatedAt": "2021-12-13T13:43:32.050Z"
    },
    "thumb": {
      "clicked": true,
      "count": 0
    },
    "interviewTags": [
      {
        "id": 0,
        "type": "TECHSTACK",
        "name": "string"
      }
    ],
    "comments": [
      {
        "id": 0,
        "user": {
          "id": 0,
          "nickname": "string"
        },
        "content": "string",
        "updatedAt": "2021-12-13T13:43:32.050Z"
      }
    ],
    "updatedAt": "2021-12-13T13:43:32.050Z"
  }

export {
    homeTags,
    kakaoInterviewLists,
    idInterview,
    naverInterviewLists,
}