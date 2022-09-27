<template>
<div class="app">
  <aside class="sidebar">
      <h3>Menu</h3>
      <nav class="menu">
        <router-link class="menu-item" :to="{ name: 'home' }">Home</router-link>
        <router-link class="menu-item is-active" :to="{ name: 'findCourses' }">Find Courses</router-link>
        <router-link class="menu-item" :to="{name: 'coursesDatabase' }">Course Database</router-link>
       <router-link class="menu-item" :to="{name: 'addScorecard'}"> Make A Scorecard</router-link>
       <router-link class="menu-item" :to="{name: 'createMatch'}"> Create A Match</router-link>
       <router-link class="menu-item" :to="{ name: 'createLeague' }">Create A League</router-link>
          <router-link class="menu-item" :to="{name: 'about' }">About</router-link>
        <a class="menu-item" href="">Sign out</a>
      </nav>
    </aside>
  <div class="content">
    <h1>{{course.name}}</h1>
    <div class="rating">
      <h2>Rating: {{courseDetails.rating}}/5</h2>
    </div>
    <div class="address">
      <p>Address: {{courseDetails.formatted_address}}</p>
    </div>
    <div class="phone-number">
      <p>{{courseDetails.formatted_phone_number}}</p>
    </div>
    <p>{{courseDetails.website}}</p>
  </div>
  </div>
</template>


// "formatted_address":"1700 17 Mile Dr, Pebble Beach, CA 93953, USA"
// "formatted_phone_number":"(831) 574-5609"
// "name":"Pebble Beach Golf Links"
// "photos":[...]10 items
// "rating":4.8
// "url":"https://maps.google.com/?cid=15094594552774239886"
// "website":"http://www.pebblebeach.com/golf/pebble-beach-golf-links"

<script>
import axios from "axios";
export default {
  name: "findCourseDetail",
  data() {
    return {
      courseDetails: {},
    };
  },
  computed: {
    course() {
      return this.$store.state.localCourses.find((course) => {
        return course.name == this.$route.params.name;
      });
    },
  },
  created() {
    const options = {
      method: "GET",
      url: "https://golf-course-finder.p.rapidapi.com/course/details",
      params: { zip: this.course.zip_code, name: this.course.name },
      headers: {
        "X-RapidAPI-Key": "d7fa473405mshe26ceedfc737f39p178842jsnb1502ec47367",
        "X-RapidAPI-Host": "golf-course-finder.p.rapidapi.com",
      },
    };

    axios
      .request(options)
      .then((response) => {
        console.log(response.data);
        this.courseDetails = response.data.course_details.result;
      })
      .catch(error => {
        console.error(error);
      });
  },
};
</script>

<style>
body {
  background-color: white;
  align-content: center;
  align-items: center;
}

h2 {
  font-size: 1.2rem;
}
</style>