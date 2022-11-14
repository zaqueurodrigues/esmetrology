import { BrowserRouter, Switch, Route, Redirect } from "react-router-dom";
import Main from "pages/Main";
import Auth from "pages/Auth";

const Routes = () => (
   
        <BrowserRouter>
            <Switch>
                <Redirect from="/" to="/login" exact />
                <Route path="/login" exact>
                    <Auth />
                </Route>
                <Route path="/main">
                    <Main />
                </Route>
            </Switch>
        </BrowserRouter>
);

export default Routes;