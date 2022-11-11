import './styles.css';
import { PlusCircle } from 'phosphor-react';

type Props = {
    text: string;
}

const ButtonBase = ({ text }: Props) => {

    return (
        <div className="btn-container">
            <button className="btn btn-primary">
                <PlusCircle size={24} className="base-icon" />
                <h6>{text}</h6>
            </button>
        </div>

    );

}

export default ButtonBase;