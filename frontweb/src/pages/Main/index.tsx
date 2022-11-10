import Navbar from "components/Navbar";
import Certificate from "pages/Certificate";
import Department from "pages/Department";
import Instrument from "pages/Instrument";
import Lab from "pages/Lab";
import User from "pages/User";
import { Route, Switch } from "react-router-dom";
import './styles.css';

const Main = () => {
    return (
        <div className="main-container">
            <Navbar />
            <div className="main-content">
                <Switch>
                    <Route path="/instruments">
                        <Instrument />
                    </Route>
                    <Route path="/departments">
                        <Department />
                    </Route>
                    <Route path="/certificates">
                        <Certificate />
                    </Route>
                    <Route path="/users">
                        <User />
                    </Route>
                    <Route path="/labs">
                        <Lab />
                    </Route>
                </Switch>
            </div>
            
        </div>
    );
}

export default Main;