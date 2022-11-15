import Pagination from "components/Pagination";
import Search from "components/Search";
import TitleCard from "components/TitleCard";
import ButtonAdd from "components/Buttons/ButtonAdd";
import Navbar from "components/Navbar";

const CertificatePage = () => {
    return (
        <div className="page-container">
        <div className="page-nav-container">
            <Navbar />
        </div>
        <div className="page-content">
            <div className="title">
                <h1>Certificados</h1>
            </div>
            <div className="middle-head-content">
                <Search />
                <ButtonAdd text="Adicionar Certificado" />
            </div>
            <TitleCard columns={['id', 'codigo', 'instrumento', 'data de caliobração']} />
            <div>
            </div>
            <div>
                <Pagination />
            </div>
        </div>
    </div>
    );
}

export default CertificatePage;