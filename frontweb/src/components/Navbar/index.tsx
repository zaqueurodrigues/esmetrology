import './styles.css';
import 'bootstrap/js/src/collapse.js';
import { NavLink } from 'react-router-dom';

const Navbar = () => {
    return (
        <nav className="nav-container">
            {/* <button
                className="navbar-toggler" 
                type="button"
                data-bs-toggle="collapse"
                data-bs-target="#metrology-navbar"
                aria-controls="metrology-navbar"
                aria-expanded="true"
                aria-label="Toggle navigation">
                <span className="navbar-toggler-icon"></span>
            </button> */}
            <ul >
                <li>
                    <NavLink to="/instruments" className="nav-item">
                        INSTRUMENTOS
                    </NavLink> 
                </li>
                <li>
                    <NavLink to="/departments" className="nav-item">
                        SETORES
                    </NavLink> 
                </li>
                <li>
                    <NavLink to="/certificates"  className="nav-item">
                        CERTIFICADOS
                    </NavLink> 
                </li>
                <li>
                    <NavLink to="/labs"  className="nav-item">
                        LABORATÓRIOS
                    </NavLink> 
                </li>
                <li>
                    <NavLink to="/users" className="nav-item">
                        USUÁRIOS
                    </NavLink> 
                </li>
                <li>
                    <a href="link" className="nav-item user-text">
                        Oi, Zaqueu
                    </a>
                </li>
            </ul>

        </nav>
    );
}

export default Navbar;