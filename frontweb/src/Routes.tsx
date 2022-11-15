import { Router, Switch, Route, Redirect } from "react-router-dom";
import Auth from "pages/Auth";
import InstrumentPage from "pages/Instrument";
import DepartmentPage from "pages/Department";
import CertificatePage from "pages/Certificate";
import LabPage from "pages/Lab";
import UserPage from "pages/User";
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
                    <InstrumentPage />
                </PrivateRoute>

                <PrivateRoute path="/instruments/{id}">
                    <InstrumentPage />
                </PrivateRoute>

                <PrivateRoute path="/departments">
                    <DepartmentPage />
                </PrivateRoute>

                <PrivateRoute path="/certificates">
                    <CertificatePage />
                </PrivateRoute>

                <PrivateRoute path="/labs">
                    <LabPage />
                </PrivateRoute>

                <PrivateRoute path="/users">
                    <UserPage />
                </PrivateRoute>
            </Switch>
        </Router>
);

export default Routes;