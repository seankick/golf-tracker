<template>
  <div class="app">
    <!-- <div id="league-full-form" class="league-create-box"> -->

    <aside class="sidebar">
      <h3>Menu</h3>
      <nav class="menu">
        <router-link class="menu-item" :to="{ name: 'home' }">Home</router-link>
        <router-link class="menu-item" :to="{ name: 'findCourses' }">Find Courses</router-link>
        <router-link class="menu-item" :to="{ name: 'coursesDatabase' }">Course Database</router-link>
        <router-link class="menu-item" :to="{ name: 'addScorecard' }">Make A Scorecard</router-link>
        <router-link class="menu-item" :to="{ name: 'createMatch' }"> Create A Match</router-link>
        <router-link class="menu-item is-active" :to="{ name: 'leagueList' }">Leagues</router-link>
        <router-link class="menu-item" :to="{ name: 'inputLeagueRounds' }"
          >Input League Rounds</router-link
        >
        <router-link class="menu-item" :to="{ name: 'about' }"
          >About</router-link
        >
        <a class="menu-item" href="">Sign out</a>
      </nav>
    </aside>

    <div class="content">
      <form v-on:submit.prevent="addNewLeagueForm">
        <div class="league-form-element" name="league-name">
          <label for="league-name">League Name: </label>
          <input
            id="league-name"
            type="text"
            class="text-input"
            v-model="newLeague.leagueName"
          />
        </div>
        <div class="league-form-element" name="start">
          <label for="start-date">Start Date:
            <br />
             </label>
          <input
            type="date"
            
            class="league-date"
            v-model="newLeague.startDate"
          />
          
        </div>
        <div class="league-form-element" name="end">
          <label for="end-date">End Date: 
            <br />
          </label>
          <input
            type="date"
           
            class="league-date"
            v-model="newLeague.endDate"
          />
        </div>
        <div class="league-form-element" name="overview-area">
          <label for="overview">League Overview: </label>
          <textarea
            type="textarea"
            id="league-overview"
            class="text-input-overview"
            v-model="newLeague.overview"
          />
        </div>
        <div class="league-form-element" name="courses">
          <label for="course">Course: </label>
          <select id="course-name" v-model="newLeague.courseId">
            <option
              :value="course.courseId"
              v-for="course in courses"
              :key="course.courseId"
            >
              {{ course.courseName }}
            </option>
          </select>
        </div>

        <div class="button-holder">
          <input type="submit" class="form-button" value="Create" />

          <input
            type="button"
            value="Cancel"
            name="cancel-button"
            class="form-button"
            v-on:click="leaveLeagueCreation"
          />
        </div>
      </form>
    </div>
  </div>
  <!-- </div> -->
</template>

<script>
import LeagueService from "../services/LeagueService.js";
import CourseService from "../services/CourseService.js";
export default {
  name: "create-League",
  data() {
    return {
      showLeagueForm: false,
      newLeague: {
        startDate: "",
        endDate: "",
        overview: "",
        courseId: "",
      },
      courses: [],
    };
  },
  methods: {
    addNewLeagueForm() {
      LeagueService.create(this.newLeague).then((response) => {
        if (response === 201) {
          this.league = {
            startDate: "",
            endDate: "",
            overview: "",
            courseId: "",
          };
          
        }
        this.$router.push("/leagueList");
      });
      this.resetLeagueForm();
    },
    resetLeagueForm() {
      this.newLeague = {};
    },
    leaveLeagueCreation() {
      this.newLeague = {};
      this.$router.push("/leagueList");
    },
  },
  created() {
    CourseService.list().then((response) => {
      this.courses = response.data;
    });
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
}

div.league-form {
  display: inline-block;
  border: black solid 2px;
  box-shadow: 0 0 20px rgb(0 0 0 / 15%);
  border-radius: 7px;
  margin-top: 200px;
  margin-left: auto;
  margin-right: auto;
  height: 410px;
  width: 300px;
  padding: 15px;
  text-align: center;
}

div.league-form-element {
  margin-bottom: 15px;
}

input {
  display: block;
  border: none;
  text-align: center;
  width: auto;
}

label {
  text-align: center;
  margin-bottom: 10px;
}

textarea {
  padding: 5px;
}

.form-button {
  display: inline;
  margin: 10px;
  height: 30px;
  width: 60px;
  font-weight: bold;
}



div.button-holder {
  display: inline-block;
  text-align: center;
}

.text-input {
  border: black solid 1px;
  margin-left:50px;

}

input.league-date{
  margin-left: 80px;
  /* display: block; */
  
}

textarea {
  border: black solid 1px;
  width: 260px;
  height: 100px;
}
</style>