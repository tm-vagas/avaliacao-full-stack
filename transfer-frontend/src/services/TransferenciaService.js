import axios from "axios";

const TRANSFERENCIAS_ENDPOINT = "http://localhost:8080/api/transferencias/"

class TransferenciaService {
    createTransferencia(contaBancariaOrigemId, contaBancariaDestinoId, transferencia){
        return axios.post(TRANSFERENCIAS_ENDPOINT + contaBancariaOrigemId + "/" + contaBancariaDestinoId, transferencia);
    }
    updateTransferencia(transferenciaId, transferencia){
        return axios.put(TRANSFERENCIAS_ENDPOINT + transferenciaId, transferencia);
    }
    deleteTransferencia(transferenciaId){
        return axios.delete(TRANSFERENCIAS_ENDPOINT + transferenciaId);
    }
    getTransferencias() {
        return axios.get(TRANSFERENCIAS_ENDPOINT);
    }
    getTransferenciaById(transferenciaId){
        return axios.get(TRANSFERENCIAS_ENDPOINT + transferenciaId);
    }   
}

export default new TransferenciaService()
