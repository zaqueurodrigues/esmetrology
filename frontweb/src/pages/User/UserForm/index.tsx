import { AxiosRequestConfig } from "axios";
import { toast } from 'react-toastify';
import Navbar from "components/Navbar";
import { useForm, Controller } from "react-hook-form";
import { useHistory, useParams } from "react-router-dom";
import { Department } from "types/department";
import { requestBackend } from "util/requests";
import { useEffect, useState } from 'react';
import Select from "react-select";
import { User } from "types/users";
import { Roles } from "types/roles";

type UrlParams = {
    userId: string;
};

const UserForm = () => {

    const [selectDepartment, setSelectDepartment] = useState<Department[]>([]);
    const [selectRoles, setSelectRoles] = useState<Roles[]>([]);

    const { userId } = useParams<UrlParams>();

    const isEditing = userId !== 'create';

    const history = useHistory();

    const { register, handleSubmit, formState: { errors }, setValue, control } = useForm<User>();


    useEffect(() => {
        requestBackend({ withCredentials: true, url: '/departments' })
            .then((response) => {
                setSelectDepartment(response.data.content);
            })
    }, []);

    useEffect(() => {
        requestBackend({ withCredentials: true, url: '/roles' })
            .then((response) => {
                setSelectRoles(response.data);
            })
    }, []);

    useEffect(() => {
        if (isEditing) {
            requestBackend({ withCredentials: true, url: `/users/${userId}` })
                .then((response) => {

                    const user = response.data as User;

                    setValue('id', user.id);
                    setValue('name', user.name);
                    setValue('email', user.email);
                    setValue('department', user.department);
                    setValue('enrollment', user.enrollment);
                    setValue('password', user.password);
                    setValue('roles', user.roles);

                });
        }
    }, [isEditing, userId, setValue]);

    const onSubmit = (formData: User) => {

        const config: AxiosRequestConfig = {
            method: isEditing ? 'PUT' : 'POST',
            url: isEditing ? `/users/${userId}` : '/users',
            withCredentials: true,
            data: formData
        }
        requestBackend(config)
            .then(response => {
                toast.success('Usuário salvo com sucesso!', {
                    autoClose: 2000,
                    pauseOnHover: false,
                    hideProgressBar: true
                })
                history.push('/users');
            })
            .catch(() => {
                toast.error('Erro ao salvar o Usuário', {
                    autoClose: 2000,
                    pauseOnHover: false,
                    hideProgressBar: true
                })
            })
    };

    const handleCancel = () => {
        history.push('/users');
    }

    return (
        <div className="page-container">
            <div className="page-nav-container">
                <Navbar />
            </div>
            <div className="page-content">
                <div className="base-card instrument-form-card">
                    <h1 className="instrument-form-title">Dados do Usuário</h1>

                    <form onSubmit={handleSubmit(onSubmit)}>
                        <div className="row instrument-form-inputs">
                            <div className="col-lg-6 instrument-form-inputs-left">
                                <div className="margin-botton-30">
                                    <input
                                        {...register('name', {
                                            required: 'Campo Obrigatório',

                                        })}
                                        type="text"
                                        className={`form-control base-input ${errors.name ? 'is-invalid' : ''}`}
                                        placeholder="Nome"
                                        name="name"
                                    />
                                    <div className="invalid-feedback d-block">{errors.name?.message}</div>
                                </div>
                                <div className="margin-botton-30">
                                    <input
                                        {...register('enrollment', {
                                            required: 'Campo Obrigatório',

                                        })}
                                        type="text"
                                        className={`form-control base-input ${errors.enrollment ? 'is-invalid' : ''}`}
                                        placeholder="Matrícula"
                                        name="enrollment"
                                    />
                                    <div className="invalid-feedback d-block">{errors.enrollment?.message}</div>
                                </div>
                                <div className="mb-2">
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
                                        {...register('email', {
                                            required: 'Campo Obrigatório',
                                            pattern: {
                                                value: /^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}$/i,
                                                message: 'Email inválido'
                                              }
                                        })}
                                        type="text"
                                        className={`form-control base-input ${errors.email ? 'is-invalid' : ''}`}
                                        placeholder="Email"
                                        name="email"
                                    />
                                    <div className="invalid-feedback d-block">{errors.email?.message}</div>
                                </div>

                                { !isEditing &&
                                     <div className="margin-botton-30">
                                     <input
                                         {...register('password', {
                                             required: 'Campo Obrigatório',
 
                                         })}
                                         type="text"
                                         className={`form-control base-input ${errors.password ? 'is-invalid' : ''}`}
                                         placeholder="Senha provisória"
                                         name="password"
                                     />
                                     <div className="invalid-feedback d-block">{errors.password?.message}</div>
                                 </div> 

                                }
                               
                                <div className="margin-botton-30">
                                    <Controller
                                        name="roles"
                                        rules={{ required: true }}
                                        control={control}
                                        render={({ field }) => (
                                            <Select {...field}
                                                placeholder="Permissões"
                                                options={selectRoles}
                                                isMulti
                                                classNamePrefix="instrument-form-select"
                                                getOptionLabel={(role: Roles) => role.authority}
                                                getOptionValue={(role: Roles) =>
                                                    String(role.id)
                                                }
                                            />
                                        )}
                                    />
                                    {errors.roles &&
                                        <div className="invalid-feedback d-block">
                                            Campo Obrigatório
                                        </div>
                                    }
                                </div>
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

export default UserForm;