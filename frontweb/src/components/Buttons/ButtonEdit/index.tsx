import './styles.css';
import { Gear } from 'phosphor-react';
import { isAdmin } from 'util/requests';

const ButtonEdit = () => {

    return (
        <div className="btn-container">
            <button className="btn btn-primary btn-edit">
                <Gear size={24} className="icon-edit" />
            </button>
        </div>

    );

}

export default ButtonEdit;