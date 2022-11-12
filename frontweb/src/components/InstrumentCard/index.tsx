import './styles.css';
import { Instrument } from 'types/instrument';

type Props = {
    instrument: Instrument;
}

const InstrumentCard = ({ instrument }: Props) => {
    return (
        <div className="base-card card-container">
            <div className="card-itens">{instrument.type}</div>
            <div className="card-itens">{instrument.tag}</div>
            <div className="card-itens">{instrument.range}</div>
            <div className="card-itens">{instrument.status}</div>
        </div>
    );
}

export default InstrumentCard;