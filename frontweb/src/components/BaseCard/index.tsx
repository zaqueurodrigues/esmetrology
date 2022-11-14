import './styles.css';

type Props = {
    columns: string[];
}

const BaseCard = ({ columns }: Props) => {
    return (
        <div className="base-card card-header-content">
            {columns.map((text) => (
                <div>{text}</div>
            ))}
        </div>
    );
}

export default BaseCard;