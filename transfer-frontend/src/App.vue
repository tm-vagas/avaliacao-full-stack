<template>
  <h1><strong>DASHBOARD</strong></h1>
  <cadastrarUsuario />
  <editarUsuario />
  <excluirUsuario />
  <listarUsuarios />
  <pesquisarUsuario />
  <cadastrarContaBancaria />
  <editarContaBancaria />
  <excluirContaBancaria />
  <listarContasBancarias />
  <pesquisarContaBancaria />
  <cadastrarTransferencia />
  <editarTransferencia />
  <excluirTransferencia />
  <listarTransferencias />
  <pesquisarTransferencia />
</template>

<script>

import cadastrarUsuario from "./components/cadastrarUsuario.vue"
import editarUsuario from "./components/editarUsuario.vue"
import excluirUsuario from "./components/excluirUsuario.vue"
import listarUsuarios from "./components/listarUsuarios.vue"
import pesquisarUsuario from "./components/pesquisarUsuario.vue"
import cadastrarContaBancaria from "./components/cadastrarContaBancaria.vue"
import editarContaBancaria from "./components/editarContaBancaria.vue"
import excluirContaBancaria from "./components/excluirContaBancaria.vue"
import listarContasBancarias from "./components/listarContasBancarias.vue"
import pesquisarContaBancaria from "./components/pesquisarContaBancaria.vue"
import cadastrarTransferencia from "./components/cadastrarTransferencia.vue"
import editarTransferencia from "./components/editarTransferencia.vue"
import excluirTransferencia from "./components/excluirTransferencia.vue"
import listarTransferencias from "./components/listarTransferencias.vue"
import pesquisarTransferencia from "./components/pesquisarTransferencia.vue"

export default {
  name: "App",
  components: {
    cadastrarUsuario,
    editarUsuario,
    excluirUsuario,  
    listarUsuarios,
    pesquisarUsuario,
    cadastrarContaBancaria,
    editarContaBancaria,
    excluirContaBancaria,
    listarContasBancarias,
    pesquisarContaBancaria,
    cadastrarTransferencia,
    editarTransferencia,
    excluirTransferencia,
    pesquisarTransferencia,
    listarTransferencias
  }
}
</script>

<style>
#app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
}

#app,
.format-2,
.form-control::placeholder {
    color: #2C3E50 !important;
}

.box-1 {
    padding: 30px !important;
}

.box-2 {
    padding: 15px !important;
}

.box-3 {
   padding: 15px 0 0 15px !important;
}

h1 {
    margin-bottom: 0 !important;
    padding-bottom: 30px !important;
}

.margem-inf {
    margin-bottom: 30px;
}

.no-margin {
    margin: 0 !important;
}

.no-padding {
    padding: 0 !important;
}

.content {
    padding-bottom: 15px;
}

.format-1 {
    border-radius: 12px;
    height: 100%;    
}

.format-1,
.form-control {
    border: solid 1px #2C3E50 !important;
}

.format-2 {    
    background-color: #E9ECEF;
    border-bottom: solid 1px #2C3E50;
    border-radius: 12px 12px 0 0;
}

.form-control:focus {
    box-shadow: none !important;
}

p {
    font-size: 18px;
}

button {
    background-color: #2C3E50 !important;
    border: none !important;
    color: #FFF !important;
    margin-top: 15px !important;
    float: right;
}

.alert {
    padding: 10px 10px 10px 10px !important;
    margin-bottom: 0 !important;
    text-align: left !important;
}

.alert-dismissible .btn-close {
    background-color: initial !important;
    top: -20px !important;
}

i {
    margin-right: 10px !important;
}

.separator {
    margin-top: 15px;
}

@media (min-width: 768px) {    
    .content {
        padding-right: 15px !important;
    }
}

@media (max-width: 767px) {
    .box-3 {
        padding-right: 15px !important;
    }
}

</style>
