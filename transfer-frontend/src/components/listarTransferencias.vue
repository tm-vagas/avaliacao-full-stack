<template>    
    <div class="format-1 margem-inf">    
        <h2 class="format-2 box-2 no-margin">GET /api/transferencias</h2>
        <div class="row no-margin content">
            <div class="box-3">
                <form v-on:submit.prevent="getTransferencias">
                    <div class="input-g"> 
                        <button class="btn btn-outline-secondary no-margin" type="submit">RELISTAR</button>
                    </div>
                </form>
            </div>    
            <div v-for="transferencia in transferencias" v-bind:key="transferencia.id" class="col-lg-4 col-md-4 col-sm-12 col-xs-12 box-3">
                <div class="format-1">            
                    <p class="box-2 no-margin">
                        <strong>Id:</strong> <span>{{transferencia.id}}</span><br>
                        <strong>Data Agenda:</strong> <span>{{transferencia.dataAgenda}}</span><br>                
                        <strong>Data Conclusão:</strong> <span>{{transferencia.dataConclusao}}</span><br>
                        <strong>Valor:</strong> <span>{{transferencia.valor}}</span><br>
                        <strong>Taxa:</strong> <span>{{transferencia.taxa}}</span><br>
                        <strong>Valor Total:</strong> <span>{{transferencia.valorTotal}}</span><br>
                        <strong>Status:</strong> <span>{{transferencia.status}}</span><br>
                    </p>
                </div>                                                
            </div>
        </div>
    </div>
</template>

<script>
    import TransferenciaService from "../services/TransferenciaService"
    export default {
        name: "TRANSFERENCIA",
        data(){
            return {
                transferencias : []
            }            
        },
        methods: {
            getTransferencias(){
                TransferenciaService.getTransferencias().then((response) => {
                    this.transferencias = response.data;
                });
            }            
        },
        created(){
            this.getTransferencias()
        }
    }
</script>
