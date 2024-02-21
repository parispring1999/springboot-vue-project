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
        children:[
            {
                path:'/main',
                name:'main',
                meta:{
                    title:'首页'
                },
                component:()=>import('../components/Main')
            },
            /*{
                path:'/admin',
                name:'admin',
                meta:{
                    title:'管理员管理'
                },
                component:()=>import('../components/AdminManage')
            },
            {
                path:'/user',
                name:'user',
                meta:{
                    title:'用户管理'
                },
                component:()=>import('../components/UserManage')
            }*/
        ]
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
        routes,
    }
)

const VueRouterPush=VueRouter.prototype.push
VueRouter.prototype.push=function push(to){
    return VueRouterPush.call(this,to).catch(err=>err)
}

export default router