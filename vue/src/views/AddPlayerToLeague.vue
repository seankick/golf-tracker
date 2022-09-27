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
             <router-link class="menu-item" :to="{ name: 'inputLeagueRounds' }">Input League Rounds</router-link>
            <router-link class="menu-item" :to="{name: 'about' }">About</router-link>
            <a class="menu-item" href="">Sign out</a>
        </nav>
    </aside>

    <main class="content">
        <h1>Invite Friends</h1>
        <h2>Friends</h2>
        <table class="friends-table">
            <thead>
                <th>User</th>
                <th></th>
            </thead>
            <tbody>
                <tr>
                    <td>John Deer</td>
                    <td><button class="invite-button">Invite</button></td>
                </tr>
                <tr>
                    <td>Busch Light</td>
                    <td><button class="invite-button">Invite</button></td>
                </tr>
                <tr>
                    <td>Joe</td>
                    <td><button class="invite-button">Invite</button></td>
                </tr>
            </tbody>
        </table>
    </main>

   </div>
</template>

<script>
export default {
    name: "addPlayerToLeague"
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

.friends-table {
    border-collapse: collapse;
    margin: 25px;
    font-size: 0.9em;
    min-width: 600px;
    border-radius: 5px 5px 0 0;
    overflow: hidden;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
}

.friends-table th {
    text-align: left;
}

.friends-table thead tr {
    background-color: #2e3047;
    color: white;
    text-align: left;
    font-weight: bold;
}

.friends-table th,
.friends-table td {
    padding: 12px 15px;
}

.friends-table tbody tr {
    border-bottom: 1px solid #2e3047;
}

.friends-table tbody tr:nth-of-type(even) {
    background-color: #f3f3f3;
}

.friends-table tbody td:nth-of-type(even) {
    text-align: right;
}

.friends-table tbody tr:last-of-type {
    border-bottom: 2px solid #2e3047;
}

.invite-button {
    text-decoration: none;
    background:#707793;
    padding: 5px;
    border-radius: 5px;
    color: aliceblue;
}
</style>
