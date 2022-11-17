import Navbar from "components/Navbar";
import './styles.css';

const InstrumentForm = () => {

    return (
        <div className="page-container">
            <div className="page-nav-container">
                <Navbar />
            </div>
            <div className="page-content">
                <div className="base-card instrument-form-card">
                    <h1 className="instrument-form-title">Dados do Instrumento</h1>

                    <form>
                        <div className="row instrument-form-inputs">
                            <div className="col-lg-6 instrument-form-inputs-left">
                                <div className="margin-botton-30">
                                    <input type="text" className="base-input form-control" />
                                </div>
                                <div className="margin-botton-30">
                                    <input type="text" className="base-input form-control" />
                                </div>
                                <div className="margin-botton-30">
                                    <input type="text" className="base-input form-control" />
                                </div>
                            </div>
                            <div className="col-lg-6 margin-botton-30">
                                <div className="margin-botton-30">
                                    <input type="text" className="base-input form-control" />
                                </div>
                                <textarea name="" rows={5} className="base-input form-control h-auto"></textarea>
                            </div>

                            <div className="instrument-form-buttons-container">
                                <button className="btn btn-outline-danger instrument-form-button">CANCELAR</button>
                                <button className="btn btn-primary instrument-form-button text-white">SALVAR</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    );
}

export default InstrumentForm;