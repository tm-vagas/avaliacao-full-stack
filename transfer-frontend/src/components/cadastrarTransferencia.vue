<template>
    <div class="format-1 margem-inf">
        <h2 class="format-2 box-2 no-margin">POST /api/transferencias/{contaBancariaOrigemId}/{contaBancariaDestinoId}</h2>
        <div class="row no-margin content">
            <div v-html="mensagem" class="no-padding"></div>
            <div class="box-3">
                <form v-on:submit.prevent="createTransferencia">
                    <div class="input-g">
                        <input type="number" min="100000" max="999999" class="form-control" placeholder="CONTA BANCÁRIA ORIGEM ID" v-model="form.contaBancariaOrigemId" required>
                        <input type="number" min="100000" max="999999" class="form-control separator" placeholder="CONTA BANCÁRIA DESTINO ID" v-model="form.contaBancariaDestinoId" required>
                        <input type="number" step="any" class="form-control separator" placeholder="VALOR" v-model="form.valor" required>
                        <input type="text" class="form-control separator" placeholder="DATA DA CONCLUSÃO (YYYY-MM-DD)" v-model="form.dataConclusao" required>
                        <button class="btn btn-outline-secondary" type="submit">CADASTRAR</button>
                     </div>
                </form>
            </div>
        </div>    
    </div>
</template>

<script>
    
    import TransferenciaService from "../services/TransferenciaService"
    
    const returnSuccess = (successMessage) => `<div class="box-3"><div class="alert alert-success alert-dismissible fade show" role="alert"><i class="bi bi-check-circle-fill"></i>${successMessage}<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button></div></div>`;
    
    const returnError = (errorMessage) => `<div class="box-3"><div class="alert alert-danger alert-dismissible fade show" role="alert"><i class="bi bi-exclamation-triangle-fill"></i>${errorMessage}<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button></div></div>`;

    export default {
        name: "cadastrarTransferencia",
        data() {
            return {
                form: {
                    contaBancariaOrigemId: "",
                    contaBancariaDestinoId: "",
                    valor: "",
                    dataConclusao: ""
                },
                mensagem: ""
            }
        },
        methods: {
            createTransferencia() {
                TransferenciaService.createTransferencia(this.form.contaBancariaOrigemId, this.form.contaBancariaDestinoId, this.form)
                .then(() => {                    
                    const dataAtual = new Date();
                    const ano = dataAtual.getFullYear();
                    const mes = dataAtual.getMonth() + 1;
                    const dia = dataAtual.getDate();                    
                    const dataAtualFormatada = ano + "-" + mes + "-" + dia;                    
                    if(this.form.dataConclusao === dataAtualFormatada){
                        this.mensagem = returnSuccess(`Transferência realizada com sucesso.`);
                    } else {
                        this.mensagem = returnSuccess(`Transferência agendada com sucesso.`);
                    }                                      
                })
                .catch((jqXHR) => {
                    this.mensagem = returnError(`HTTP ${jqXHR.response.data.httpCode}: ${jqXHR.response.data.mensagem}`);
                })
                .finally(() => {
                    this.form.contaBancariaOrigemId = "";
                    this.form.contaBancariaDestinoId = "";
                    this.form.valor = "";
                    this.form.dataConclusao = "";                                                         
                });
            }
        }
    }
    
</script>
