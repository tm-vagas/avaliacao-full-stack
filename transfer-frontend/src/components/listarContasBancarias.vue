<template>    
    <div class="format-1 margem-inf"> 
        <h2 class="format-2 box-2 no-margin">GET /api/contas_bancarias</h2>
        <div class="row no-margin content">
            <div class="box-3">
                <form v-on:submit.prevent="getContasBancarias">
                    <div class="input-g"> 
                        <button class="btn btn-outline-secondary no-margin" type="submit">RELISTAR</button>
                    </div>
                </form>
            </div>
            <div v-for="contaBancaria in contasBancarias" v-bind:key="contaBancaria.id" class="col-lg-4 col-md-4 col-sm-12 col-xs-12 box-3">
                <div class="format-1">
                    <p class="box-3 no-margin">
                        <strong>Id:</strong> <span>{{contaBancaria.id}}</span><br>
                        <strong>Saldo:</strong> <span>{{contaBancaria.saldo}}</span>
                    </p>
                    <div class="box-2">
                        <div class="format-1">
                            <p class="format-2 box-2 no-margin">TRANSFERÊNCIAS ORIGEM</p>            
                            <p v-for="transferenciaOrigem in contaBancaria.transferenciasOrigem" v-bind:key="transferenciaOrigem.id" class="box-2 no-margin"> 
                                <strong>Id:</strong> <span>{{transferenciaOrigem.id}}</span><br>
                                <strong>Data Agenda:</strong> <span>{{transferenciaOrigem.dataAgenda}}</span><br>
                                <strong>Data Conclusão:</strong> <span>{{transferenciaOrigem.dataConclusao}}</span><br>
                                <strong>Valor:</strong> <span>{{transferenciaOrigem.valor}}</span><br>
                                <strong>Taxa:</strong> <span>{{transferenciaOrigem.taxa}}</span><br>
                                <strong>Valor Total:</strong> <span>{{transferenciaOrigem.valorTotal}}</span><br>
                                <strong>Status:</strong> <span>{{transferenciaOrigem.status}}</span>
                            </p>
                        </div>
                    </div>        
                    <div class="box-2">
                        <div class="format-1">        
                            <p class="format-2 box-2 no-margin">TRANSFERÊNCIAS DESTINO</p>            
                            <p v-for="transferenciaDestino in contaBancaria.transferenciasDestino" v-bind:key="transferenciaDestino.id" class="box-2 no-margin"> 
                                <strong>Id:</strong> <span>{{transferenciaDestino.id}}</span><br>
                                <strong>Data Agenda:</strong> <span>{{transferenciaDestino.dataAgenda}}</span><br>
                                <strong>Data Conclusão:</strong> <span>{{transferenciaDestino.dataConclusao}}</span><br>
                                <strong>Valor:</strong> <span>{{transferenciaDestino.valor}}</span><br>
                                <strong>Taxa:</strong> <span>{{transferenciaDestino.taxa}}</span><br>
                                <strong>Valor Total:</strong> <span>{{transferenciaDestino.valorTotal}}</span><br>
                                <strong>Status:</strong> <span>{{transferenciaDestino.status}}</span>
                            </p>
                        </div>
                    </div>
                </div>                                        
            </div>
        </div>
    </div>
</template>

<script>
    import ContaBancariaService from "../services/ContaBancariaService"
    export default {
        name: "CONTABANCARIA",
        data(){
            return {
                contasBancarias : []
            }            
        },
        methods: {
            getContasBancarias(){
                ContaBancariaService.getContasBancarias().then((response) => {
                    this.contasBancarias = response.data;
                });
            }            
        },
        created(){
            this.getContasBancarias()
        }
    }
</script>
