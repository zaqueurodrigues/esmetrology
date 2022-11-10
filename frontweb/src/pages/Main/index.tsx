import Navbar from "components/Navbar";
import './styles.css';

const Main = () => {
    return (
        <div className="main-container">
            <Navbar></Navbar>
            <div className="main-content">
                <h1>Conteúdo</h1>
            </div>
        </div>
    );
}

export default Main;