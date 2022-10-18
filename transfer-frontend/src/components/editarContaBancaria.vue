<template>
    <div class="format-1 margem-inf">
        <h2 class="format-2 box-2 no-margin">PUT /api/contas_bancarias/{contaBancariaId}</h2>
        <div class="row no-margin content">
            <div v-html="mensagem" class="no-padding"></div>
            <div class="box-3">
                <form v-on:submit.prevent="updateContaBancaria">
                    <div class="input-g">
                        <input type="number" class="form-control" placeholder="ID" v-model="form.id" required>                    
                        <input type="number" step="any" class="form-control separator" placeholder="SALDO" v-model="form.saldo" required>
                        <button class="btn btn-outline-secondary" type="submit">EDITAR</button>
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
        name: "editarContaBancaria",
        data() {
            return {
                form: {
                    id: "",
                    saldo: ""
                },
                mensagem: ""
            }
        },
        methods: {
            updateContaBancaria() {
                ContaBancariaService.updateContaBancaria(this.form.id, this.form)
                .then(() => { 
                    this.mensagem = returnSuccess(`Conta Bancária editada com sucesso.`);
                })
                .catch((jqXHR) => {
                    this.mensagem = returnError(`HTTP ${jqXHR.response.data.httpCode}: ${jqXHR.response.data.mensagem}`);
                })
                .finally(() => {
                    this.form.id = "";
                    this.form.saldo = "";                                                        
                });
            }
        }
    }
    
</script>
