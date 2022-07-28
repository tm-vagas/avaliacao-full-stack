import { createWebHistory, createRouter } from "vue-router";
const routes =  [
  {
    path: "/",
    alias: "/agendamento-list",
    name: "agendamento-list",
    component: () => import("./components/AgendamentosList")
  },
  {
    path: "/add-agendamento",
    name: "add-agendamento",
    component: () => import("./components/AddAgendamento")
  }
];
const router = createRouter({
  history: createWebHistory(),
  routes,
});
export default router;