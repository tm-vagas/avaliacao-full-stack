<template>
    <div class="format-1 margem-inf">
        <h2 class="format-2 box-2 no-margin">POST /api/contas_bancarias/{usuarioId}</h2>
        <div class="row no-margin content">
            <div v-html="mensagem" class="no-padding"></div>
            <div class="box-3">
                <form v-on:submit.prevent="createContaBancaria">
                    <div class="input-g">                    
                        <input type="number" step="any" class="form-control" placeholder="SALDO" v-model="form.saldo" required>
                        <input type="number" class="form-control separator" placeholder="USUÁRIO ID" v-model="form.usuarioId" required>               
                        <button class="btn btn-outline-secondary" type="submit">CADASTRAR</button>
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
        name: "cadastrarContaBancaria",
        data() {
            return {
                form: {
                    saldo: "",
                    usuarioId: ""
                },
                mensagem: ""
            }
        },
        methods: {
            createContaBancaria() {
                ContaBancariaService.createContaBancaria(this.form.usuarioId, this.form)
                .then(() => { 
                    this.mensagem = returnSuccess(`Conta Bancária cadastrada com sucesso.`);
                })
                .catch((jqXHR) => {
                    this.mensagem = returnError(`HTTP ${jqXHR.response.data.httpCode}: ${jqXHR.response.data.mensagem}`);
                })
                .finally(() => {
                    this.form.saldo = ""; 
                    this.form.usuarioId = "";                                                         
                });
            }
        }
    }
    
</script>
