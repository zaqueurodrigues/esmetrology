import './styles.css';
import { Instrument } from 'types/instrument';

type Props = {
    instrument: Instrument;
}

const InstrumentCard = ( { instrument } : Props) => {
    return (
        <div className="base-card inst-card">
            <p>{instrument.type}</p>
            <p>{instrument.tag}</p>
            <p>{instrument.range}</p>
            <p>{instrument.status}</p>
        </div>

    );
}

export default InstrumentCard;