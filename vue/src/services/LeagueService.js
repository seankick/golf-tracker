import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:9000"
});

export default {

    create(league) {
        return http.post(`/leagues`, league);
      },
      list() {
        return http.get('/leagues');
      },
      get(leagueId) {
        return http.get(`/leagues/${leagueId}`);
      }
}