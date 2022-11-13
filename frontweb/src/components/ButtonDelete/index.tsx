import './styles.css';
import { Trash } from 'phosphor-react';

const ButtonDelete = () => {

    return (
        <div className="btn-container">
            <button className="btn btn-danger btn-delete">
                <Trash size={24} className="base-icon" />
                <h6>Deletar</h6>
            </button>
        </div>

    );

}

export default ButtonDelete;