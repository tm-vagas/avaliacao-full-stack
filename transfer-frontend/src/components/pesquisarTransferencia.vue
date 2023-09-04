<template>
    <div class="format-1 margem-inf">
        <h2 class="format-2 box-2 no-margin">GET /api/transferencias/{transferenciaId}</h2>
        <div class="row no-margin content">
            <div v-html="mensagem" class="no-padding"></div>
            <div class="box-3">
                <form v-on:submit.prevent="getTransferenciaById">
                    <div class="input-g">                    
                        <input type="number" class="form-control" placeholder="ID" v-model="form.id" required>
                        <button class="btn btn-outline-secondary" type="submit">PESQUISAR</button>
                     </div>
                </form>
            </div>
            <div v-html="transferencia" class="col-lg-4 col-md-4 col-sm-12 col-xs-12 box-3"></div>
        </div>    
    </div>  
</template>

<script>
    
    import TransferenciaService from "../services/TransferenciaService"
    
    const returnError = (errorMessage) => `<div class="box-3"><div class="alert alert-danger alert-dismissible fade show" role="alert"><i class="bi bi-exclamation-triangle-fill"></i>${errorMessage}<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button></div></div>`;

    export default {
        name: "pesquisarTransferencia",
        data() {
            return {
                form: {
                    id: ""
                },
                mensagem: "",
                transferencia: ""
            }
        },
        methods: {
            getTransferenciaById() {
                TransferenciaService.getTransferenciaById(this.form.id)
                .then((response) => {
                
                    const conteudo = "<div class=\"format-1\"><p class=\"box-2 no-margin\"><strong>Id:</strong> <span>"+response.data.id+"</span><br><strong>Data Agenda:</strong> <span>"+response.data.dataAgenda+"</span><br><strong>Data Conclusão:</strong> <span>"+response.data.dataConclusao+"</span><br><strong>Valor:</strong> <span>"+response.data.valor+"</span><br><strong>Taxa:</strong> <span>"+response.data.taxa+"</span><br><strong>Valor Total:</strong> <span>"+response.data.valorTotal+"</span><br><strong>Status:</strong> <span>"+response.data.status+"</span><br></p></div>";
                    
                    this.transferencia = conteudo;
                    this.mensagem = "";
                })
                .catch((jqXHR) => {
                    this.mensagem = returnError(`HTTP ${jqXHR.response.data.httpCode}: ${jqXHR.response.data.mensagem}`);
                    this.transferencia = "";
                })
                .finally(() => {
                    this.form.id = "";                                                         
                });
            }
        }
    }
    
</script>
