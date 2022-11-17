import ButtonDelete from 'components/Buttons/ButtonDelete';
import ButtonEdit from 'components/Buttons/ButtonEdit';
import ButtonView from 'components/Buttons/ButtonView';

import { hasAnyRoles } from 'util/auth';
import './styles.css';

type Props = {
    columns: string[];
    link?: string;
}

const BaseCard = ({ columns, link = '' }: Props) => {
    return (
        <div className="base-card card-header-content">
            <div className="columns-container">
                <div className="columns-content">
                    {columns.map((text) => (
                        <div>{text}</div>
                    ))}
                </div>
            </div>
            {hasAnyRoles(['ROLE_ADMIN']) ? (
                <div className="buttons-container">
                    <ButtonEdit link={link} />
                    <ButtonDelete />
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