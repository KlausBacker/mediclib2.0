import Vue from 'vue'
import VueRouter from 'vue-router'
// import Home from '../views/Home.vue'
// *******   UI layout components imports   *******
import UiLayout from '../layouts/UI/components/ui-layout.vue'
import Home from '../layouts/UI/components/ui-home.vue'
import PatientProfile from '../layouts/UI/components/patient/patient-profile.vue'
import PatientDashboard from '../layouts/UI/components/patient/patient-dashboard.vue'
// *******   Admin layout components imports   *******
import Adminlayout from '../layouts/admin/components/AdminLayout.vue'
import AdminDashboard from '../layouts/admin/components/admin-dashboard.vue'
import DoctorList from '../layouts/admin/components/doctor/doctor-list.vue'
import DoctorForm from '../layouts/admin/components/doctor/doctor-form.vue'
import SpecialityList from '../layouts/admin/components/speciality/speciality-list.vue'
import SpecialityForm from '../layouts/admin/components/speciality/speciality-form.vue'
import ConditionList from '../layouts/admin/components/condition/condition-list.vue'
import ConditionForm from '../layouts/admin/components/condition/condition-form.vue'
import PatientList from '../layouts/admin/components/patient/patient-list.vue'
import PatientDetail from '../layouts/admin/components/patient/patient-detail.vue'
// *******   Doctor layout components imports   *******
import Doctorlayout from '../layouts/doctor/components/doctorLayout.vue'
import DoctorDashboard from '../layouts/doctor/components/doctor-dashboard.vue'
import DoctorProfile from '../layouts/doctor/components/doctor-profile.vue'

Vue.use(VueRouter)

const routes = [
  // {
  //   path: '/',
  //   name: 'Home',
  //   component: Home
  // },
  // {
  //   path: '/about',
  //   name: 'About',
  //   // route level code-splitting
  //   // this generates a separate chunk (about.[hash].js) for this route
  //   // which is lazy-loaded when the route is visited.
  //   component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  // },
  // *******   UI routes   *******
  {
    path: '/',
    name: 'UI',
    component: UiLayout,
    children: [
      {
        path: '',
        component: Home
      },
      {
        path: 'home',
        component: Home
      },
      {
        path: 'patient-profile',
        name: 'PatientProfile',
        component: PatientProfile
      },
      {
        path: 'patient-dashboard',
        name: 'PatientDashbord',
        component: PatientDashboard
      }
    ]
  },
  // *******   Admin routes   *******
  {
    path: '/admin',
    name: 'Admin',
    component: Adminlayout,
    children: [
      {
        path: '',
        component: AdminDashboard
      },
      {
        path: '/doctor',
        name: 'Doctor',
        component: DoctorList
      },
      {
        path: '/doctor-form',
        name: 'DoctorForm',
        component: DoctorForm
      },
      {
        path: '/speciality',
        name: 'Speciality',
        component: SpecialityList
      },
      {
        path: '/speciality-form',
        name: 'SpecialityForm',
        component: SpecialityForm
      },
      {
        path: '/condition',
        name: 'Condition',
        component: ConditionList
      },
      {
        path: '/condition-form',
        name: 'ConditionForm',
        component: ConditionForm
      },
      {
        path: '/patient',
        name: 'Patent',
        component: PatientList
      },
      {
        path: '/patient-detail',
        name: 'PatientDetail',
        component: PatientDetail
      }
    ]
  },
  {
    path: '/doctor-admin',
    name: 'Doctor',
    component: Doctorlayout,
    children: [
      {
        path: '',
        component: DoctorDashboard
      },
      {
        path: '/profile/{id}',
        name: 'Profile',
        component: DoctorProfile
      }
    ]
  }

]

const router = new VueRouter({
  routes
})

export default router
