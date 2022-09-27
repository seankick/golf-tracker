<template>
  <div class="course-list">

    <table class="league-scorecards-table">
      <thead>
        <tr>
          <th></th>
          <th>Round Date</th>
          <th>Tee Selection</th>
          <th>Hole 1</th>
          <th>Hole 2</th>
          <th>Hole 3</th>
          <th>Hole 5</th>
          <th>Hole 6</th>
          <th>Hole 7</th>
          <th>Hole 8</th>
          <th>Hole 9</th>
          <th>Hole 10</th>
          <th>Hole 11</th>
          <th>Hole 12</th>
          <th>Hole 13</th>
          <th>Hole 14</th>
          <th>Hole 15</th>
          <th>Hole 16</th>
          <th>Hole 17</th>
          <th>Hole 18</th>
          <th>Total Strokes</th>
          <th>Par</th>
          <th>Score</th>
        </tr>
      </thead>
      <tbody>
        <tr
          v-for="leagueScorecard in $store.state.leagueScorecards"
          v-bind:key="leagueScorecard.leagueScorecardId"
        >
          <td width="80%">
            {{ leagueScorecard.username }}
          </td>
          <td width="80%">
            {{ leagueScorecard.matchDate }}
          </td>
          <td width="80%">
            {{ leagueScorecard.teeSelection }}
          </td>
          <td width="80%">
            {{ leagueScorecard.hole1Score }}
          </td>
          <td width="80%">
            {{ leagueScorecard.hole2Score }}
          </td>
          <td width="80%">
            {{ leagueScorecard.hole3Score }}
          </td>
          <td width="80%">
            {{ leagueScorecard.hole4Score }}
          </td>
          <td width="80%">
            {{ leagueScorecard.hole5Score }}
          </td>
          <td width="80%">
            {{ leagueScorecard.hole6Score }}
          </td>
          <td width="80%">
            {{ leagueScorecard.hole7Score }}
          </td>
          <td width="80%">
            {{ leagueScorecard.hole8Score }}
          </td>
          <td width="80%">
            {{ leagueScorecard.hole9Score }}
          </td>
          <td width="80%">
            {{ leagueScorecard.hole10Score }}
          </td>
          <td width="80%">
            {{ leagueScorecard.hole11Score }}
          </td>
          <td width="80%">
            {{ leagueScorecard.hole12Score }}
          </td>
          <td width="80%">
            {{ leagueScorecard.hole13Score }}
          </td>
          <td width="80%">
            {{ leagueScorecard.hole14Score }}
          </td>
          <td width="80%">
            {{ leagueScorecard.hole16Score }}
          </td>
          <td width="80%">
            {{ leagueScorecard.hole17Score }}
          </td>
          <td width="80%">
            {{ leagueScorecard.hole18Score }}
          </td>
          <td width="80%">
            {{ leagueScorecard.totalStrokes }}
          </td>
          <td width="80%">
            {{ leagueScorecard.totalCoursePar }}
          </td>
          <td width="80%">
            {{ leagueScorecard.roundScoreRelativeToPar }}
          </td>
        </tr>
      </tbody>
    </table>

    

  </div>
</template>

<script>
import leagueScorecardService from "@/services/LeagueScorecardService.js";

export default {
  name: "league-scorecard-list",
  props: ['leagueId'],
  methods: {

    getLeagueScorecards(leagueId) {
      leagueScorecardService.get(leagueId).then((response) => {
        this.$store.commit("SET_LEAGUE_SCORECARDS", response.data);
      });
    },
  },
  created() {
    this.getLeagueScorecards(this.leagueId);
  
    }
  
};
</script>

<style>
.edit-league-scorecard {
  text-decoration: none;
}

.delete-button {
  text-decoration: none;
  color: red
}

.league-scorecards-table {
  border-collapse: collapse;
  margin: 25px;
  font-size: 0.9em;
  min-width: 600px;
  border-radius: 5px 5px 0 0;
  overflow: hidden;
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
}

.league-scorecards-table thead tr {
  background-color: #2e3047;
  color: white;
  text-align: left;
  font-weight: bold;
}

.league-scorecards-table th,
.league-scorecards-table td {
  padding: 12px 15px;
  border: none;
}

.league-scorecards-table td:last-child {
  text-align: center;
}

.league-scorecards-table tbody tr {
  border-bottom: 1px solid #2e3047;
  color: black;
}

.league-scorecards-table tbody tr:nth-of-type(even) {
  background-color: #f3f3f3;
}

.league-scorecards-table tbody tr:last-of-type {
  border-bottom: 2px solid #2e3047;
}

.addLeagueScorecard {
margin-left: 480px;
padding: 10px;
border: 1px solid black;
border-radius: 7px;
text-decoration: none;
background-color: lightgray;
color: black;
}

</style>