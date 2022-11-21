import Pagination from "components/Pagination";
import Search, { InstrumentFilterData } from "components/Search";
import TitleCard from "components/TitleCard";
import { Instrument } from "types/instrument";
import { useState, useEffect, useCallback } from 'react';
import { SpringPage } from "types/vendor/spring";
import { AxiosRequestConfig } from "axios";
import { requestBackend } from "util/requests";
import CardLoader from "../../components/CardLoader";
import ButtonAdd from "components/Buttons/ButtonAdd";
import Navbar from "components/Navbar";
import BaseCard from "components/BaseCard";
import { Link } from "react-router-dom";
import { hasAnyRoles } from "util/auth";


type ControlComponentsData = {
    activePage: number;
    filterData: InstrumentFilterData;
}

const Instruments = () => {

    const [page, setPage] = useState<SpringPage<Instrument>>();
    const [isLoading, setIsLoading] = useState(false);
    const [controlComponentsData, setControlComponentsData] = useState<ControlComponentsData>({
        activePage: 0,
        filterData: {tag: '', id: ''}
    });

    const handlePageChange = (pageCount: number) => {
        setControlComponentsData({activePage: pageCount, filterData: controlComponentsData.filterData})
    }

    const handleSubmitFilter = (data: InstrumentFilterData) => {
        setControlComponentsData({activePage: 0, filterData: data})
    }

    const getInstruments = useCallback(() => {
        const params: AxiosRequestConfig = {
            method: "GET",
            url: "/instruments",
            withCredentials: true,
            params: {
                page: controlComponentsData.activePage,
                size: 5,
                tag: controlComponentsData.filterData.tag,
            },
        };
        setIsLoading(true);
        requestBackend(params)
            .then(response => {
                setPage(response.data);
            }).finally(() => {
                setIsLoading(false);
            })
    }, [controlComponentsData]);

    useEffect(() => {
        getInstruments();
    }, [getInstruments]);

   

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
                        <Search onSubmitFilter={handleSubmitFilter} />
                    </div>
                    <div className="btn-middle-head-content">
                        {hasAnyRoles(['ROLE_ADMIN']) &&
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
                            } onDelete={() => getInstruments()} link={`/instruments/${instrument.id}`} />
                        )))}


                </div>
                <div>
                    <Pagination forcePage={page?.number} pageCount={page?.totalPages} onChange={handlePageChange} />
                </div>
            </div>
        </div>
    );
}

export default Instruments;