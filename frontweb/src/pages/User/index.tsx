import { useState, useEffect, useCallback } from 'react';
import { SpringPage } from "types/vendor/spring";
import { AxiosRequestConfig } from "axios";
import { requestBackend } from "util/requests";
import TitleCard from 'components/TitleCard';
import Pagination from "components/Pagination";
import Search, { InstrumentFilterData } from "components/Search";
import ButtonAdd from 'components/Buttons/ButtonAdd';
import CardLoader from "components/CardLoader";
import { User } from "types/users";
import BaseCard from "components/BaseCard";
import Navbar from "components/Navbar";
import { Link } from 'react-router-dom';
import { hasAnyRoles } from 'util/auth';


type ControlComponentsData = {
    activePage: number;
    filterData: InstrumentFilterData;
}

const UserPage = () => {

    const [page, setPage] = useState<SpringPage<User>>();
    const [isLoading, setIsLoading] = useState(false);
    const [controlComponentsData, setControlComponentsData] = useState<ControlComponentsData>({
        activePage: 0,
        filterData: { tag: '', id: '' }
    });

    const handlePageChange = (pageCount: number) => {
        setControlComponentsData({ activePage: pageCount, filterData: controlComponentsData.filterData })
    }

    const handleSubmitFilter = (data: InstrumentFilterData) => {
        setControlComponentsData({ activePage: 0, filterData: data })
    }


    const getUsers = useCallback(() => {
        const params: AxiosRequestConfig = {
            method: "GET",
            url: "/users",
            withCredentials: true,
            params: {
                page: controlComponentsData.activePage,
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
    }, [controlComponentsData]);

    useEffect(() => {
        getUsers();
    }, [getUsers]);

    return (
        <div className="page-container">


            <div className="page-nav-container">
                <Navbar />
            </div>

            <div className="page-content">
                <div className="title">
                    <h1>Usuários</h1>
                </div>

                <div className="middle-head-content">
                    <div className="search-middle-head-content" >
                        <Search onSubmitFilter={handleSubmitFilter} />
                    </div>
                    <div className="btn-middle-head-content">
                        {hasAnyRoles(['ROLE_ADMIN']) &&
                            <Link to="/users/create">
                                <ButtonAdd text="Adicionar Usuário" />
                            </Link>
                        }
                    </div>
                </div>

                <div>
                    <TitleCard columns={['id', 'nome', 'matrícula', 'email']} />
                </div>

                <div>
                    {isLoading ? <CardLoader /> : (
                        page?.content.map((user: User) => (
                            <BaseCard type='user' key={user.id} deletedId={user.id} onDelete={() => getUsers()} columns={
                                [
                                    `${user?.id}`,
                                    `${user?.name}`,
                                    `${user?.enrollment}`,
                                    `${user?.email}`,
                                ]
                            } link={`/users/${user.id}`} />
                        )))}
                </div>

                <div>
                    <Pagination forcePage={page?.number} pageCount={page?.totalPages} onChange={handlePageChange} />
                </div>
            </div>
        </div>
    );
}
export default UserPage;