import React from "react";
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Nav from "./Nav";
import Home from "./Home";
import Register from "./Register";

const Router = () => {
  return (
    <div>
      <BrowserRouter>
        <Nav/>
          <Routes>
            <Route path='/' element={<Home/>}/>
            <Route path='/register' element={<Register/>}/>

          </Routes>
      </BrowserRouter>
    </div>
  );
}

export default Router;