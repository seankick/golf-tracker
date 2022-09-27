import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:9000"
});

export default {

  list() {
    return http.get('/holes');
  },

  get(id) {
    return http.get(`/holes/${id}`);
  },

  create(hole) {
    return http.post(`/holes`, hole);
  },

  update(id, hole) {
    return http.put(`/holes/${id}`, hole);
  },

  delete(id) {
    return http.delete(`/holes/${id}`);
  }

}
