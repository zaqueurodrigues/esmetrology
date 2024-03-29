import { Router, Switch, Route, Redirect } from "react-router-dom";
import Auth from "pages/Auth";
import Instrument from "pages/Instrument";
import Department from "pages/Department";
import Certificate from "pages/Certificate";
import Lab from "pages/Lab";
import User from "pages/User";
import history from "util/history";
import PrivateRoute from "components/PrivateRoute";
import InstrumentForm from "pages/Instrument/InstrumentForm";
import UserForm from "pages/User/UserForm";


const Routes = () => (
   
        <Router history={history}>
            <Switch>
                <Redirect from="/" to="/login" exact />
                <Route path="/login" exact>
                    <Auth />
                </Route>

                <Route path="/instruments" exact>
                    <Instrument />
                </Route>

                <Route path="/instruments/:instrumentId" exact>
                    <InstrumentForm />
                </Route>

                <Route path="/departments">
                    <Department />
                </Route>

                <Route path="/certificates">
                    <Certificate />
                </Route>

                <PrivateRoute path="/labs">
                    <Lab />
                </PrivateRoute>

                <Route path="/users" exact>
                    <User />
                </Route>
                
                <Route path="/users/:userId" exact>
                    <UserForm />
                </Route>
            </Switch>
        </Router>
);

export default Routes;