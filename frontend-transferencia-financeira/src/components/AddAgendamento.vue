<template>
  <div class="submit-form">
      <h4>{{agenda.response}}</h4>    
    
      <div class="form-group">        
        <label for="contaOrigem">Conta Origem</label>
        <input
          type="text"
          class="form-control"
          id="contaOrigem"
          required
          v-model="agenda.contaOrigem"
          name="contaOrigem"
        />
      </div>
      <div class="form-group">
        <label for="contaDestino">Conta Destino</label>
        <input
          class="form-control"
          id="contaDestino"
          required
          v-model="agenda.contaDestino"
          name="contaDestino"
        />
      </div>
      <div class="form-group">
        <label for="valorTransferencia">Valor Transferencia</label>
        <input
          class="form-control"
          id="valorTransferencia"
          required
          v-model="agenda.valorTransferencia"
          name="valorTransferencia"
        />
      </div>      
      <div class="form-group">
        <label for="dataTransferencia">Data Transferencia - YYYY-MM-DD</label>
        <input
          class="form-control"
          id="dataTransferencia"
          required
          v-model="agenda.dataTransferencia"
          name="dataTransferencia"
        />
      </div>
      <button @click.prevent="saveAgendamento" class="btn btn-success">Agendar</button>            
      <p class="alert alert-success" v-show="response" v-text="response"></p>
      <p class="alert alert-danger" v-show="status" v-text="status"></p>

    </div>    
 
</template>
<script>
import AgendamentoDataService from "../services/AgendamentoDataService";

export default {
  name: "add-agendamento",
  data() {
    return {
      agenda: {       
        contaOrigem: "",
        contaDestino: "",
        valorTransferencia:"",
        dataTrasnferencia: ""        
      },     
      submitted: false,
      status: false,
      response: false
    };
  },
  
  methods: {
    saveAgendamento() {
      this.response = ""
      this.status = ""
      var data = {
        contaOrigem: this.agenda.contaOrigem,
        contaDestino: this.agenda.contaDestino,
        valorTransferencia: this.agenda.valorTransferencia,
        dataTransferencia: this.agenda.dataTransferencia
      };
      AgendamentoDataService.create(data)
        .then(response => {
          this.response = response.data;          
          console.log(response.data);
          this.submitted = true;
        })
        .catch(error => {
          this.status = error.response.data;
          console.log(error);
        });
    },
        
  }
};
</script>
<style>
.submit-form {
  max-width: 300px;
  margin: auto;
}
</style>