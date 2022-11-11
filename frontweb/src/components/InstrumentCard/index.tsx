import './styles.css';
import { Instrument } from 'types/instrument';

type Props = {
    instrument: Instrument;
}

const InstrumentCard = ( { instrument } : Props) => {
    return (
        <div className="base-card inst-card">
            <li>{instrument.type}</li>
            <li>{instrument.tag}</li>
            <li>{instrument.range}</li>
            <li>{instrument.status}</li>
        </div>

    );
}

export default InstrumentCard;