import ButtonDelete from 'components/Buttons/ButtonDelete';
import ButtonEdit from 'components/Buttons/ButtonEdit';
import './styles.css';

type Props = {
    columns: string[];
}

const BaseCard = ({ columns }: Props) => {
    return (
        <div className="base-card card-header-content">
            <div className="columns-container">
                <div className="columns-content">
                    {columns.map((text) => (
                        <div>{text}</div>
                    ))}
                </div>
            </div>
            <div className="buttons-container">
                <ButtonEdit  />
                <ButtonDelete />
            </div>
        </div>
    );
}

export default BaseCard;