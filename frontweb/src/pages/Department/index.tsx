import Pagination from "components/Pagination";
import Search, { InstrumentFilterData } from "components/Search";
import TitleCard from "components/TitleCard";
import ButtonAdd from "components/Buttons/ButtonAdd";
import Navbar from "components/Navbar";
import { useState, useEffect } from 'react';
import { SpringPage } from "types/vendor/spring";
import { AxiosRequestConfig } from "axios";
import { requestBackend } from "util/requests";
import CardLoader from "components/CardLoader";
import { Department } from "types/department";
import BaseCard from "components/BaseCard";
import { hasAnyRoles } from "util/auth";

type ControlComponentsData = {
    activePage: number;
    filterData: InstrumentFilterData;
}

const DepartmentPage = () => {

    const [page, setPage] = useState<SpringPage<any>>();
    const [isLoading, setIsLoading] = useState(false);
    const [controlComponentsData, setControlComponentsData] = useState<ControlComponentsData>({
        activePage: 0,
        filterData: { tag: '', id: '' }
    });

    useEffect(() => {
        getDeparmtments()
    }, []);

    const handlePageChange = (pageCount: number) => {
        setControlComponentsData({ activePage: pageCount, filterData: controlComponentsData.filterData })
    }

    const getDeparmtments = () => {
        const params: AxiosRequestConfig = {
            method: "GET",
            url: "/departments",
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
    }


    return (
        <div className="page-container">
            <div className="page-nav-container">
                <Navbar />
            </div>
            <div className="page-content">
                <div className="title">
                    <h1>Setores</h1>
                </div>
                <div className="middle-head-content">
                    <Search />
                    {hasAnyRoles(['ROLE_ADMIN']) &&
                        <ButtonAdd text="Adicionar Setor" />
                    }
                </div>
                <TitleCard columns={['id', 'nome']} />
                <div>
                </div>
                {isLoading ? <CardLoader /> : (
                    page?.content.map((dep: Department) => (
                        <BaseCard onDelete={getDeparmtments} columns={
                            [
                                `${dep?.id}`,
                                `${dep?.name}`,
                            ]
                        } link={`/departments/${dep.id}`} />
                    )))}
                <div>
                    <Pagination forcePage={page?.number} pageCount={page?.totalPages} onChange={handlePageChange} />
                </div>
            </div>
        </div>
    );
}

export default DepartmentPage;