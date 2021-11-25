import React from 'react';
import { 
    BrowserRouter as Router, 
    Routes,
    Route, 
} from 'react-router-dom';

import Home from './routes/home.jsx';
import ChippoHeader from './components/header.jsx';
import DarkModeComponent from "./components/darkComponent.jsx"

// 1. router 다운로드 및 세팅 (0)
// 2. 차크라 ui 다운로드 (0)
// 3. 헤더 작성 구현 + 버튼 커스터 마이징(0)
// 4. 다크모드 구현 (0)
// 5. tab 구현 (0)
// 6. 사진 레이아웃 구성 (table)
// 7. 더보기 버튼 구현 ?

function App(){
    return (
        <Router>
            <ChippoHeader />
            <DarkModeComponent />
        
            <Routes>
                <Route path = "/" element = {<Home />} />
            </Routes>
            
        </Router>   
    );
};

export default App;