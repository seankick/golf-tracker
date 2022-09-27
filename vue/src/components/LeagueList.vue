<template>
  <div class="course-list">

    <router-link :to="{name: 'addNewLeague'}" tag="button" class="create">Add League</router-link>


    <table class="courses-table">
      <thead>
        <tr>
          <th colspan="2">Leagues</th>
          
        </tr>
      </thead>
      <tbody>
        <tr
          v-for="league in this.$store.state.leagues"
          v-bind:key="league.leagueId"
        >
          <td width="80%">
            <router-link
              v-bind:to="{ name: 'leagueDetails', params: { leagueId: league.leagueId } }"
              >{{ league.leagueName }}</router-link
            >
          </td>

          
          
          
        </tr>
      </tbody>
    </table>

    

  </div>
</template>

<script>
import leagueService from "@/services/LeagueService.js";

export default {
  name: "league-list",
  methods: {

    getLeagues() {
      leagueService.list().then((response) => {
        this.$store.commit("SET_LEAGUES", response.data);
      });
    },
  },
  created() {
    this.getLeagues();
  },
};
</script>

<style>
.edit-course {
  text-decoration: none;
}

.delete-button {
  text-decoration: none;
  color: red
}

.courses-table {
  border-collapse: collapse;
  margin-left: 500px;
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
  text-align: center;
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

.addLeague {
margin-left: 510px;
padding: 10px;
border: 1px solid black;
border-radius: 7px;
text-decoration: none;
background-color: lightgray;
color: black;
}

th{
  font-size: 20px;
}

.create{
  height: 40px;
  width: 100px;
  margin-left: 750px;
  margin-bottom: 20px;
  border-radius: 5px;
  font-weight: bold;
}

</style>