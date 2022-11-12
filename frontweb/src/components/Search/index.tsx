import './styles.css';
import { MagnifyingGlass } from 'phosphor-react';


const Search = () => {
    return (
        <div className="search-container">
            <div>
                <input type="text" placeholder="">
                </input>
            </div>
            <div className="search-icon-container">
                <button>
                    <MagnifyingGlass size="22" />
                </button> 
            </div>
        </div>
    );
}

export default Search;