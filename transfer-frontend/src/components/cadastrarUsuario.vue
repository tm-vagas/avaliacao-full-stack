<template>
    <div class="format-1 margem-inf">
        <h2 class="format-2 box-2 no-margin">POST /api/usuarios</h2>
        <div class="row no-margin content">
            <div v-html="mensagem" class="no-padding"></div>
            <div class="box-3">
                <form v-on:submit.prevent="createUsuario">
                    <div class="input-g">                    
                        <input type="text" class="form-control" placeholder="NOME" v-model="form.nome" required>
                        <button class="btn btn-outline-secondary" type="submit">CADASTRAR</button>
                     </div>
                </form>
            </div>
        </div>    
    </div>
</template>

<script>
    
    import UsuarioService from "../services/UsuarioService"
    
    const returnSuccess = (successMessage) => `<div class="box-3"><div class="alert alert-success alert-dismissible fade show" role="alert"><i class="bi bi-check-circle-fill"></i>${successMessage}<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button></div></div>`;

    export default {
        name: "cadastrarUsuario",
        data() {
            return {
                form: {
                    nome: ""
                },
                mensagem: ""
            }
        },
        methods: {
            createUsuario() {
                UsuarioService.createUsuario(this.form)
                .then(() => { 
                    this.mensagem = returnSuccess(`Usuário cadastrado com sucesso.`);
                })
                .finally(() => {
                    this.form.nome = "";                                                         
                });
            }
        }
    }
    
</script>
