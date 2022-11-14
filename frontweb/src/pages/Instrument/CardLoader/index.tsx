import ContentLoader from "react-content-loader";
import './styles.css';

const CardLoader = () => (
    <div className="card-loader-container">
        <ContentLoader
            speed={2}
            width={985}
            height={84}
            viewBox="0 0 985 84"
            backgroundColor="#ffffff"
            foregroundColor="#ecebeb">
            <rect x="0" y="0" rx="0" ry="0" width="100%" height="50" />
        </ContentLoader>
    </div>
)

export default CardLoader;
