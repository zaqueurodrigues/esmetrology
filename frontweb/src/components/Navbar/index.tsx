import './styles.css';
import 'bootstrap/js/src/collapse.js';

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
                    <a href="link" className="nav-item active">
                        INSTRUMENTOS
                    </a>
                </li>
                <li>
                    <a href="link" className="nav-item">
                        SETORES
                    </a>
                </li>
                <li>
                    <a href="link" className="nav-item">
                        CERTIFICADOS
                    </a>
                </li>
                <li>
                    <a href="link" className="nav-item">
                        USUÁRIOS
                    </a>
                </li>
                <li>
                    <a href="link" className="nav-item">
                        LABORATÓRIOS
                    </a>
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