import { Component } from "react";

class ParentFunctionInPropsDemo  extends  Component{

    constructor(props){
        super(props);

        this.state = {
            f1 : props.pf1
        }        
    }

    g= () => {
        alert("Hi from child ");
        this.state.f1();
    }

    render(){

        return (
            <div style={{border:"solid 2px", "border-color": 'purple'} }> 
            <button onClick={this.g} >Call G (which will in turn call f1 )  </button>            
            </div>
        )
    }
}

export default ParentFunctionInPropsDemo;