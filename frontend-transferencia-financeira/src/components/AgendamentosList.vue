<template>
  <div class="list row"> 
    <div class="col-md-6">
      <h4>Consulta Agendamentos</h4>
      <ul class="list-group">        
        <table class="table mt-5">
          <thead>
            <tr>
              <th scope="col">id</th>
              <th scope="col">contaOrigem</th>
              <th scope="col">contaDestino</th>
              <th scope="col">valorTransferencia</th>
              <th scope="col">taxa%</th>
              <th scope="col">dataAgendamento</th>
              <th scope="col">dataTransferencia</th>
            </tr>
          </thead>    
            <tbody>
              <tr v-for="(agendamento, index) in agendamentos" :key="index">
                <th scope="row">{{ agendamento.id}}</th>            
                <td> {{ agendamento.contaOrigem }}</td>
                <td> {{ agendamento.contaDestino }}</td>
                <td> {{ agendamento.valorTransferencia }}</td>
                <td> {{ agendamento.taxa }}</td>
                <td> {{formatDate(agendamento.dataAgendamento) }}</td>
                <td> {{formatDate(agendamento.dataTransferencia) }}</td>
              </tr>
            </tbody>
          </table>        
      </ul>    
    </div>
  </div>
</template>
<script>
import AgendamentoDataService from "../services/AgendamentoDataService";

export default {
  name: "agendamento-list",
  data() {
    return {
      agendamentos: [],      
    };
  },

  methods: {
    retrieveAgendamentos() {
      AgendamentoDataService.getAll()
        .then(response => {
          this.agendamentos = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
   
    formatDate(dateString) {
      const date = new Date(dateString);
      return new Intl.DateTimeFormat('pt-BR',{month:'2-digit',day:'2-digit', year:'numeric'}).format(date);
    }
  },

  mounted() {
    this.retrieveAgendamentos();
  }
};
</script>
<style>
.list {
  text-align: left;
  max-width: 750px;
  margin: auto;
}
</style>