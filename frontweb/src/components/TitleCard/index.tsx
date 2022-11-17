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
                        <div className="title-card-itens">{text}</div>
                    ))}
                </div>
            </div>
            {hasAnyRoles(['ROLE_ADMIN']) ? (
                <div className="buttons-container btn-view">
                </div>
            ) : (
                <div className="buttons-container btn-view">
                </div>
            )}
        </div>

    );
}
export default TitleCard;
