import { BrowserRouter, Switch, Route, Redirect } from "react-router-dom";
import Auth from "pages/Auth";
import InstrumentPage from "pages/Instrument";
import DepartmentPage from "pages/Department";
import CertificatePage from "pages/Certificate";
import LabPage from "pages/Lab";
import UserPage from "pages/User";

const Routes = () => (
   
        <BrowserRouter>
            <Switch>
                <Redirect from="/" to="/login" exact />
                <Route path="/login" exact>
                    <Auth />
                </Route>

                <Route path="/instruments">
                    <InstrumentPage />
                </Route>

                <Route path="/instruments/{id}">
                    <InstrumentPage />
                </Route>

                <Route path="/departments">
                    <DepartmentPage />
                </Route>

                <Route path="/certificates">
                    <CertificatePage />
                </Route>

                <Route path="/labs">
                    <LabPage />
                </Route>

                <Route path="/users">
                    <UserPage />
                </Route>
            </Switch>
        </BrowserRouter>
);

export default Routes;