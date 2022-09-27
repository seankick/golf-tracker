<template>
  <div class="course-list">
    <router-link
      :to="{
        name: 'addCourse',
      }"
      class="addCourse"
      >Add New Course</router-link
    >

    <div class="try-me">
      <table class="courses-table">
        <thead>
          <tr>
            <th colspan="3">Courses</th>
          </tr>
        </thead>
        <tbody>
          <tr
            v-for="course in this.$store.state.courses"
            v-bind:key="course.courseId"
          >
            <td width="80%">
              <router-link
                v-bind:to="{
                  name: 'courses',
                  params: { courseId: course.courseId },
                }"
                >{{ course.courseName }}</router-link
              >
            </td>
            <td>
              <router-link
                class="edit-course"
                :to="{
                  name: 'editCourse',
                  params: { courseId: course.courseId },
                }"
                >Edit</router-link
              >
            </td>
            <td>
              <a
                class="delete-button"
                href="#"
                v-on:click="deleteCourse(course.courseId)"
                >Delete</a
              >
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import courseService from "@/services/CourseService.js";

export default {
  name: "course-list",
  methods: {
    //Need to write addCourse() method

    getCourses() {
      courseService.list().then((response) => {
        this.$store.commit("SET_COURSES", response.data);
      });
    },
    deleteCourse(id) {
      courseService.delete(id).then((response) => {
        if (response.status === 200) {
          this.getCourses();
        }
      });
    },
  },
  created() {
    this.getCourses();
  },
};
</script>

<style>
.edit-course {
  text-decoration: none;
}

.delete-button {
  text-decoration: none;
  color: red;
}

.courses-table {
  border-collapse: collapse;
  margin-left: 400px;
  font-size: 0.9em;
  min-width: 600px;
  border-radius: 5px 5px 0 0;
  overflow: hidden;
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
}

.courses-table thead tr {
  background-color: #2e3047;
  color: white;
  text-align: left;
  font-weight: bold;
}

.courses-table th,
.courses-table td {
  padding: 12px 15px;
  border: none;
}

.courses-table td:last-child {
  text-align: center;
}

.courses-table tbody tr {
  border-bottom: 1px solid #2e3047;
}

.courses-table tbody tr:nth-of-type(even) {
  background-color: #f3f3f3;
}

.courses-table tbody tr:last-of-type {
  border-bottom: 2px solid #2e3047;
}

.addCourse {
  display: block;
width: 145px;
margin-left: 725px;
margin-bottom: 20px;
  padding: 10px;
  border: 1px solid black;
  border-radius: 7px;
  text-decoration: none;
  background-color: lightgray;
  color: black;
}

div.try-me{
  display: inline-block; 
}
</style>