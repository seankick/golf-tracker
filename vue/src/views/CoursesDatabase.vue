<template>
  <div class="app">
      <aside class="sidebar">
      <h3>Menu</h3>
      <nav class="menu">
              <router-link  class="menu-item" :to="{name: 'home'}">Home</router-link>
            <router-link  class="menu-item" :to="{name: 'findCourses'}">Find Courses</router-link>
            <router-link class="menu-item is-active" :to="{name: 'coursesDatabase' }">Course Database</router-link>
            <router-link class="menu-item" :to="{name: 'addScorecard'}"> Make A Scorecard</router-link>
             <router-link class="menu-item" :to="{name: 'createMatch'}"> Create A Match</router-link>
             <router-link class="menu-item" :to="{ name: 'leagueList' }">Leagues</router-link>
             
            <router-link class="menu-item" :to="{name: 'about' }">About</router-link>
            <a class="menu-item" href="">Sign out</a>
      </nav>
    </aside>
    
    <course-list />
    
  </div>
</template>

<script>
import CourseList from '@/components/CourseDisplayComponents/CourseList.vue';

export default {
  name: 'CoursesDatabase',
  components: {
    CourseList
  }
}
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

div.h1{
  text-align: center;
  margin-left: auto;
  margin-right: auto;
}




</style>