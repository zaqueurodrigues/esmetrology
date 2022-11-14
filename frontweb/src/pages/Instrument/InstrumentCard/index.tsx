import 'bootstrap/js/src/collapse.js';
import { Instrument } from 'types/instrument';
import ButtonEdit from 'components/Buttons/ButtonEdit';
import ButtonDelete from 'components/Buttons/ButtonDelete';
import { useEffect, useState } from 'react';
import axios from 'axios';
import { BASE_URL } from 'util/requests';
import { useParams } from 'react-router-dom';
import BaseCard from 'components/BaseCard';
import './styles.css';

type Props = {
    instrument: Instrument;
}

type UrlParams = {
    id: string;
}

const InstrumentCard = ({ instrument }: Props) => {

    const { id } = useParams<UrlParams>();
    const [equipament, setInstrument] = useState<Instrument>();

    useEffect(() => {
        axios.get(`${BASE_URL}/instruments/${id}`)
            .then(response => {
                setInstrument(response.data)
            });
    }, [id]);

    return (
        <div className="card-container">
            <BaseCard columns={
                [
                    `${instrument?.type}`,
                    `${instrument?.tag}`,
                    `${instrument?.serie}`,
                    `${instrument?.status}`,
                ]
            } />

        <div className="collapse" id="id">
            <div className="base-card card-body">
                <div className="card-details">
                    <div className="card-details-info-left">
                        <div className="card-itens">Descrição: {equipament?.description}</div>
                        <div className="card-itens">Fabricante: {equipament?.fabricante}</div>
                        <div className="card-itens">Setor: {equipament?.department.name}</div>
                    </div>

                    <div className="card-details-info-right">
                        <div className="card-itens">Range: {equipament?.range}</div>
                        <div className="card-itens">Frequência: {equipament?.frequency}</div>
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