<template>
   <div class="app">
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
        <img src="../image/clubhouse.jpg" alt="">
        
        <h1>Upcoming Tee-Times</h1>
        <table class="upcoming-table">
            <thead>
                <th class="match-header">Course Name</th>
                <th class="match-header">Date</th>
                <th class="match-header">Players</th>
                <!-- <th>Invite Players</th> -->
            </thead>
            <tbody>
                <tr v-for="match in matches" :key="match.matchId">

                   <td>{{ match.courseName }}</td>
                   <!-- <td>{{ match.startDateTime| dateParse('MM-DD-YYYY') }}</td> -->
                   <td>{{format_date(match.startDateTime)}}</td>
                   <td>{{ match.numberOfPlayers }}</td>
                   
                   <!-- <td><router-link class="invite-button" :to="{name: 'addFriendToMatch', params: { id: match.matchId} }">Invite Players</router-link></td> -->
                </tr>
               
            </tbody>
        </table>
    </main>

   </div>
</template>

<script>
import moment from 'moment';
import MatchService from '../services/MatchService.js'


export default {

  name: "home",
  data(){
   return{
       matches: [],
   }
  },
  created() {
     MatchService.listMatches().then(response => {
        this.matches = response.data;
     })
  },
  methods: {
       format_date(value){
         if (value) {
           return moment(String(value)).format('MM-DD-YYYY HH:mm:ss')
          }
      }
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
    background:  white;
}

.content h1 {
    color: #3C3F56;
    font-size: 2.5rem;
    margin-bottom: 1rem;
}

.content p {
    color: #707793;
}

.content h2 {
    color: #3C3F56;
    font-size: 1.3rem;
    margin-left: 25px;
    margin-top: 25px;
}

table.upcoming-table {
    border-collapse: collapse;
    margin: 25px;
    font-size: 0.9em;
    min-width: 600px;
    border-radius: 5px 5px 0 0;
    overflow: hidden;
    box-shadow: 0 0 20px rgb(0 0 0 / 15%);
    margin-left: auto;
    margin-right: auto;
}

.upcoming-table thead tr {
    background-color: #2e3047;
    color: white;
    text-align: left;
    font-weight: bold;
}

.upcoming-table th,
.upcoming-table td {
    padding: 12px 15px;
}

.upcoming-table td:last-child {
    text-align: center;
}

.upcoming-table tbody tr {
    border-bottom: 1px solid #2e3047;
}

.upcoming-table tbody tr:nth-of-type(even) {
    background-color: #f3f3f3;
}

.upcoming-table tbody tr:last-of-type {
    border-bottom: 2px solid #2e3047;
}

.invite-button {
    text-decoration: none;
    background:#707793;
    padding: 5px;
    border-radius: 5px;
    color: aliceblue;
}

.match-header{
    background-color: #2e3047;
    color: white;
    font-weight: bold;
    font-size: 17px;
}
</style>
