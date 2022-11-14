import './styles.css';

type Props = {
    columns: string[];
}

const TitleCard = ({ columns }: Props) => {

    return (
        <div className="base-card title-card-container">
            {columns.map((text) => (
                <div className="title-card-itens">{text}</div>
            ))
            }
        </div>
    );
}
export default TitleCard;
