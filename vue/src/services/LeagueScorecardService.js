import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {



    create(leagueScorecard) {
        return http.post(`/leaguescorecards`, leagueScorecard);
    },

    get(leagueId) {
        return http.get(`leagues/leaguescorecards/${leagueId}`);
    },

    update(leagueScorecardId, course) {
        return http.put(`/leaguescorecards/${leagueScorecardId}`, course);
    },

    delete(leagueScorecardId) {
        return http.delete(`/leaguescorecards/${leagueScorecardId}`);
    }




}