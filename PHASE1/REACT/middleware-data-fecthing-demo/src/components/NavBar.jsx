import { Link } from "react-router-dom";


const NavBar = () => {
    return (
      <nav className="navbar">
        <ul className="navbar-links">
        <li>
            <Link to="/">Home</Link>
          </li>
          <li>
            <Link to="/list-products">List Products</Link>
          </li>
          <li>
            <Link to="/weather">Weather Data</Link>
          </li>
         
          
        </ul>
      </nav>
    );
  };

  export default NavBar;
  