

<template>
  <div class="app">
    <aside class="sidebar">
      <h3>Menu</h3>
      <nav class="menu">
         <router-link  class="menu-item" :to="{name: 'home'}">Home</router-link>
            <router-link  class="menu-item is-active" :to="{name: 'findCourses'}">Find Courses</router-link>
            <router-link class="menu-item" :to="{name: 'coursesDatabase' }">Course Database</router-link>
            <router-link class="menu-item" :to="{name: 'addScorecard'}"> Make A Scorecard</router-link>
             <router-link class="menu-item" :to="{name: 'createMatch'}"> Create A Match</router-link>
             <router-link class="menu-item" :to="{ name: 'leagueList' }">Leagues</router-link>
             
            <router-link class="menu-item" :to="{name: 'about' }">About</router-link>
            <a class="menu-item" href="">Sign out</a>
      </nav>
    </aside>

    <button
      class="create-scheduled"
      v-if="showScheduled === false"
      v-on:click.prevent="showScheduled = true">Create Scheduled Match</button>

    <div class="scheduled-match" v-if="showScheduled === true">
      <form v-on:submit.prevent="addNewScheduledMatch">
        <h2>Schedule a Match</h2>
        
        <div class="scheduled-element">
          <label for="course-name">Course Name:
            <br/>
             </label>
          <select id="course-name" v-model="match.courseId">
           <option value="0"></option>
            <option :value="course.courseId" v-for="course in courses" :key="course.courseId">{{course.courseName}}</option>
          </select>
        </div>

        <div class="scheduled-element">
          <label for="players">
            Number of Players:
            <br/>
             </label>
          <select id="num-of-players" v-model="match.numberOfPlayers">
            <option value="0"></option>
            <option value="1">1 Player</option>
            <option value="2">2 Players</option>
            <option value="3">3 Players</option>
            <option value="4">4 Players</option>
          </select>
        </div>
     
        <div class="scheduled-element">
          <label for="start-date">Date:
            <br/>
             </label>
          <input type="datetime-local" id="date" v-model="match.startDateTime"/>
        </div>
        <div class="button-holder">
        <button class="submit" id="scheduled-submit">Submit</button>
        <button class="submit" id="scheduled-submit" v-on:click.prevent="resetScheduledForm" type="cancel">Cancel</button>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
import CourseService from '../services/CourseService.js';
import matchService from '../services/MatchService.js'
export default {
  name: "create-match",
  data() {
    return {
      showInstant: false,
      showScheduled: false,
      match: {
        
        courseId: "",
        startDateTime: "",
        numberOfPlayers: ""
      },
      courses: []
    };
  },
  methods: {   
      addNewScheduledMatch(){
          matchService.createMatch(this.match).then((response) =>{
            if(response === 201){
              this.match = {
                
                courseId: "",
                startDateTime: "",
                numberOfPlayers: ""
              };
              this.$router.push('/matches')
            }
          });
          this.resetScheduledForm();
      },
      resetScheduledForm(){
          this.showScheduled = false;
          this.newMatch = {};
      },
      listCourses(){
        CourseService.list().then((response) =>{
          this.courses = response.data;
        });
      }
  },
  created(){
    this.listCourses();
  }
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
  overflow-y: scroll;
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

div.scheduled-element{
  margin-bottom: 15px;
}

input {
  display: block;
  border: none;
  text-align: center;
  width: auto;
}

h2{
  text-align: center;
  margin-bottom: 10px;
}

.scheduled-match {
  display: inline-block;
  border: black solid 2px;
  box-shadow: 0 0 20px rgb(0 0 0 / 15%);
  border-radius: 5px;
  margin: auto;
  height: 260px;
  width: 300px;
  padding: 15px;
  text-align: center;
}

div.button-holder > button{
  margin: 10px;
  height: 30px;
  width: 60px;
  font-weight: bold;
}

div.button-holder{
  text-align: center;
  
}

#date{
 margin-left: 40px;
}

.create-scheduled {
  display: inline-block;
  margin: auto;
  font-weight: bold;
  height: 30px;
  width: 200px;
}
</style>