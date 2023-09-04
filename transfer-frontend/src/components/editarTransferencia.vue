<template>
    <div class="format-1 margem-inf">
        <h2 class="format-2 box-2 no-margin">PUT /api/transferencias/{transferenciaId}</h2>
        <div class="row no-margin content">
            <div v-html="mensagem" class="no-padding"></div>
            <div class="box-3">
                <form v-on:submit.prevent="updateTransferencia">
                    <div class="input-g">
                        <input type="number" class="form-control" placeholder="ID" v-model="form.id" required>
                        <input type="text" class="form-control separator" placeholder="DATA DA AGENDA" v-model="form.dataAgenda" required>
                        <input type="text" class="form-control separator" placeholder="DATA DA CONCLUSÃO" v-model="form.dataConclusao" required>
                        <input type="number" step="any" class="form-control separator" placeholder="VALOR" v-model="form.valor" required>
                        <input type="number" step="any" class="form-control separator" placeholder="TAXA" v-model="form.taxa" required>
                        <input type="number" step="any" class="form-control separator" placeholder="VALOR TOTAL" v-model="form.valorTotal" required>
                        <input type="text" class="form-control separator" placeholder="STATUS" v-model="form.status" required>
                        <button class="btn btn-outline-secondary" type="submit">EDITAR</button>
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
        name: "editarTransferencia",
        data() {
            return {
                form: {
                    id: "",
                    dataAgenda: "",
                    dataConclusao: "",
                    valor: "",
                    taxa: "",
                    valorTotal: "",
                    status: "",
                },
                mensagem: ""
            }
        },
        methods: {        
            updateTransferencia() {
                TransferenciaService.updateTransferencia(this.form.id, this.form)
                .then(() => { 
                    this.mensagem = returnSuccess(`Transferência editada com sucesso.`);
                })
                .catch((jqXHR) => {
                    this.mensagem = returnError(`HTTP ${jqXHR.response.data.httpCode}: ${jqXHR.response.data.mensagem}`);
                })
                .finally(() => {
                    this.form.id = "";
                    this.form.dataAgenda = "";                    
                    this.form.dataConclusao = "";
                    this.form.valor = "";
                    this.form.taxa = "";
                    this.form.valorTotal = "";
                    this.form.status = "";                                 
                });
            }
        }
    }
    
</script>
