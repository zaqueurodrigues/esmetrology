import Pagination from "components/Pagination";
import Search from "components/Search";
import TitleCard from "components/TitleCard";
import ButtonAdd from "components/Buttons/ButtonAdd";
import Navbar from "components/Navbar";
import { useState, useEffect } from 'react';
import { SpringPage } from "types/vendor/spring";
import { AxiosRequestConfig } from "axios";
import { requestBackend } from "util/requests";

const DepartmentPage = () => {

    const [page, setPage] = useState<SpringPage<any>>();
    const [isLoading, setIsLoading] = useState(false);

    useEffect(() => {
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
    }, []);


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
                <ButtonAdd text="Adicionar Setor" />
            </div>
            <TitleCard columns={['id', 'nome']} />
            <div>
            </div>
            <div>
                <Pagination />
            </div>
        </div>
    </div>
    );
}

export default DepartmentPage;