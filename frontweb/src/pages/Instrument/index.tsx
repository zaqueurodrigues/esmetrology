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
import BaseCard from "components/BaseCard";
import { Link } from "react-router-dom";
import { hasAnyRoles } from "util/auth";


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
                size: 10
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
                    <div className="search-middle-head-content" >
                        <Search />
                    </div>
                    <div className="btn-middle-head-content">
                        { hasAnyRoles(['ROLE_ADMIN']) &&
                            <Link to="/instruments/create">
                                <ButtonAdd text="Adicionar Instrumento" />
                            </Link>
                        }

                    </div>
                </div>
                <TitleCard columns={['id', 'tipo', 'tag', 'serie', 'status']} />
                <div>
                    {isLoading ? <CardLoader /> : (
                        page?.content.map((instrument: Instrument) => (
                            <BaseCard key={instrument.id} deletedId={instrument.id} columns={
                                [
                                    `${instrument?.id}`,
                                    `${instrument?.type}`,
                                    `${instrument?.tag}`,
                                    `${instrument?.serie}`,
                                    `${instrument?.status}`,
                                ]
                            } link={`/instruments/${instrument.id}` } />
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