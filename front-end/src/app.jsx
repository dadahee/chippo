import React from 'react';
import { 
    BrowserRouter as Router, 
    Routes,
    Route, 
} from 'react-router-dom';

import Home from './pages/home.jsx';
import Login from './pages/login.jsx';
import InterviewList from './pages/interviewList.jsx';
import CardNews from './pages/cardNews.jsx';
import CardNewsAnswer from './pages/cardNewsAnswer.jsx';
import MyPage from "./pages/myPage.jsx"
import Writing from './pages/writing.jsx';
import MyWritePage from './pages/myWritePage.jsx';
import MyLikePage from './pages/myLikePage.jsx';
import MyWithdrawlPage from './pages/myWithdrawlPage.jsx';
import MyRevisedPage from './pages/myRevisedPage.jsx';
import ErrorPage404 from './pages/ErrorPage404.jsx';
import ErrorPage403 from "./pages/ErrorPage403.jsx";
import ErrorPage401 from './pages/ErrorPage401.jsx';
import ErrorPage400 from './pages/ErrorPage400.jsx';

import ChippoHeader from './components/header.jsx';

function App(){
    return (
        <Router>
            <ChippoHeader />
            <Routes>
                <Route path = "/" element = {<Home />} />
                <Route path = "/login" element = {<Login />} />
                <Route path = "/interviews" element = {<InterviewList />} /> 
                <Route path = "/interviews/:interviewId/pre-answer" element = {<CardNews />} /> 
                <Route path = "/interviews/:interviewId/answer" element = {<CardNewsAnswer />} /> 
                <Route path = "/username" element = {<MyPage />} />
                <Route path = "/username/myWritePage" element = {<MyWritePage />} />
                <Route path = "/writing" element = {<Writing />} />
                <Route path = "/username/myLikePage" element = {<MyLikePage />} />
                <Route path = "/username/myWithdrawlPage" element = {<MyWithdrawlPage />} />
                <Route path = "/username/myRevisedPage" element = {<MyRevisedPage />} />
                <Route path = "/400" element = {<ErrorPage400 />} />
                <Route path = "/401" element = {<ErrorPage401 />} />
                <Route path = "/403" element = {<ErrorPage403 />} />
                <Route path = "/404" element = {<ErrorPage404 />} />
            </Routes>
            
        </Router>   
    );
};

export default App;