import { Component } from "react";

class EventHandlingDemo extends Component {

    constructor(props){
        super(props);

        this.state={
            luckyNumber:77
        };

        this.changeLuckyNumber1 = this.changeLuckyNumber1.bind(this);
    }

    changeLuckyNumber1(){
       // e.preventDefault();
        this.setState( {
            luckyNumber:this.getRandomArbitrary(1,100)
        });
    }

    // Arrow function, so no binding reqd in the constructor.
    changeLuckyNumber2 = () => {
       // e.preventDefault();
        this.setState( {
            luckyNumber:this.getRandomArbitrary(1,100)
        });
    }

    // Arrow function, so no binding reqd in the constructor.
    changeLuckyNumber3 = (evt) => {
        evt.preventDefault ();
        // alert("changeLuckyNumber3 evt TYPE = " + evt.type);
        // alert("changeLuckyNumber3 evt X = " + evt.clientX);
        // alert("changeLuckyNumber3 evt Y = " + evt.clientY);

        this.setState( {
            luckyNumber:this.getRandomArbitrary(1,100)
        });
    }

    changeLuckyNumber4 = (evt, message) => {  
        evt.preventDefault ();     
        alert("changeLuckyNumber4 mesage = " + message);
        this.setState( {
            luckyNumber:this.getRandomArbitrary(1,100)
        });
    }

    getRandomArbitrary (min, max) {
        return Math.ceil(Math.random() * (max - min) + min);
    }

    render(){

        return (
            <div style={{border:"solid 2px", "border-color": 'green'} }>
           
            <h3> luckyNumber from State: { this.state.luckyNumber }</h3>

            <button onClick={this.changeLuckyNumber1} style={{border:"solid 2px", "background-color": 'lightgreen'} }> Change lucky number  </button>
            <br/>
            <button onClick={this.changeLuckyNumber2} > Change lucky number (call arrow function) </button>
            <br/>
            <button onClick={ (event) => this.changeLuckyNumber3(event)} > Change lucky number (call arrow function passing event object) </button>
            <br/>
            <button onClick={ (event) => this.changeLuckyNumber4(event, "Hi")} > Change lucky number (passing event object and argument) </button>

            </div>
        )

    }


}

export default EventHandlingDemo;