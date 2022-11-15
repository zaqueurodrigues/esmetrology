import { Router, Switch, Route, Redirect } from "react-router-dom";
import Auth from "pages/Auth";
import Instrument from "pages/Instrument";
import Department from "pages/Department";
import Certificate from "pages/Certificate";
import Lab from "pages/Lab";
import User from "pages/User";
import history from "util/history";
import PrivateRoute from "components/PrivateRoute";


const Routes = () => (
   
        <Router history={history}>
            <Switch>
                <Redirect from="/" to="/login" exact />
                <Route path="/login" exact>
                    <Auth />
                </Route>

                <PrivateRoute path="/instruments">
                    <Instrument />
                </PrivateRoute>

                <PrivateRoute path="/instruments/{id}">
                    <Instrument />
                </PrivateRoute>

                <PrivateRoute path="/departments">
                    <Department />
                </PrivateRoute>

                <PrivateRoute path="/certificates">
                    <Certificate />
                </PrivateRoute>

                <PrivateRoute path="/labs">
                    <Lab />
                </PrivateRoute>

                <PrivateRoute path="/users">
                    <User />
                </PrivateRoute>
            </Switch>
        </Router>
);

export default Routes;