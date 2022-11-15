import './styles.css';
import { Trash } from 'phosphor-react';

const ButtonDelete = () => {

    return (
        <div className="btn-container">
            <button className="btn btn-danger btn-delete">
                <Trash size={24} className="icon-delete" />
            </button>
        </div>

    );

}

export default ButtonDelete;