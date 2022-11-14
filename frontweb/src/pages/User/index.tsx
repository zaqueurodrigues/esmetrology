import { Link } from "react-router-dom";
import { useState, useEffect } from 'react';
import { SpringPage } from "types/vendor/spring";
import { AxiosRequestConfig } from "axios";
import { BASE_URL, requestBackend } from "util/requests";
import TitleCard from 'components/TitleCard';
import Pagination from "components/Pagination";
import Search from "components/Search";
import ButtonAdd from 'components/Buttons/ButtonAdd';
import CardLoader from "components/CardLoader";
import { User } from "types/users";
import BaseCard from "components/BaseCard";

const UserPage = () => {

    const [page, setPage] = useState<SpringPage<User>>();
    const [isLoading, setIsLoading] = useState(false);

    useEffect(() => {
        const params: AxiosRequestConfig = {
            method: "GET",
            baseURL: BASE_URL,
            url: "/users",
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
                { isLoading ? <CardLoader /> : (
                    page?.content.map((user: User) => (
                        <Link to={`/main/users/1`} key={user.id}>
                            <BaseCard columns={
                                [
                                    `${user?.id}`,
                                    `${user?.name}`,
                                    `${user?.email}`,
                                    `${user?.department.name}`,
                                ]
                            }/>
                        </Link>
                    ))) }
            </div>

            <div>
                <Pagination />
            </div>
        </>
    );
}
export default UserPage;