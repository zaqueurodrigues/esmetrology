import './styles.css';
import { Trash } from 'phosphor-react';
import { AxiosRequestConfig } from 'axios';
import { requestBackend } from 'util/requests';

type Props = {
    deletedId?: number;
};

const ButtonDelete = ( { deletedId = 0 } : Props ) => {

    const handleDelete = (id: number) => {

        if (!window.confirm("Deseja apagar o instrumento de id " +id)) {
            return;
        }

        const config: AxiosRequestConfig = {
            method: "DELETE",
            url: `/instruments/${id}`,
            withCredentials: true
        };

        requestBackend(config).then(() => {
            console.log("DELETED ID " +id);
        })

    }

    return (
        <div className="btn-container">
            <button className="btn btn-danger btn-delete" onClick={() => handleDelete(deletedId) }>
                <Trash size={24} className="icon-delete" />
            </button>
        </div>

    );

}

export default ButtonDelete;