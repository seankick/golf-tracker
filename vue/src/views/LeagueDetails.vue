<template>
    <div class="app">
    <aside class="sidebar">
      <h3>Menu</h3>
      <nav class="menu">
        <router-link class="menu-item" :to="{ name: 'home' }">Home</router-link>
        <router-link class="menu-item" :to="{ name: 'findCourses' }">Find Courses</router-link>
        <router-link class="menu-item" :to="{ name: 'coursesDatabase' }">Course Database</router-link>
        <router-link class="menu-item" :to="{ name: 'addScorecard' }">Make A Scorecard</router-link>
        <router-link class="menu-item" :to="{ name: 'createMatch' }"> Create A Match</router-link>
        <router-link class="menu-item is-active" :to="{ name: 'leagueList' }">Leagues</router-link>
        
        <router-link class="menu-item" :to="{ name: 'about' }"
          >About</router-link
        >
        <a class="menu-item" href="">Sign out</a>
      </nav>
    </aside>


  <div class="league-details">
      <h1>{{league.leagueName}}</h1>
      
      <p>Start Date: {{league.startDate}}</p>
      <p>End Date: {{league.endDate}}</p>
      <p>{{league.overview}}</p>
   
      <league-scorecard-list v-bind:leagueId="parseInt(this.$route.params.leagueId)" />
  
      <input-league-rounds v-bind:leagueId="parseInt(this.$route.params.leagueId)"/>
  </div>

        

  </div>
</template>

<script>
import LeagueService from '@/services/LeagueService.js';
import LeagueScorecardList from "../components/LeagueScorecardList.vue";
import InputLeagueRounds from "../components/InputLeagueRounds.vue"


export default {
    name: 'leagueDetails',
    components: {
        LeagueScorecardList,
        InputLeagueRounds
    },
    data() {
        return {
            league: {}
        }
    },
    created() {
        LeagueService.get(this.$route.params.leagueId)
            .then((response) => {
                this.league = response.data;
            })
    }
}
</script>

<style>
.league-details {
    text-align: center;
    align-items: center;
    
}

.app {
    flex: 1 1;
}

</style>