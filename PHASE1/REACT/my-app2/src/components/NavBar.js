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
            <Link to="/product"> Show Product</Link>
          </li>
          <li>
            <Link to="/welcome"> Welcome </Link>
          </li>
          <li>
            <Link to="/timer"> Timer </Link>
          </li>
        </ul>
      </nav>
    );
  };

  export default NavBar;
  