<template>
  <div id="app">
    <nav class="navbar navbar-expand navbar-dark bg-dark">
      <router-link to="/" class="navbar-brand">Home</router-link>
      <div class="navbar-nav mr-auto">
        <li class="nav-item">
          <router-link to="/agendamento-list" class="nav-link">Consulta Agendamentos</router-link>
        </li>
        <li class="nav-item">
          <router-link to="/add-agendamento" class="nav-link">Agenda Transferência</router-link>
        </li>
      </div>
    </nav>
    <div class="container mt-3">
      <router-view />
    </div>
  </div>
</template>
<script>
export default {
  name: "app"
};
</script>