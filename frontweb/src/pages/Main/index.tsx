import Navbar from "components/Navbar";
import Instrument from "pages/Instrument";
import './styles.css';

const Main = () => {
    return (
        <div className="main-container">
            <Navbar></Navbar>
            <div className="main-content">
                <Instrument/>
            </div>
        </div>
    );
}

export default Main;