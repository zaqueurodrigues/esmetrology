import ButtonBase from "components/ButtonBase";
import InstrumentCard from "components/InstrumentCard";
import Pagination from "components/Pagination";
import Search from "components/Search";
import TitleCard from "components/TitleCard";
import { Instrument } from "types/instrument";
import './styles.css';

const InstrumentPage = () => {

    const equipamento: Instrument = {
        id: 2,
        tag: '52.34.20012',
        serie: '522456-12',
        fabricante: 'Wika',
        description: 'Manômetro Analógico',
        type: 'Manômetro',
        range: '0 - 10 kgf/cm²',
        frequency: '6 meses',
        lastCalibration: '2022-97-14T10:00:00Z',
        status: 'ATIVO',
        note: 'Manômetro alocado para monitoramento da casa de bombas',
        department: {
            id: 7,
            name: 'Segurança do Trabalho',
        },
    };


    return (
        <div>
            <div className="head-content">
                <div className="title">
                    <h1>Instrumentos</h1>
                </div>
                <div className="middle-head-content">
                    <Search />
                    <ButtonBase text="Adicionar Instrumento" />
                </div>
                <TitleCard />
            </div>

            <div>
                <InstrumentCard instrument={equipamento} />
                <InstrumentCard instrument={equipamento} />
                <InstrumentCard instrument={equipamento} />
                <InstrumentCard instrument={equipamento} />
                <InstrumentCard instrument={equipamento} />
                <InstrumentCard instrument={equipamento} />
                <InstrumentCard instrument={equipamento} />
               
            </div>
            <div>
                <Pagination />
            </div>
        </div>
    );
}

export default InstrumentPage;