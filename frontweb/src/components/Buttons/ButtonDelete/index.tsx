import './styles.css';
import { Trash } from 'phosphor-react';
import { AxiosRequestConfig } from 'axios';
import { requestBackend } from 'util/requests';

type Props = {
    deletedId?: number;
    onDelete?: Function;
    type?: string;
};

const ButtonDelete = ({ deletedId = 0, onDelete = () => { }, type = '' }: Props) => {

    const handleDelete = (id: number) => {

        if (!window.confirm("Tem certeza que deseja apagar? " )) {
            return;
        }

        const config: AxiosRequestConfig = {
            method: "DELETE",
            url: `${type === 'instrument' ? `/instruments/${id}` : `${type === 'user' ? `/users/${id}`: '' }`}`,
            withCredentials: true
        };

        requestBackend(config).then(() => {
            onDelete();
        })

    }

    return (
        <div className="btn-container">
            <button className="btn btn-danger btn-delete" onClick={() => handleDelete(deletedId)}>
                <Trash size={24} className="icon-delete" />
            </button>
        </div>

    );

}

export default ButtonDelete;