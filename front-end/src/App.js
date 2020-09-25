import React from 'react';
// import logo from './logo.svg';
import {BrowserRouter, Link, Route, Switch} from 'react-router-dom';
import './App.css';
import Store from './components/store'
import Order from './components/order'
import AddStore from './components/addStore'


function App() {
  return (
    <div className="App">
      <header className="App-header">
      <BrowserRouter>
           <ul className='menu'>
            <li><Link to='/'>商城</Link></li>
            <li><Link to='/order'>订单</Link></li>
            <li><Link to='/addStore'>+ 添加商品</Link></li>  
          </ul>
          <div className='content'>
            <Switch>
              <Route exact path='/' component={Store} />
              <Route path='/order' component={Order} />
              <Route path='/addStore' component={AddStore} />
            </Switch> 
            </div>           
        </BrowserRouter>
      </header>
    </div>
  );
  
}

export default App;

