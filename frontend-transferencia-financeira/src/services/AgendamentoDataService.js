import http from "../http-common";
class AgendamentoDataService {
  getAll() {
    return http.get("/lista-agendamentos");
  }

  create(data) {
    return http.post("/agendamento", data);
  }

}

export default new AgendamentoDataService();