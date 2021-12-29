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
            </Routes>
            
        </Router>   
    );
};

export default App;