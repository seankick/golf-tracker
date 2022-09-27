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

    <main class="content">
      <div class="coords-display"></div>

      <h1>Find Golf Courses Nearby</h1>

      <GmapMap
        :center="{ lat: coordinates.lat, lng: coordinates.lng }"
        :zoom="10"
        map-type-id="terrain"
        style="
          width: 70%;
          height: 400px;
          margin: 1rem 15rem;
          align-items: center;
        "
      >
        <!-- <gmap-marker
            :position="{lat:10, lng:10}"
            :clickable="true"
            :draggable="false"
        > -->
      </GmapMap>

      <p>Distance</p>
      <label class="custom-selector">
        <select v-model="radius">
          <option value="10">10 Miles</option>
          <option value="15">15 Miles</option>
          <option value="20">20 Miles</option>
          <option value="25">25 Miles</option>
        </select>
      </label>

      <button class="search-button" @click="findCloseBy">
        Search for courses
      </button>

      <div
        class="course-lists"
        v-for="course in this.golfCourses"
        v-bind:key="course.name"
      >
        <router-link v-bind:to="{name: 'findCourseDetail', params: {name: course.name} }">
          <div class="course-buttons">
            <div class="course-header">{{ course.name }}</div>
            <div class="course-zip">{{ course.zip_code }}</div>
            <div class="distance">{{ course.distance }} miles away</div>
          </div>
        </router-link>
      </div>
    </main>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "findCourses",

  data() {
    return {
      golfCourses: [],
      radius: "15",
      coordinates: {
        lat: 0,
        lng: 0,
      },
    };
  },
  methods: {
    SET_COURSES(state, data) {
      state.courses = data;
    },

    findCloseBy() {
      const options = {
        method: "GET",
        url: "https://golf-course-finder.p.rapidapi.com/courses",
        params: {
          radius: this.radius,
          lat: this.coordinates.lat,
          lng: this.coordinates.lng,
        },
        headers: {
          "X-RapidAPI-Key":
            "d7fa473405mshe26ceedfc737f39p178842jsnb1502ec47367",
          "X-RapidAPI-Host": "golf-course-finder.p.rapidapi.com",
        },
      };
      axios
        .request(options)
        .then((response) => {
          console.log(response.data);
          this.$store.commit('SET_LOCAL_COURSES', response.data.courses)
          this.golfCourses = response.data.courses
        })
        .catch((error) => {
          console.error(error);
        });
    },
  },
  created() {
    //get users coordinates from browser request
    this.$getLocation({})
      .then((coordinates) => {
        this.coordinates = coordinates;
      })
      .catch((error) => alert(error));
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

.course-lists {
  
  margin: 20px auto;
  width: 700px;
  height: 100px;
  border-bottom: solid #707793 1px;
  color: white;
  border-radius: 10px;
  padding: 5px auto;
}
.course-buttons h1 {
  text-align: center;
  padding: 20px auto;
  font-size: 4rem;
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

/* .custom-selector {
  position: relative;
  display: inline-block;
  font-size: 14px;
  
}

.custom-selector select {
  width: 200px;
  min-height: 35px;
  background: #707793;
  border-radius: 3px;
  border: 2px solid black;
  outline: none;
  padding: 0 10px;
  width: 100%;
  cursor: pointer;
  margin-top: 5px;
  color: white;
  appearance: none;
}

.custom-selector::after {

} */
</style>
