import './styles.css';
import 'bootstrap/js/src/collapse.js';
import { NavLink } from 'react-router-dom';
import { Article, Buildings, Calculator, Flask, SignOut, Users } from 'phosphor-react';
import { getAuthData, getTokenData, isAdmin, isAuthenticated, removeAuthData, TokenData } from 'util/requests';
import { useState, useEffect } from 'react';
import history from 'util/history';

type AuthData = {
    authenticated: boolean;
    tokenData?: TokenData;
}

const Navbar = () => {

    const [authData, setAuthData] = useState<AuthData>({authenticated: false});

    useEffect(() => {
        if (isAuthenticated()) {
            setAuthData({
                authenticated: true,
                tokenData: getTokenData()
            });
        } else {
            setAuthData({
                authenticated: false
            })
        }
    }, []);

    const handleLogoutClick = (event: React.MouseEvent<HTMLAnchorElement>) => {
        event.preventDefault();
        removeAuthData();
        setAuthData({
            authenticated: false
        })
        history.replace('/')
    }


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
                        <Calculator className="base-icon" size={32} /> INSTRUMENTOS
                    </NavLink>
                </li>
                <li>
                    <NavLink to="/departments" className="nav-item">
                        <Buildings className="base-icon" size={32} /> SETORES
                    </NavLink>
                </li>
                <li>
                    <NavLink to="/certificates" className="nav-item">
                        <Article className="base-icon" size={32} /> CERTIFICADOS
                    </NavLink>
                </li>
                {isAdmin() &&
                    <li>
                        <NavLink to="/labs" className="nav-item">
                            <Flask className="base-icon" size={32} /> LABORATÓRIOS
                        </NavLink>
                    </li>
                }
                {isAdmin() &&
                    <li>
                        <NavLink to="/users" className="nav-item">
                            <Users className="base-icon" size={32} /> USUÁRIOS
                        </NavLink>
                    </li>
                }
                <li>
                    <a href="#logout" onClick={handleLogoutClick} className="nav-item user-text">
                        {`Olá, ${authData.tokenData?.user_name}!`}
                        <SignOut className="base-icon" size={32} />
                    </a>
                </li>
            </ul>

        </nav>
    );
}

export default Navbar;