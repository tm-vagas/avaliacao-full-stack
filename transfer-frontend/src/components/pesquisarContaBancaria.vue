<template>
    <div class="format-1 margem-inf">
        <h2 class="format-2 box-2 no-margin">GET /api/contas_bancarias/{contaBancariaId}</h2>
        <div class="row no-margin content">
            <div v-html="mensagem" class="no-padding"></div>
            <div class="box-3">
                <form v-on:submit.prevent="getContaBancariaById">
                    <div class="input-g">                    
                        <input type="number" class="form-control" placeholder="ID" v-model="form.id" required>
                        <button class="btn btn-outline-secondary" type="submit">PESQUISAR</button>
                     </div>
                </form>
            </div>
            <div v-html="contaBancaria" class="col-lg-4 col-md-4 col-sm-12 col-xs-12 box-3"></div>
        </div>    
    </div>  
</template>

<script>
    
    import ContaBancariaService from "../services/ContaBancariaService"
    
    const returnError = (errorMessage) => `<div class="box-3"><div class="alert alert-danger alert-dismissible fade show" role="alert"><i class="bi bi-exclamation-triangle-fill"></i>${errorMessage}<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button></div></div>`;

    export default {
        name: "pesquisarContaBancaria",
        data() {
            return {
                form: {
                    id: ""
                },
                mensagem: "",
                contaBancaria: ""
            }
        },
        methods: {
            getContaBancariaById() {
                ContaBancariaService.getContaBancariaById(this.form.id)
                .then((response) => {
                
                    let transferenciasOrigem = "";
                    let transferenciasDestino = "";
                    
                    for(let i = 0; i < response.data.transferenciasOrigem.length; i++){                    
                        transferenciasOrigem = transferenciasOrigem + "<p class=\"box-2 no-margin\"><strong>Id:</strong> <span>"+response.data.transferenciasOrigem[i].id+"</span><br><strong>Data Agenda:</strong> <span>"+response.data.transferenciasOrigem[i].dataAgenda+"</span><br> <strong>Data Conclusão:</strong> <span>"+response.data.transferenciasOrigem[i].dataConclusao+"</span><br><strong>Valor:</strong> <span>"+response.data.transferenciasOrigem[i].valor+"</span><br><strong>Taxa:</strong> <span>"+response.data.transferenciasOrigem[i].taxa+"</span><br><strong>Valor Total:</strong> <span>"+response.data.transferenciasOrigem[i].valorTotal+"</span><br><strong>Status:</strong> <span>"+response.data.transferenciasOrigem[i].status+"</span></p>";
                    }
                    
                    for(let i = 0; i < response.data.transferenciasDestino.length; i++){                    
                        transferenciasDestino = transferenciasDestino + "<p class=\"box-2 no-margin\"><strong>Id:</strong> <span>"+response.data.transferenciasDestino[i].id+"</span><br><strong>Data Agenda:</strong> <span>"+response.data.transferenciasDestino[i].dataAgenda+"</span><br> <strong>Data Conclusão:</strong> <span>"+response.data.transferenciasDestino[i].dataConclusao+"</span><br><strong>Valor:</strong> <span>"+response.data.transferenciasDestino[i].valor+"</span><br><strong>Taxa:</strong> <span>"+response.data.transferenciasDestino[i].taxa+"</span><br><strong>Valor Total:</strong> <span>"+response.data.transferenciasDestino[i].valorTotal+"</span><br><strong>Status:</strong> <span>"+response.data.transferenciasDestino[i].status+"</span></p>";
                    }
                    
                    const conteudo = "<div class=\"format-1\"><p class=\"box-3 no-margin\"><strong>Id:</strong> <span>"+response.data.id+"</span><br><strong>Saldo:</strong> <span>"+response.data.saldo+"</span></p><div class=\"box-2\"><div class=\"format-1\"><p class=\"format-2 box-2 no-margin\">TRANSFERÊNCIAS ORIGEM</p>"+transferenciasOrigem+"</div></div> <div class=\"box-2\"><div class=\"format-1\"><p class=\"format-2 box-2 no-margin\">TRANSFERÊNCIAS DESTINO</p>"+transferenciasDestino+"</div></div></div>";                    
                    
                    this.contaBancaria = conteudo;
                    this.mensagem = "";
                })
                .catch((jqXHR) => {
                    this.mensagem = returnError(`HTTP ${jqXHR.response.data.httpCode}: ${jqXHR.response.data.mensagem}`);
                    this.contaBancaria = "";
                })
                .finally(() => {
                    this.form.id = "";                                                         
                });
            }
        }
    }
    
</script>
