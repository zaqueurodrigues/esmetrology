import ButtonBase from "components/ButtonBase";
import InstrumentCard from "components/InstrumentCard";
import { Instrument } from "types/instrument";
import './styles.css';

const InstrumentPage = () => {

    const equipamento: Instrument = {
        id: 2,
        tag: '52.34.20012',
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
        <div className="my-4">

            <div>
                <h1>Instrumentos</h1>
                <div className="middle-head-content">
                    <h1></h1>
                    <ButtonBase text="Adicionar Instrumento" />
                </div>
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
        </div>
    );
}

export default InstrumentPage;