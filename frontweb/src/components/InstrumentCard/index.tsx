import './styles.css';
import 'bootstrap/js/src/collapse.js';
import { Instrument } from 'types/instrument';
import { CaretDown } from 'phosphor-react';
import ButtonEdit from 'components/ButtonEdit';
import ButtonDelete from 'components/ButtonDelete';

type Props = {
    instrument: Instrument;
}

const InstrumentCard = ({ instrument }: Props) => {


    return (
        <div className="card-container">
            <div className="base-card card-header-content">
                <button data-bs-toggle="collapse" data-bs-target="#id" aria-expanded="false" aria-controls="collapseCard">
                    <CaretDown size={20} />
                </button>

                <div className="card-itens">{instrument.type}</div>
                <div className="card-itens">{instrument.tag}</div>
                <div className="card-itens">{instrument.serie}</div>
                <div className="card-itens">{instrument.status}</div>
            </div>

            <div className="collapse" id="id">
                <div className="base-card card-body">
                    <div className="card-details">
                        <div className="card-details-info-left">
                            <div className="card-itens">Descrição: {instrument.description}</div>
                            <div className="card-itens">Fabricante: {instrument.fabricante}</div>
                            <div className="card-itens">Setor: {instrument.department.name}</div>
                        </div>

                        <div className="card-details-info-right">
                            <div className="card-itens">Range: {instrument.range}</div>
                            <div className="card-itens">Frequência: {instrument.frequency}</div>
                        </div>
                    </div>

                    <div className="card-details-buttons">
                        <div className="card-itens"> <ButtonEdit /> </div>
                        <div className="card-itens"> <ButtonDelete /> </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default InstrumentCard;