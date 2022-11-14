import './styles.css';
import 'bootstrap/js/src/collapse.js';
import { NavLink } from 'react-router-dom';
import { Article, Buildings, Calculator, Flask, SignOut, Users } from 'phosphor-react';

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
                    <NavLink to="/main/instruments" className="nav-item">
                        <Calculator className="base-icon" size={32} /> INSTRUMENTOS
                    </NavLink>
                </li>
                <li>
                    <NavLink to="/main/departments" className="nav-item">
                        <Buildings className="base-icon" size={32} /> SETORES
                    </NavLink>
                </li>
                <li>
                    <NavLink to="/main/certificates" className="nav-item">
                        <Article className="base-icon" size={32} /> CERTIFICADOS
                    </NavLink>
                </li>
                <li>
                    <NavLink to="/main/labs" className="nav-item">
                        <Flask className="base-icon" size={32} /> LABORATÓRIOS
                    </NavLink>
                </li>
                <li>
                    <NavLink to="/main/users" className="nav-item">
                        <Users className="base-icon" size={32} /> USUÁRIOS
                    </NavLink>
                </li>
                <li>
                    <a href="link" className="nav-item user-text">
                        Oi, Zaqueu!
                        <SignOut className="base-icon" size={32} />
                    </a>
                </li>
            </ul>

        </nav>
    );
}

export default Navbar;