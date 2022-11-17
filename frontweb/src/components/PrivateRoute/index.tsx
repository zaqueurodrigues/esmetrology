import { Redirect, Route } from 'react-router-dom';
import { isAuthenticated } from 'util/auth';
 
type Props = {
  children: React.ReactNode;
  path: string;
};
 
const PrivateRoute = ({ children, path }: Props) => {
 
  return (
    <Route
      path={path}
      render={({location}) =>
        isAuthenticated() ? children : <Redirect to={{
          pathname: "/login",
          state: { from: location }
        }} />
      }
    />
  );
};
 
export default PrivateRoute;