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
    const [equipament, setEquipament] = useState<Instrument>();

    //useEffect(() => {
     //   axios.get(`${BASE_URL}/instruments/1`)
     //       .then(response => {
     //           setEquipament(response.data)
    //        });
    //}, [id]);

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
    </div>
    );
}

export default InstrumentCard;