<template>
    <div class="format-1 margem-inf">
        <h2 class="format-2 box-2 no-margin">PUT /api/usuarios/{usuarioId}</h2>
        <div class="row no-margin content">
            <div v-html="mensagem" class="no-padding"></div>
            <div class="box-3">
                <form v-on:submit.prevent="updateUsuario">
                    <div class="input-g">
                        <input type="number" class="form-control" placeholder="ID" v-model="form.id" required>                    
                        <input type="text" class="form-control separator" placeholder="NOME" v-model="form.nome" required>
                        <button class="btn btn-outline-secondary" type="submit">EDITAR</button>
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
        name: "editarUsuario",
        data() {
            return {
                form: {
                    id: "",
                    nome: ""
                },
                mensagem: ""
            }
        },
        methods: {
            updateUsuario() {
                UsuarioService.updateUsuario(this.form.id, this.form)
                .then(() => { 
                    this.mensagem = returnSuccess(`Usuário editado com sucesso.`);
                })
                .catch((jqXHR) => {
                    this.mensagem = returnError(`HTTP ${jqXHR.response.data.httpCode}: ${jqXHR.response.data.mensagem}`);
                })
                .finally(() => {
                    this.form.id = "";
                    this.form.nome = "";                                                         
                });
            }
        }
    }
    
</script>
