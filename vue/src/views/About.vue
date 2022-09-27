<template>
  <div class="app">
    <aside class="sidebar">
      <h3>Menu</h3>
      <nav class="menu">
        <router-link  class="menu-item" :to="{name: 'home'}">Home</router-link>
            <router-link  class="menu-item" :to="{name: 'findCourses'}">Find Courses</router-link>
            <router-link class="menu-item" :to="{name: 'coursesDatabase' }">Course Database</router-link>
            <router-link class="menu-item" :to="{name: 'addScorecard'}"> Make A Scorecard</router-link>
             <router-link class="menu-item" :to="{name: 'createMatch'}"> Create A Match</router-link>
             <router-link class="menu-item" :to="{ name: 'leagueList' }">Leagues</router-link>
            <router-link class="menu-item is-active" :to="{name: 'about' }">About</router-link>
            <a class="menu-item" href="">Sign out</a>
      </nav>
    </aside>
    <div class="content">
      <div class="content-about">
        <h1>Club House</h1>
        <h2>Golf Tracking Software</h2>
        <div class="image">
          <img src="../image/clubhouse.jpg" alt="Clubhouse" />
        </div>
        <p>
          Clubhouse is a software that aids golfers in finding nearby courses,
          tracking their performance, finding leagues, and much more!
        </p>

        <div>

          <!-- <league-scorecard-list v-bind:leagueId="parseInt($route.params.leagueId)" />  -->

        </div>
      </div>
    </div>
  </div>
</template>

<script>
// import LeagueScorecardList from '../components/LeagueScorecardList.vue';
export default {
  // components: { LeagueScorecardList },
  name: "about",
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

.content h1 {
  color: #3c3f56;
  font-size: 2.5rem;
  margin-bottom: 1rem;
}

.content p {
  color: #707793;
}

.content h2 {
  color: #3c3f56;
  font-size: 1.3rem;
  margin-left: 25px;
  margin-top: 25px;
}

img {
    max-height: 300px;
    max-width: 300px;
}
</style>
