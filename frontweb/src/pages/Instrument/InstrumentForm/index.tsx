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
                        <div className="row">
                            <div className="col-lg-6">
                                <input type="text" className="base-input form-control" />
                                <input type="text" className="base-input form-control" />
                                <input type="text" className="base-input form-control" />
                                
                            </div>
                            <div className="col-lg-6">
                                <textarea name="" rows={10} className="base-input form-control"></textarea>
                            </div>

                            <div>
                                <button className="btn btn-outline-danger">CANCELAR</button>
                                <button className="btn btn-primary">SALVAR</button>
                            </div>

                        </div>
                    </form>


                </div>
            </div>
        </div>
    );
}

export default InstrumentForm;