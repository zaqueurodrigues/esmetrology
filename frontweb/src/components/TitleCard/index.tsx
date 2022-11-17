import ButtonDelete from 'components/Buttons/ButtonDelete';
import ButtonEdit from 'components/Buttons/ButtonEdit';
import ButtonView from 'components/Buttons/ButtonView';
import { hasAnyRoles } from 'util/auth';
import './styles.css';

type Props = {
    columns: string[];
}

const TitleCard = ({ columns }: Props) => {

    return (
        <div className="base-card card-header-content title-card">
            <div className="columns-container">
                <div className="columns-content">
                    {columns.map((text) => (
                        <div key={text} className="columns-itens title-card-itens">{text}</div>
                    ))}
                </div>
            </div>
            {hasAnyRoles(['ROLE_ADMIN']) ? (
                <div className="buttons-invisible">
                    <div className="buttons-container">
                        <ButtonEdit />
                        <ButtonDelete />
                    </div>
                </div>
            ) : (
                <div className="buttons-invisible">
                    <div className="buttons-container">
                        <ButtonView />
                    </div>
                </div>
            )}
        </div>

    );
}
export default TitleCard;
