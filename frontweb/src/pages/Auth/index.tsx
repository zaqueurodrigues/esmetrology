import { ReactComponent as AuthImage } from 'assets/images/auth-image.svg';
import Login from './Login';
import './styles.css';


const Auth = () => {

    return (
        <div className="auth-container">
            <div className="auth-banner-container">
                <h1>ESMETROLOGY</h1>
                <AuthImage />
            </div>

            <div className="auth-form-container">
                <Login/>
            </div>
        </div>
    );
}

export default Auth;