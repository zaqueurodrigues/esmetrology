import './styles.css';
import { Eye } from 'phosphor-react';
import { Link } from 'react-router-dom';

type Props = {
    link?: String;
}

const ButtonView = ( { link } : Props ) => {

    return (
        <div className="btn-container">
            <Link to={`${link}`} className="btn btn-secondary btn-view">
                <Eye size={24} className="icon-view" />
            </Link>
        </div>

    );

}

export default ButtonView;