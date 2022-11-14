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
                        <div>Descrição: {equipament?.description}</div>
                        <div>Fabricante: {equipament?.fabricante}</div>
                        <div>Setor: {equipament?.department.name}</div>
                    </div>

                    <div className="card-details-info-right">
                        <div>Range: {equipament?.range}</div>
                        <div>Frequência: {equipament?.frequency}</div>
                    </div>
                </div>

                <div className="card-details-buttons">
                    <div> <ButtonEdit /> </div>
                    <div> <ButtonDelete /> </div>
                </div>
            </div>
        </div>
    </div>
    );
}

export default InstrumentCard;