import React from 'react';
import { 
    BrowserRouter as Router, 
    Routes,
    Route, 
} from 'react-router-dom';

import Home from './routes/home.jsx';
import ChippoHeader from './components/header.jsx';

// 1. router 다운로드 및 세팅 (0)
// 2. 차크라 ui 다운로드 (0)
// 3. 헤더 작성 구현 
// 4. nav 구현
// 5. 사진 레이아웃 구성 (table)

function App(){
    return (
        <Router>
            <ChippoHeader />
            <div>
                <Routes>
                    <Route path = "/" element = {<Home />} />
                </Routes>
            </div>
        </Router>   
    );
};

export default App;