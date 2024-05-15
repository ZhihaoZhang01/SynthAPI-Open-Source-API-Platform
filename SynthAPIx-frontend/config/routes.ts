export default [
  { path: '/', name: 'Main Page', icon: 'smile', component: './Index' },
  { path: '/interface_info/:id', name: 'Check API', icon: 'smile', component: './InterfaceInfo', hideInMenu: true },
  {
    path: '/user',
    layout: false,
    routes: [{ name: 'Login', path: '/user/login', component: './User/Login' }],
  },
  {
    path: '/admin',
    name: 'Admin',
    icon: 'crown',
    access: 'canAdmin',
    routes: [
      { name: 'API Management', icon: 'table', path: '/admin/interface_info', component: './Admin/InterfaceInfo' },
      { name: 'API Analysis', icon: 'analysis', path: '/admin/interface_analysis', component: './Admin/InterfaceAnalysis' },
    ],
  },

  // { path: '/', redirect: '/welcome' },
  { path: '*', layout: false, component: './404' },
];
