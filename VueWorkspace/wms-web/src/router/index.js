import VueRouter from 'vue-router'

const routes=[
    {
        path:'/',
        name:'login',
        component:()=>import('../components/Login')
    },
    {
        path:'/index',
        name:'index',
        component:()=>import('../components/Index'),
        /*children:[
            {
                path:'/home',
                name:'home',
                meta:{
                    title:'首页'
                },
                component:()=>import('../components/MyHome')
            }
        ]*/
    },
    {
        path:'/home',
        name:'home',
        component:()=>import('../components/MyHome')
    }
]

const router=new VueRouter(
    {
        mode:'history',
        routes
    }
)

export default router