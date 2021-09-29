import Vue from "vue";
import Router from "vue-router";

Vue.use(Router);

export default new Router({
    mode: "history",
    routes: [
        {
            path: "/",
            alias: "/customers",
            name: "customers",
            component: () => import("./components/CustomersList")
        }/*,
        {
            path: "/tutorials/:id",
            name: "tutorial-details",
            component: () => import("./components/Tutorial")
        },
        {
            path: "/add",
            name: "add",
            component: () => import("./components/AddTutorial")
        }*/
    ]
});
