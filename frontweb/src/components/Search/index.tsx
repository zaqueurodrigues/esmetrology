import './styles.css';
import { MagnifyingGlass } from 'phosphor-react';
import { useForm } from 'react-hook-form';

export type InstrumentFilterData = {
    tag: string;
};

type Props = {
    onSubmitFilter?: (data: InstrumentFilterData) => void;
}

const Search = ( { onSubmitFilter = () => {} } : Props) => {


    const { register, handleSubmit } = useForm<InstrumentFilterData>();

    const onSubmit = (formData: InstrumentFilterData) => {
        onSubmitFilter(formData)
    }

    return (
        <form onSubmit={handleSubmit(onSubmit)} >
            <div className="search-container">
                <input
                    {...register('tag')}
                    type="text"
                    className="input-search"
                    placeholder=""
                    name="tag"
                />
                <div className="search-icon-container">
                    <button>
                        <MagnifyingGlass size="22" />
                    </button>
                </div>
            </div>
        </form >
    );
}

export default Search;