import './styles.css';
import { Gear } from 'phosphor-react';

const ButtonEdit = () => {

    return (
        <div className="btn-container">
            <button className="btn btn-primary btn-edit">
                <Gear size={24} className="base-icon" />
                <h6>Editar</h6>
            </button>
        </div>

    );

}

export default ButtonEdit;