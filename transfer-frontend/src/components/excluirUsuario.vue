<template>
    <div class="format-1 margem-inf">
        <h2 class="format-2 box-2 no-margin">DELETE /api/usuarios/{usuarioId}</h2>
        <div class="row no-margin content">
            <div v-html="mensagem" class="no-padding"></div>
            <div class="box-3">
                <form v-on:submit.prevent="deleteUsuario">
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
    
    import UsuarioService from "../services/UsuarioService"
    
    const returnSuccess = (successMessage) => `<div class="box-3"><div class="alert alert-success alert-dismissible fade show" role="alert"><i class="bi bi-check-circle-fill"></i>${successMessage}<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button></div></div>`;
    
    const returnError = (errorMessage) => `<div class="box-3"><div class="alert alert-danger alert-dismissible fade show" role="alert"><i class="bi bi-exclamation-triangle-fill"></i>${errorMessage}<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button></div></div>`;

    export default {
        name: "excluirUsuario",
        data() {
            return {
                form: {
                    id: ""
                },
                mensagem: ""
            }
        },
        methods: {
            deleteUsuario() {
                UsuarioService.deleteUsuario(this.form.id)
                .then(() => { 
                    this.mensagem = returnSuccess(`Usuário excluído com sucesso.`);
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
