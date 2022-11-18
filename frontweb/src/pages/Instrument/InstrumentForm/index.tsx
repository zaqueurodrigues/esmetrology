import { AxiosRequestConfig } from "axios";
import Navbar from "components/Navbar";
import { useForm, Controller } from "react-hook-form";
import { useHistory, useParams } from "react-router-dom";
import { Instrument } from "types/instrument";
import { Department } from "types/department";
import { requestBackend } from "util/requests";
import { useEffect, useState } from 'react';
import Select from "react-select";
import './styles.css';

type UrlParams = {
    instrumentId: string;
};

const InstrumentForm = () => {

    const [selectDepartment, setSelectDepartment] = useState<Department[]>([]);

    const { instrumentId } = useParams<UrlParams>();

    const isEditing = instrumentId !== 'create';

    const history = useHistory();

    const { register, handleSubmit, formState: { errors }, setValue, control } = useForm<Instrument>();

    useEffect(() => {
        requestBackend({ withCredentials: true, url: '/departments' })
            .then((response) => {
                setSelectDepartment(response.data.content);
            })
    }, []);

    useEffect(() => {
        if (isEditing) {
            requestBackend({ withCredentials: true, url: `/instruments/${instrumentId}` })
                .then((response) => {

                    const instrument = response.data as Instrument;

                    setValue('id', instrument.id);
                    setValue('tag', instrument.tag);
                    setValue('serie', instrument.serie);
                    setValue('mark', instrument.mark);
                    setValue('description', instrument.description);
                    setValue('type', instrument.type);
                    setValue('range', instrument.range);
                    setValue('frequency', instrument.frequency);
                    setValue('lastCalibration', instrument.lastCalibration);
                    setValue('status', instrument.status);
                    setValue('note', instrument.note);
                    setValue('department', instrument.department);
                });
        }
    }, [isEditing, instrumentId, setValue]);

    const onSubmit = (formData: Instrument) => {

        const config: AxiosRequestConfig = {
            method: isEditing ? 'PUT' : 'POST',
            url: isEditing ? `/instruments/${instrumentId}` : '/instruments',
            withCredentials: true,
            data: formData
        }
        requestBackend(config)
            .then(response => {
                history.push('/instruments');
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
                                <div className="margin-botton-30">

                                    <Controller
                                        name="department"
                                        rules={{ required: true }}
                                        control={control}
                                        render={({ field }) => (
                                            <Select {...field}
                                                placeholder="Department"
                                                options={selectDepartment}
                                                classNamePrefix="instrument-form-select"
                                                getOptionLabel={(department: Department) => department.name}
                                                getOptionValue={(department: Department) =>
                                                     String(department.id)
                                                }
                                            />
                                        )}
                                    />
                                    {errors.department && 
                                        <div className="invalid-feedback d-block">
                                            Campo Obrigatório
                                        </div>
                                    }


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
                                    {...register('note')}
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