<template>
    <div class="format-1 margem-inf">
        <h2 class="format-2 box-2 no-margin">DELETE /api/contas_bancarias/{contaBancariaId}</h2>
        <div class="row no-margin content">
            <div v-html="mensagem" class="no-padding"></div>
            <div class="box-3">
                <form v-on:submit.prevent="deleteContaBancaria">
                    <div class="input-g">                    
                        <input type="number" class="form-control" placeholder="ID" v-model="form.id" required>
                        <button class="btn btn-outline-secondary" type="submit">EXCLUIR</button>
                     </div>
                </form>
            </div>
        </div>    
    </div>
</template>

<script>
    
    import ContaBancariaService from "../services/ContaBancariaService"
    
    const returnSuccess = (successMessage) => `<div class="box-3"><div class="alert alert-success alert-dismissible fade show" role="alert"><i class="bi bi-check-circle-fill"></i>${successMessage}<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button></div></div>`;
    
    const returnError = (errorMessage) => `<div class="box-3"><div class="alert alert-danger alert-dismissible fade show" role="alert"><i class="bi bi-exclamation-triangle-fill"></i>${errorMessage}<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button></div></div>`;

    export default {
        name: "excluirContaBancaria",
        data() {
            return {
                form: {
                    id: ""
                },
                mensagem: ""
            }
        },
        methods: {
            deleteContaBancaria() {
                ContaBancariaService.deleteContaBancaria(this.form.id)
                .then(() => { 
                    this.mensagem = returnSuccess(`Conta Bancária excluída com sucesso.`);
                })
                .catch((jqXHR) => {
                    this.mensagem = returnError(`HTTP ${jqXHR.response.data.httpCode}: ${jqXHR.response.data.mensagem}`);
                })
                .finally(() => {
                    this.form.id = "";                                                         
                });
            }
        }
    }
    
</script>
