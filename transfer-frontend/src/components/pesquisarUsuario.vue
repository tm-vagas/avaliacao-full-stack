<template>
    <div class="format-1 margem-inf">
        <h2 class="format-2 box-2 no-margin">GET /api/usuarios/{usuarioId}</h2>
        <div class="row no-margin content">
            <div v-html="mensagem" class="no-padding"></div>
            <div class="box-3">
                <form v-on:submit.prevent="getUsuarioById">
                    <div class="input-g">                    
                        <input type="number" class="form-control" placeholder="ID" v-model="form.id" required>
                        <button class="btn btn-outline-secondary" type="submit">PESQUISAR</button>
                     </div>
                </form>
            </div>
            <div v-html="usuario" class="col-lg-4 col-md-4 col-sm-12 col-xs-12 box-3"></div>
        </div>    
    </div>  
</template>

<script>
    
    import UsuarioService from "../services/UsuarioService"
    
    const returnError = (errorMessage) => `<div class="box-3"><div class="alert alert-danger alert-dismissible fade show" role="alert"><i class="bi bi-exclamation-triangle-fill"></i>${errorMessage}<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button></div></div>`;

    export default {
        name: "pesquisarUsuario",
        data() {
            return {
                form: {
                    id: ""
                },
                mensagem: "",
                usuario: ""
            }
        },
        methods: {
            getUsuarioById() {
                UsuarioService.getUsuarioById(this.form.id)
                .then((response) => {
                    let contasBancarias = "";
                    for(let i = 0; i < response.data.contasBancarias.length; i++){
                        contasBancarias = contasBancarias + "<p class=\"box-2 no-margin\"><strong>Id:</strong> <span>"+response.data.contasBancarias[i].id+"</span><br><strong>Saldo:</strong> <span>"+response.data.contasBancarias[i].saldo+"</span></p>";
                    }
                    const conteudo = "<div class=\"format-1\"><p class=\"box-3 no-margin\"><strong>Id:</strong> <span>"+response.data.id+"</span><br><strong>Nome:</strong> <span>"+response.data.nome+"</span></p><div class=\"box-2\"> <div class=\"format-1\"> <p class=\"format-2 box-2 no-margin\">CONTAS BANCÁRIAS</p>"+contasBancarias+"</div></div></div>";
                    this.usuario = conteudo;
                    this.mensagem = "";
                })
                .catch((jqXHR) => { 
                    this.mensagem = returnError(`HTTP ${jqXHR.response.data.httpCode}: ${jqXHR.response.data.mensagem}`);
                    this.usuario = "";
                })
                .finally(() => {
                    this.form.id = "";                                                         
                });
            }
        }
    }
    
</script>
