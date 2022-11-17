import { AxiosRequestConfig } from "axios";
import Navbar from "components/Navbar";
import DepartmentPage from "pages/Department";
import { useForm } from "react-hook-form";
import { useHistory } from "react-router-dom";
import { Instrument } from "types/instrument";
import { requestBackend } from "util/requests";
import './styles.css';

const InstrumentForm = () => {

    const history = useHistory();

    const { register, handleSubmit, formState: { errors } } = useForm<Instrument>();

    const onSubmit = (formData: Instrument) => {

        const data = { ...formData, department: {id: 1}, departmentId: 1 }

        const config: AxiosRequestConfig = {
            method: 'POST',
            url: "/instruments",
            withCredentials: true,
            data
        }
        requestBackend(config)
            .then(response => {
                console.log(response.data)
            })
    };

    const handleCancel = () => {
        history.push('/instruments');
    }

    return (
        <div className="page-container">
            <div className="page-nav-container">
                <Navbar />
            </div>
            <div className="page-content">
                <div className="base-card instrument-form-card">
                    <h1 className="instrument-form-title">Dados do Instrumento</h1>

                    <form onSubmit={handleSubmit(onSubmit)}>
                        <div className="row instrument-form-inputs">
                            <div className="col-lg-6 instrument-form-inputs-left">
                                <div className="margin-botton-30">
                                    <input
                                        {...register('type', {
                                            required: 'Campo Obrigatório',

                                        })}
                                        type="text"
                                        className={`form-control base-input ${errors.type ? 'is-invalid' : ''}`}
                                        placeholder="Tipo de Instrumento"
                                        name="type"
                                    />
                                    <div className="invalid-feedback d-block">{errors.type?.message}</div>
                                </div>
                                <div className="mb-2">
                                </div>
                                <div className="margin-botton-30">

                                    <input
                                        {...register('tag', {
                                            required: 'Campo Obrigatório',

                                        })}
                                        type="text"
                                        className={`form-control base-input ${errors.tag ? 'is-invalid' : ''}`}
                                        placeholder="TAG"
                                        name="tag"
                                    />
                                    <div className="invalid-feedback d-block">{errors.tag?.message}</div>


                                </div>
                                <div className="margin-botton-30">

                                    <input
                                        {...register('mark', {
                                            required: 'Campo Obrigatório',

                                        })}
                                        type="text"
                                        className={`form-control base-input ${errors.mark ? 'is-invalid' : ''}`}
                                        placeholder="Fabricante"
                                        name="mark"
                                    />
                                    <div className="invalid-feedback d-block">{errors.mark?.message}</div>


                                </div>
                                <div className="margin-botton-30">

                                    <input
                                        {...register('serie', {
                                            required: 'Campo Obrigatório',

                                        })}
                                        type="text"
                                        className={`form-control base-input ${errors.serie ? 'is-invalid' : ''}`}
                                        placeholder="N° de Série"
                                        name="serie"
                                    />
                                    <div className="invalid-feedback d-block">{errors.serie?.message}</div>


                                </div>
                                <div className="margin-botton-30">

                                    <input
                                        {...register('range', {
                                            required: 'Campo Obrigatório',

                                        })}
                                        type="text"
                                        className={`form-control base-input ${errors.range ? 'is-invalid' : ''}`}
                                        placeholder="Faixa Nominal"
                                        name="range"
                                    />
                                    <div className="invalid-feedback d-block">{errors.range?.message}</div>


                                </div>
                            </div>
                            <div className="col-lg-6 margin-botton-30">
                                <div className="margin-botton-30">
                                    <input
                                        {...register('description', {
                                            required: 'Campo Obrigatório',

                                        })}
                                        type="text"
                                        className={`form-control base-input ${errors.description ? 'is-invalid' : ''}`}
                                        placeholder="Descrição"
                                        name="description"
                                    />
                                    <div className="invalid-feedback d-block">{errors.description?.message}</div>
                                </div>
                                <div className="margin-botton-30">
                                    <input
                                        {...register('frequency', {
                                            required: 'Campo Obrigatório',

                                        })}
                                        type="text"
                                        className={`form-control base-input ${errors.frequency ? 'is-invalid' : ''}`}
                                        placeholder="Frequência"
                                        name="frequency"
                                    />
                                    <div className="invalid-feedback d-block">{errors.frequency?.message}</div>
                                </div>
                                <div className="margin-botton-30">
                                    <input
                                        {...register('status', {
                                            required: 'Campo Obrigatório',

                                        })}
                                        type="text"
                                        className={`form-control base-input ${errors.status ? 'is-invalid' : ''}`}
                                        placeholder="Status"
                                        name="status"
                                    />
                                    <div className="invalid-feedback d-block">{errors.status?.message}</div>
                                </div>
                                <textarea 
                                {...register('note') }
                                name="note" 
                                placeholder="Observações" 
                                rows={5} 
                                className="base-input form-control h-auto" 
                                />
                            </div>

                            <div className="instrument-form-buttons-container">
                                <button className="btn btn-outline-danger instrument-form-button" onClickCapture={handleCancel}>CANCELAR</button>
                                <button className="btn btn-primary instrument-form-button text-white">SALVAR</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    );
}

export default InstrumentForm;