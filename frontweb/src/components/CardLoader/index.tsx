import ContentLoader from "react-content-loader";
import './styles.css';

const CardLoader = () => (
    <div className="card-loader-container">
        <ContentLoader
            viewBox="0 0 400 160"
            height={160}
            width={400}
            backgroundColor="transparent"
        >
            <circle cx="150" cy="86" r="8" />
            <circle cx="194" cy="86" r="8" />
            <circle cx="238" cy="86" r="8" />
        </ContentLoader>
    </div>
)

export default CardLoader;
