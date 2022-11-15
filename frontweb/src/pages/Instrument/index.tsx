import InstrumentCard from "pages/Instrument/InstrumentCard";
import Pagination from "components/Pagination";
import Search from "components/Search";
import TitleCard from "components/TitleCard";
import { Instrument } from "types/instrument";
import { useState, useEffect } from 'react';
import { SpringPage } from "types/vendor/spring";
import { AxiosRequestConfig } from "axios";
import { requestBackend } from "util/requests";
import CardLoader from "../../components/CardLoader";
import ButtonAdd from "components/Buttons/ButtonAdd";
import Navbar from "components/Navbar";


const Instruments = () => {

    const [page, setPage] = useState<SpringPage<Instrument>>();
    const [isLoading, setIsLoading] = useState(false);

    useEffect(() => {
        const params: AxiosRequestConfig = {
            method: "GET",
            url: "/instruments",
            withCredentials: true,
            params: {
                page: 0,
                size: 5
            }
        }

        setIsLoading(true);
        requestBackend(params)
            .then(response => {
                setPage(response.data);
            }).finally(() => {
                setIsLoading(false);
            });
    }, []);

    return (
        <div className="page-container">
            <div className="page-nav-container">
                <Navbar />
            </div>
            <div className="page-content">
                <div className="title">
                    <h1>Instrumentos</h1>
                </div>
                <div className="middle-head-content">
                    <Search />
                    <ButtonAdd text="Adicionar Instrumento" />
                </div>
                <TitleCard columns={['tipo', 'tag', 'série', 'status']} />
                <div>
                    {isLoading ? <CardLoader /> : (
                        page?.content.map((instrument: Instrument) => (
                          //  <Link to={`/instruments/${instrument.id}`} key={instrument.id}>
                                <InstrumentCard instrument={instrument} />
                          //  </Link>
                        )))}
                </div>
                <div>
                    <Pagination />
                </div>
            </div>
        </div>
    );
}

export default Instruments;