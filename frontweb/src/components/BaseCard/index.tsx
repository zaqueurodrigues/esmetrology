import ButtonDelete from 'components/Buttons/ButtonDelete';
import ButtonEdit from 'components/Buttons/ButtonEdit';
import ButtonView from 'components/Buttons/ButtonView';

import { hasAnyRoles } from 'util/auth';
import './styles.css';

type Props = {
    columns: string[];
    link?: string;
    deletedId?: number;
    onDelete: Function;
    type?: string;
}

const BaseCard = ({ columns, link = '', deletedId = 0, onDelete, type = ''}: Props) => {

    return (
        <div className="base-card card-header-content">
            <div className="columns-container">
                <div className="columns-content">
                    {columns.map((text) => (
                        <div key={text} className={`columns-itens ${text === 'INACTIVE' ? 'text-danger fw-bold' : ''} ${text === 'ACTIVE' ? 'text-success fw-bold' : ''}`}>
                            {text}
                        </div>
                    ))}
                </div>
            </div>
            {hasAnyRoles(['ROLE_ADMIN']) ? (
                <div className={`buttons-container`}>
                    <ButtonEdit link={link} />
                    <ButtonDelete type={type} onDelete={onDelete} deletedId={deletedId} />
                </div>
            ) : (
                <div className="buttons-container">
                    <ButtonView link={link} />
                </div>
            )}
        </div>
    );
}

export default BaseCard;