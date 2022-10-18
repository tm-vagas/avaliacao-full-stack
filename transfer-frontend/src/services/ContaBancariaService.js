import axios from "axios"

const CONTAS_BANCARIAS_ENDPOINT = "http://localhost:8080/api/contas_bancarias/"

class ContaBancariaService {
    createContaBancaria(usuarioId, contaBancaria){
        return axios.post(CONTAS_BANCARIAS_ENDPOINT + usuarioId, contaBancaria);
    }
    updateContaBancaria(contaBancariaId, contaBancaria){
        return axios.put(CONTAS_BANCARIAS_ENDPOINT + contaBancariaId, contaBancaria);
    }
    deleteContaBancaria(contaBancariaId){
        return axios.delete(CONTAS_BANCARIAS_ENDPOINT + contaBancariaId);
    }
    getContasBancarias(){
        return axios.get(CONTAS_BANCARIAS_ENDPOINT);
    }
    getContaBancariaById(contaBancariaId){
        return axios.get(CONTAS_BANCARIAS_ENDPOINT + contaBancariaId);
    }
}

export default new ContaBancariaService()
