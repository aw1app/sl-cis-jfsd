import { Component } from "react";

class Timer extends Component {

    constructor(props) {
        console.log("INSIDE constructor");

        super(props);
        this.state = {
            seconds: 0,
            maxSeconds: 15
        };
    }


    componentDidMount() {
        console.log("INSIDE componentDidMount");

        this.intervalId = setInterval(
            () => {
                this.setState(prevState => ({
                    seconds: prevState.seconds + 1
                })
                );
            }, 1000);
    }

    // This method will be called everytime the props or the state changes
    shouldComponentUpdate(nextProps, nextState) {
        console.log("INSIDE shouldComponentUpdate");

        if (nextState.seconds < this.state.maxSeconds + 1)
            return true;
        else
            return false;
    }

    // If shouldComponentUpdate returns false, then this will NOT get called for re-rendering
    render() {
        console.log("INSIDE render");

        return (
            <div style={{ border: "solid 1px", "border-color": 'orange' }}>
                <h1>Timer V2: {this.state.seconds} seconds</h1>
                <button onClick={() => this.setState({ seconds: 0 })}>Reset</button>
            </div>
        );
    }


    // When the component is destroyed, this method will get called
    // Use this method for doing some clean up work
    componentWillUnmount() {
        clearInterval(this.intervalId);
    }

}

export default Timer;