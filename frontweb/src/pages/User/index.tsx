import { Link } from "react-router-dom";
import { useState, useEffect } from 'react';
import { SpringPage } from "types/vendor/spring";
import { AxiosRequestConfig } from "axios";
import { requestBackend } from "util/requests";
import TitleCard from 'components/TitleCard';
import Pagination from "components/Pagination";
import Search from "components/Search";
import ButtonAdd from 'components/Buttons/ButtonAdd';
import CardLoader from "components/CardLoader";
import { User } from "types/users";
import BaseCard from "components/BaseCard";
import Navbar from "components/Navbar";

const UserPage = () => {

    const [page, setPage] = useState<SpringPage<User>>();
    const [isLoading, setIsLoading] = useState(false);

    useEffect(() => {
        const params: AxiosRequestConfig = {
            method: "GET",
            url: "/users",
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
                    <h1>Usuários</h1>
                </div>

                <div className="middle-head-content">
                    <Search />
                    <ButtonAdd text="Adicionar Usuário" />
                </div>

                <div>
                    <TitleCard columns={['id', 'nome', 'email', 'setor']} />
                </div>

                <div>
                    {isLoading ? <CardLoader /> : (
                        page?.content.map((user: User) => (
                                <BaseCard columns={
                                    [
                                        `${user?.id}`,
                                        `${user?.name}`,
                                        `${user?.email}`,
                                        `${user?.department.name}`,
                                    ]
                                } link="/users/1" />
                        )))}
                </div>

                <div>
                    <Pagination />
                </div>
            </div>
        </div>
    );
}
export default UserPage;