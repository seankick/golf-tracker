import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default{

listMatches() {
    return http.get('/matches');
},

getMatch(id){
    return http.get(`/matches/${id}`);
},

createMatch(match){
    return http.post('/matches', match);
},

updateMatch(id, match){
    return http.put(`/matches/${id}`, match);
},

deleteMatch(id){
    return http.delete(`/matches/${id}`)
}

}