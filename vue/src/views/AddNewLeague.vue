<template>
  <div>
    
      <create-League/>
  </div>
</template>

<script>
import CreateLeague from '@/components/CreateLeague.vue'

export default {
    name: 'addNewLeague',
    components: {
        CreateLeague
    }
        
    
}
</script>

<style>

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
</style>