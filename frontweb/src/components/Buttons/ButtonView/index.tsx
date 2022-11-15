import './styles.css';
import { Eye } from 'phosphor-react';

const ButtonView = () => {

    return (
        <div className="btn-container">
            <button className="btn btn-secondary btn-view">
                <Eye size={24} className="icon-view" />
            </button>
        </div>

    );

}

export default ButtonView;