import './styles.css';
import { ReactComponent as ArrowIcon } from 'assets/images/arrow.svg';
import ReactPaginate from 'react-paginate';

type Props = {
    pageCount?: number;
    range?: number;
    onChange?: (pageNumber: number) => void
}


const Pagination = ( { pageCount = 10, range = 3, onChange = () => {} } : Props ) => {
    
    return (
        <>
            <ReactPaginate
                pageCount={pageCount}
                pageRangeDisplayed={range}
                marginPagesDisplayed={1}
                containerClassName="pagination-container"
                pageLinkClassName="pagination-icon"
                breakClassName="pagination-icon"
                activeLinkClassName="pagination-link-active"
                previousClassName="arrow-previous"
                nextClassName="arrow-next"
                disabledClassName="arrow-inactive"
                previousLabel={<div className="pagination-arrow-container"><ArrowIcon /></div>} 
                nextLabel={<div className="pagination-arrow-container"><ArrowIcon /></div>}
                onPageChange={ (itens) => onChange(itens.selected)}
            />
        </>
    );
}

export default Pagination;