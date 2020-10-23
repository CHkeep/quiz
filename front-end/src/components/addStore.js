import React from 'react';
import './addStore.css';


const URL = 'http://localhost:8080/store';
class  AddStore extends React.Component {
    state = {
        name: '',
        price: '',
        union:  '',
        picture:'url'   
      };

  handleNameChange=(event)=>{
    this.setState({
        [event.target.name]: event.target.value
    });
  }
  
  handlePriceChange=(event)=>{
    this.setState({
        [event.target.name]: event.target.value
    });
  }


  handleUnionChange=(event)=>{
    this.setState({
        [event.target.name]: event.target.value
    });
  }

  handlePictureChange=(event)=>{
    this.setState({
        [event.target.name]: event.target.value
    });
  }

  handleSubmit=(event)=>{
    event.preventDefault();     
    var client = new XMLHttpRequest();
    client.open("POST", URL, false); 
    client.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    client.send(JSON.stringify(this.state));
      
  }
  
  render() {    
    return (
      
      <div>
        <div className="title">添加商品</div>
       <form className='storeform'  onSubmit={this.handleSubmit}>
        <label>
         名称:<br/>
          <input className='input' type='text' name='name' value={this.state.name} onChange={this.handleNameChange}/>
        </label>

        <label>
          价格:<br/>
          <input className='input' type='text' name='price' value={this.state.price} onChange={this.handlePriceChange}/>
        </label> 
        
        <label>
          单位:<br/>
          <input className='input' type='text' name='union' value={this.state.union} onChange={this.handleUnionChange}/>
        </label> 

        <label>
         图片:<br/>
          <input className='input' type='text' name='picture' value={this.state.picture} onChange={this.handlePictureChange}/>
        </label>
        <input 
          className='submit' 
          type='submit'
          value='提交'
          disabled={!this.state.name 
            || !this.state.price
            || !this.state.union
            || !this.state.picture}  
          />  

      </form>
      </div>
    );
  };
}

export default AddStore;