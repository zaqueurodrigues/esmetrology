import './styles.css';
import { Gear } from 'phosphor-react';
import { Link } from 'react-router-dom';

type Props = {
    link: String;
}

const ButtonEdit = ({ link } : Props) => {

    return (
        <div className="btn-container">
            <Link to={`${link}`} className="btn btn-primary btn-view">
                <Gear size={24} className="icon-edit" />
            </Link>
        </div>

    );

}

export default ButtonEdit;