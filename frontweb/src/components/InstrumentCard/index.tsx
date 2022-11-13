import './styles.css';
import 'bootstrap/js/src/collapse.js';
import { Instrument } from 'types/instrument';
import ButtonEdit from 'components/ButtonEdit';
import ButtonDelete from 'components/ButtonDelete';
import { useEffect, useState } from 'react';
import axios from 'axios';
import { BASE_URL } from 'util/requests';
import { useParams } from 'react-router-dom';

type Props = {
    instrument: Instrument;
}

type UrlParams = {
    id: string;
}


const InstrumentCard = ( { instrument } : Props ) => {

    const { id } = useParams<UrlParams>();

    const [equipamento, setInstrument] = useState<Instrument>();

    useEffect(() => {
        axios.get(`${BASE_URL}/instruments/${id}`)
        .then(response => {
            setInstrument(response.data)
        });
    }, [id]);

    return (
        <div className="card-container">
            <div className="base-card card-header-content">
                <div className="card-itens">{instrument?.type}</div>
                <div className="card-itens">{instrument?.tag}</div>
                <div className="card-itens">{instrument?.serie}</div>
                <div className="card-itens">{instrument?.status}</div>
            </div>

            <div className="collapse" id="id">
                <div className="base-card card-body">
                    <div className="card-details">
                        <div className="card-details-info-left">
                            <div className="card-itens">Descrição: {equipamento?.description}</div>
                            <div className="card-itens">Fabricante: {equipamento?.fabricante}</div>
                            <div className="card-itens">Setor: {equipamento?.department.name}</div>
                        </div>

                        <div className="card-details-info-right">
                            <div className="card-itens">Range: {equipamento?.range}</div>
                            <div className="card-itens">Frequência: {equipamento?.frequency}</div>
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