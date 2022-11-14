import ButtonBase from "components/ButtonBase";
import InstrumentCard from "components/InstrumentCard";
import Pagination from "components/Pagination";
import Search from "components/Search";
import TitleCard from "components/TitleCard";
import { Link } from "react-router-dom";
import { Instrument } from "types/instrument";
import { useState, useEffect } from 'react';
import { SpringPage } from "types/vendor/spring";
import axios from "axios";
import { AxiosParams } from "types/vendor/axios";
import { BASE_URL } from "util/requests";
import './styles.css';
import CardLoader from "./CardLoader";


const InstrumentPage = () => {

    const [page, setPage] = useState<SpringPage<Instrument>>();
    const [isLoading, setIsLoading] = useState(false);

    useEffect(() => {
        const params: AxiosParams = {
            method: "GET",
            url: `${BASE_URL}/instruments`,
            params: {
                page: 0,
                size: 5
            },
        }

        setIsLoading(true);
        axios(params)
            .then(response => {
                setPage(response.data);
            }).finally(() => {
                setIsLoading(false);
            });
    }, []);

    return (
        <div>
            <div className="head-content">
                <div className="title">
                    <h1>Instrumentos</h1>
                </div>
                <div className="middle-head-content">
                    <Search />
                    <ButtonBase text="Adicionar Instrumento" />
                </div>
                <TitleCard />
            </div>

            <div>
                {isLoading ? <CardLoader /> : (
                    page?.content.map((instrument: Instrument) => (
                    <Link to={`/main/instruments/1`} key={instrument.id}>
                        <span data-bs-toggle="collapse" data-bs-target={`#id`} aria-expanded="false" aria-controls="collapseCard">
                            <InstrumentCard instrument={instrument} />
                        </span>
                    </Link>
                )
                ))}

            </div>
            <div>
                <Pagination />
            </div>
        </div>
    );
}

export default InstrumentPage;