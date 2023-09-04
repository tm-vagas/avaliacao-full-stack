<template>
    <div class="format-1 margem-inf">    
        <h2 class="format-2 box-2 no-margin">GET /api/usuarios</h2>        
        <div class="row no-margin content">
            <div class="box-3">
                <form v-on:submit.prevent="getUsuarios">
                    <div class="input-g"> 
                        <button class="btn btn-outline-secondary no-margin" type="submit">RELISTAR</button>
                    </div>
                </form>
            </div>
            <div v-for="usuario in usuarios" v-bind:key="usuario.id" class="col-lg-4 col-md-4 col-sm-12 col-xs-12 box-3">                
                <div class="format-1">
                    <p class="box-3 no-margin">
                        <strong>Id:</strong> <span>{{usuario.id}}</span><br>
                        <strong>Nome:</strong> <span>{{usuario.nome}}</span>
                    </p>                                
                    <div class="box-2">
                        <div class="format-1">
                            <p class="format-2 box-2 no-margin">CONTAS BANCÁRIAS</p>
                            <p v-for="contaBancaria in usuario.contasBancarias" v-bind:key="contaBancaria.id" class="box-2 no-margin"> 
                                <strong>Id:</strong> <span>{{contaBancaria.id}}</span><br>
                                <strong>Saldo:</strong> <span>{{contaBancaria.saldo}}</span>
                            </p>
                        </div>
                    </div>          
                </div>                                      
            </div>
        </div>
    </div>    
</template>

<script>
    
    import UsuarioService from "../services/UsuarioService"
    
    export default {
        name: "listarUsuarios",
        data(){
            return {
                usuarios : []
            }                        
        },
        methods: {
            getUsuarios(){
                UsuarioService.getUsuarios().then((response) => {
                    this.usuarios = response.data;
                });
            },                        
        },
        created(){
            this.getUsuarios()
        }
    }  
    
</script>
