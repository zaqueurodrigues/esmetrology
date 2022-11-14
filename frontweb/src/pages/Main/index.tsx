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
                    <Route path="/main/instruments">
                        <Instrument />
                    </Route>
                    <Route path="/main/instruments/:id" component={Instrument}>
                    </Route>
                    <Route path="/main/departments" >
                        <Department />
                    </Route>
                    <Route path="/main/certificates" >
                        <Certificate />
                    </Route>
                    <Route path="/main/users" >
                        <User />
                    </Route>
                    <Route path="/main/labs" >
                        <Lab />
                    </Route>
                </Switch>
            </div>

        </div>
    );
}

export default Main;