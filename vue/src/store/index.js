import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'


Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if (currentToken != null) {
    axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
    state: {
        token: currentToken || '',
        user: currentUser || {},
        course: {
            name: '',
            distance: 0,
            zip_code: 0
        },
        localCourses: [],
        leagues: [],
        courses: [],
        activeLeagueScorecard: {
            leagueScorecardId: 0,
            leagueId: "",
            courseName: "",
            matchDate: "",
            username: "",
            teeSelection: "",
            hole1Score: "",
            hole2Score: "",
            hole3Score: "",
            hole4Score: "",
            hole5Score: "",
            hole6Score: "",
            hole7Score: "",
            hole8Score: "",
            hole9Score: "",
            hole10Score: "",
            hole11Score: "",
            hole12Score: "",
            hole13Score: "",
            hole14Score: "",
            hole15Score: "",
            hole16Score: "",
            hole17Score: "",
            hole18Score: "",
            totalStrokes: "",
            totalCoursePar: "",
            roundScoreRelativeToPar: "",
        },
        activeCourse: {
            courseId: 0,
            courseName: '',
            city: '',
            state: '',
            postalCode: 0,
            googlePlusCode: '',


            imagePath: '',
            redTeeExists: null,
            goldTeeExists: null,
            whiteTeeExists: null,
            blackTeeExists: null,
            blueTeeExists: null,
            greenTeeExists: null,
            silverTeeExists: null,

            redTeeFrontPar: null,
            goldTeeFrontPar: null,
            whiteTeeFrontPar: null,
            blackTeeFrontPar: null,
            blueTeeFrontPar: null,
            greenTeeFrontPar: null,
            silverTeeFrontPar: null,

            redTeeBackPar: null,
            goldTeeBackPar: null,
            whiteTeeBackPar: null,
            blackTeeBackPar: null,
            blueTeeBackPar: null,
            greenTeeBackPar: null,
            silverTeeBackPar: null,

            redTeeFrontYards: null,
            goldFrontYards: null,
            whiteFrontYards: null,
            blackFrontYards: null,
            blueFrontYards: null,
            greenFrontYards: null,
            silverFrontYards: null,

            redTeeBackYards: null,
            goldBackYards: null,
            whiteBackYards: null,
            blackBackYards: null,
            blueBackYards: null,
            greenBackYards: null,
            silverBackYards: null,
        },

        matches: [],
        leagueScorecards: [],
        activeHole: {},

    },


    mutations: {
        SET_COURSES(state, data) {
            state.courses = data;
        },
        SET_LEAGUES(state, data) {
            state.leagues = data;
        },
        SET_ACTIVE_COURSE(state, data) {
            state.activeCourse = data;
        },
        SET_ACTIVE_HOLE(state, data) {
            state.activeHole = data;
        },
        SET_LEAGUE_SCORECARDS(state, data) {
            state.leagueScorecards = data;
        },
        SET_AUTH_TOKEN(state, token) {
            state.token = token;
            localStorage.setItem('token', token);
            axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
        },
        SET_USER(state, user) {
            state.user = user;
            localStorage.setItem('user', JSON.stringify(user));
        },
        LOGOUT(state) {
            localStorage.removeItem('token');
            localStorage.removeItem('user');
            state.token = '';
            state.user = {};
            axios.defaults.headers.common = {};
        },
        SET_LOCAL_COURSES(state, data) {
            state.localCourses = data;
        },
        ADD_INSTANT_MATCH(state, match) {
            state.matches.unshift(match);
        },
        ADD_NEW_SCHEDULED_MATCH(state, match) {
            state.matches.unshift(match);
        },
        ADD_LEAGUE(state, league) {
            state.leagues.unshift(league);
        },
        ADD_NEW_LEAGUESCORECARD(state, leagueScorecard) {
            state.leagueScorecards.unshift(leagueScorecard);
        }
    }
})