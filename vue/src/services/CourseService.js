import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:9000"
});

export default {

  list() {
    return http.get('/courses');
  },

  get(id) {
    return http.get(`/courses/${id}`);
  },

  create(course) {
    return http.post(`/courses`, course);
  },

  update(id, course) {
    return http.put(`/courses/${id}`, course);
  },

  delete(id) {
    return http.delete(`/courses/${id}`);
  }

}
