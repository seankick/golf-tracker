import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import Register from '../views/Register.vue'
import store from '../store/index'
import AddFriendToMatch from '../views/AddFriendToMatch.vue'
import FindCourses from '../views/FindCourses.vue'
import CoursesDatabase from '../views/CoursesDatabase.vue'
import EditCourse from '../views/EditCourse.vue'
import AddCourse from '../views/AddCourse.vue'
import Courses from '../views/Courses.vue'
import FindCoursesDetail from '../views/FindCoursesDetail.vue'
import AddScorecard from '../views/AddScorecard.vue'
import About from '../views/About.vue'
import CreateMatch from '../views/CreateMatch.vue'
import LeagueList from '../views/LeagueList.vue'
import InputLeagueRounds from '../components/InputLeagueRounds.vue'
import LeagueDetails from '../views/LeagueDetails.vue'
import AddNewLeague from '../views/AddNewLeague.vue'
import AddPlayerToLeague from '../views/AddPlayerToLeague.vue'

Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
    mode: 'history',
    base: process.env.BASE_URL,
    routes: [{
            path: '/',
            name: 'home',
            component: Home,
            meta: {
                requiresAuth: true
            }
        },
        {
            path: "/login",
            name: "login",
            component: Login,
            meta: {
                requiresAuth: false
            }
        },
        {
            path: "/logout",
            name: "logout",
            component: Logout,
            meta: {
                requiresAuth: false
            }
        },
        {
            path: "/register",
            name: "register",
            component: Register,
            meta: {
                requiresAuth: false
            }
        },
        {
            path: "/match/:id/add",
            name: "addFriendToMatch",
            component: AddFriendToMatch,
            meta: {
                requiresAuth: true
            }
        },
        {
            path: "/findCourses",
            name: "findCourses",
            component: FindCourses,
            meta: {
                requiresAuth: true
            }
        },
        {
            path: "/courses",
            name: "coursesDatabase",
            component: CoursesDatabase,
            meta: {
                requiresAuth: true
            }
        },
        {
            path: "/courses/:courseId",
            name: "courses",
            component: Courses,
            meta: {
                requiresAuth: true
            }
        },
        {
            path: "/courses/add-course",
            name: "addCourse",
            component: AddCourse,
            meta: {
                requiresAuth: true
            }
        },
        {
            path: "/courses/edit-course/:courseId",
            name: "editCourse",
            component: EditCourse,
            meta: {
                requiresAuth: true
            }
        },
        {
            path: "/findCourses/:name",
            name: "findCourseDetail",
            component: FindCoursesDetail,
            meta: {
                requiresAuth: true
            }
        },
        {
            path: "/addScorecard",
            name: "addScorecard",
            component: AddScorecard,
            meta: {
                requiresAuth: true
            }
        },
        {
            path: "/about",
            name: "about",
            component: About,
            meta: {
                requiresAuth: true
            }
        },
        {
            path: "/createMatch",
            name: "createMatch",
            component: CreateMatch,
            meta: {
                requiresAuth: true
            }
        },
        {
            path: "/leagueList",
            name: "leagueList",
            component: LeagueList,
            meta: {
                requiresAuth: true
            }
        },
        {
            path: "/inputLeagueRounds",
            name: "inputLeagueRounds",
            component: InputLeagueRounds,
            meta: {
                requiresAuth: true
            }
        },
        {
            path: "/league/:leagueId",
            name: "leagueDetails",
            component: LeagueDetails,
            meta: {
                requiresAuth: true
            },
        },
        {
            path: "/league/addLeague",
            name: "addNewLeague",
            component: AddNewLeague,
            meta: {
                requiresAuth: true
            }
        },
        {
            path: "/league/:leagueId/addPlayer",
            name: "addPlayerToLeague",
            component: AddPlayerToLeague,
            meta: {
                requiresAuth: true
            }
        }
    ]
})

router.beforeEach((to, from, next) => {
    // Determine if the route requires Authentication
    const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

    // If it does and they are not logged in, send the user to "/login"
    if (requiresAuth && store.state.token === '') {
        next("/login");
    } else {
        // Else let them go to their next destination
        next();
    }
});

export default router;