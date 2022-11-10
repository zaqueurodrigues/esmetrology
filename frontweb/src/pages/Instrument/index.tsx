import InstrumentCard from "components/InstrumentCard";
import './styles.css';

const Instrument = () => {
    return (
        <div className="my-4">
            <h1>Instrumentos</h1>
            <InstrumentCard/>
            <InstrumentCard/>
            <InstrumentCard/>
            <InstrumentCard/>
            <InstrumentCard/>
            <InstrumentCard/>
            <InstrumentCard/>
            <InstrumentCard/>
        </div>
    );
}

export default Instrument;