import axios from "axios";

const USUARIOS_ENDPOINT = "http://localhost:8080/api/usuarios/"

class UsuarioService {    
    createUsuario(usuario){
        return axios.post(USUARIOS_ENDPOINT, usuario);
    }
    updateUsuario(usuarioId, usuario){
        return axios.put(USUARIOS_ENDPOINT + usuarioId, usuario);
    }
    deleteUsuario(usuarioId){
        return axios.delete(USUARIOS_ENDPOINT + usuarioId);
    }
    getUsuarios(){
        return axios.get(USUARIOS_ENDPOINT);
    }
    getUsuarioById(usuarioId){
        return axios.get(USUARIOS_ENDPOINT + usuarioId);
    }            
}

export default new UsuarioService()
