<template>

  <div class = "app">
       <aside class="sidebar">
        <h3>Menu</h3>
        <nav class="menu">
            <router-link  class="menu-item is-active" :to="{name: 'home'}">Home</router-link>
            <router-link  class="menu-item" :to="{name: 'findCourses'}">Find Courses</router-link>
            <router-link class="menu-item" :to="{name: 'coursesDatabase' }">Course Database</router-link>
            <router-link class="menu-item" :to="{name: 'addScorecard'}"> Make A Scorecard</router-link>
             <router-link class="menu-item" :to="{name: 'createMatch'}"> Create A Match</router-link>
             <router-link class="menu-item" :to="{ name: 'leagueList' }">Leagues</router-link>
             
            <router-link class="menu-item" :to="{name: 'about' }">About</router-link>
            <a class="menu-item" href="">Sign out</a>
        </nav>
    </aside>
    <main class="content">
    <router-link
        :to="{name: 'editCourse', params: {courseId: $store.state.activeCourse.courseId}}"
        tag="button"
        class="btnEditCourse"
        >Edit</router-link
      >
      <button class="btnDeleteCourse" v-on:click="deleteCourse(this.state.activeCourse.courseId)">
        Delete
      </button>
      <table class="upcoming-table">
    <thead>
      <th class="header">{{ this.$store.state.activeCourse.courseName }}</th>

      </thead>

    <tbody>
        <tr class="row-detail">Course ID: {{course.courseId}}</tr>
        <tr class="row-detail">City: {{course.city}}</tr>
        <tr class="row-detail">State: {{course.state}}</tr>
        <tr class="row-detail">Postal Code: {{course.postalCode}}</tr>
        <tr class="row-detail">Google Plus Code: {{course.googlePlusCode}}</tr>
      <!-- <tr v-for="(value, key) in this.$store.state.activeCourse"
      v-bind:key="key"
      class = "details">{{ key }} - {{ value }}</tr> -->
    
    </tbody>
    </table>
    </main>
  </div>
</template>

<script>
import courseService from "@/services/CourseService.js";

export default {
  name: "course-details",
  props: {
    courseId: Number,
  },
  data() {
    return {
      course: {}
    }
  },
  methods: {
     getCourses() {
      courseService.get(this.$route.params.courseId).then((response) => {
        this.course = response.data;
      });
    },
    deleteCourse(id) {
      courseService.delete(id).then((response) => {
        if (response.status === 200) {
          this.getCourses();
        }
      });
      this.$router.push('/courses')
    },
  },
  created() {
    this.getCourses();
  },
};
</script>
<style>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: sans-serif;
}
body {
  overflow-x: scroll;
}

main{
  width: 100vw;
}

.app {
  display: flex;
  min-height: 100vh;
}

.sidebar {
  flex: 1 1;
  max-width: 300px;
  padding: 2rem 1rem;
  background-color: #2e3047;
}

.sidebar h3 {
  color: #707793;
  text-transform: uppercase;
  margin-bottom: 0.75rem;
}

.sidebar .menu {
  margin: 0 -1rem;
}

.sidebar .menu .menu-item {
  display: block;
  padding: 1em;
  color: white;
  text-decoration: none;
  transition: 0.4s linear;
}

.sidebar .menu .menu-item:hover,
.sidebar .menu .menu-item.is-active {
  color: #3bba9c;
  border-right: 5px solid #3bba9c;
}

.content {
  flex: 1 1 0;
  padding: 2rem;
  background: white;
  text-align: center;
  
}

.content h1 {
  color: #3c3f56;
  font-size: 2.5rem;
  margin-bottom: 1rem;
}

.content p {
  color: #707793;
  margin-bottom: 20px;
}

.coords-display {
    display: flex;
}

.content h2 {
  color: #3c3f56;
  font-size: 1.3rem;
  margin-left: 25px;
  margin-top: 25px;
}
.details{
  font-size: 20px;
}
.header{
  font-size: 40px;
  background-color: #2e3047;
  color: white;
}

.btnEditCourse {
  height: 30px;
  width: 60px;
  margin-right: 10px;
  border-radius: 5px;
  font-weight: bold;
}

.btnDeleteCourse{
  height: 30px;
  width: 60px;
  margin-left: 10px;
  border-radius: 5px;
  font-weight: bold;
}

tr.row-detail{
  display: block;
  height: 40px;
  justify-content: center;
  text-align: center;
  padding-top: 10px;
  font-size: 20px;
}

</style>
