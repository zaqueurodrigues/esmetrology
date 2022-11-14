import InstrumentCard from "pages/Instrument/InstrumentCard";
import Pagination from "components/Pagination";
import Search from "components/Search";
import TitleCard from "components/TitleCard";
import { Link } from "react-router-dom";
import { Instrument } from "types/instrument";
import { useState, useEffect } from 'react';
import { SpringPage } from "types/vendor/spring";
import { AxiosRequestConfig } from "axios";
import { requestBackend } from "util/requests";
import CardLoader from "../../components/CardLoader";
import ButtonAdd from "components/Buttons/ButtonAdd";


const InstrumentPage = () => {

    const [page, setPage] = useState<SpringPage<Instrument>>();
    const [isLoading, setIsLoading] = useState(false);

    useEffect(() => {
        const params: AxiosRequestConfig = {
            method: "GET",
            url: "/instruments",
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
        <>
            <div className="head-content">
                <div className="title">
                    <h1>Instrumentos</h1>
                </div>

                <div className="middle-head-content">
                    <Search />
                    <ButtonAdd text="Adicionar Instrumento" />
                </div>

                <TitleCard columns={['tipo', 'tag', 'série', 'status']} />
            </div>

            <div>
                { isLoading ? <CardLoader /> : (
                    page?.content.map( (instrument: Instrument) => (
                    <Link to={`/main/instruments/2`} key={instrument.id}>
                        <span data-bs-toggle="collapse" data-bs-target={`#id`} aria-expanded="false" aria-controls="collapseCard">
                            <InstrumentCard instrument={instrument} />
                        </span>
                    </Link>
                ))) }
            </div>

            <div>
                <Pagination />
            </div>
        </>
    );
}

export default InstrumentPage;