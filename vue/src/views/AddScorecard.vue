<template>
  <div class="app">
    <aside class="sidebar">
      <h3>Menu</h3>
      <nav class="menu">
          <router-link  class="menu-item" :to="{name: 'home'}">Home</router-link>
            <router-link  class="menu-item" :to="{name: 'findCourses'}">Find Courses</router-link>
            <router-link class="menu-item" :to="{name: 'coursesDatabase' }">Course Database</router-link>
            <router-link class="menu-item is-active" :to="{name: 'addScorecard'}"> Make A Scorecard</router-link>
             <router-link class="menu-item" :to="{name: 'createMatch'}"> Create A Match</router-link>
             <router-link class="menu-item" :to="{ name: 'leagueList' }">Leagues</router-link>
             <router-link class="menu-item" :to="{ name: 'inputLeagueRounds' }">Input League Rounds</router-link>
            <router-link class="menu-item" :to="{name: 'about' }">About</router-link>
            <a class="menu-item" href="">Sign out</a>
      </nav>
    </aside>
    <main class="content">
		<h1>Scorecard</h1>
      <table class="scorecard">
        <thead>
          <tr class="hole">
            <th>Hole</th>
            <th>1</th>
            <th>2</th>
            <th>3</th>
            <th>4</th>
            <th>5</th>
            <th>6</th>
            <th>7</th>
            <th>8</th>
            <th>9</th>
            <th class="text-uppercase out">Out</th>
            <th>10</th>
            <th>11</th>
            <th>12</th>
            <th>13</th>
            <th>14</th>
            <th>15</th>
            <th>16</th>
            <th>17</th>
            <th>18</th>
            <th class="text-uppercase in">In</th>
            <th class="text-uppercase total">Total</th>
          </tr>
        </thead>
        <tbody>
          <tr class="white-tee">
            <td><strong>White Tee</strong></td>
            <td>480</td>
            <td>150</td>
            <td>359</td>
            <td>320</td>
            <td>348</td>
            <td>380</td>
            <td>337</td>
            <td>187</td>
            <td>323</td>
            <td>2,884</td>
            <td>337</td>
            <td>291</td>
            <td>166</td>
            <td>309</td>
            <td>136</td>
            <td>518</td>
            <td>348</td>
            <td>383</td>
            <td>459</td>
            <td>3,147</td>
            <td>6,031</td>
          </tr>
          <tr class="men-hand">
            <td><strong>Men's Handicap</strong></td>
            <td>6</td>
            <td>18</td>
            <td>12</td>
            <td>16</td>
            <td>14</td>
            <td>4</td>
            <td>2</td>
            <td>10</td>
            <td>8</td>
            <td></td>
            <td>11</td>
            <td>7</td>
            <td>13</td>
            <td>3</td>
            <td>17</td>
            <td>9</td>
            <td>5</td>
            <td>1</td>
            <td>15</td>
            <td></td>
            <td></td>
          </tr>
          <tr class="men-par">
            <td><strong>Men's Par</strong></td>
            <td>5</td>
            <td>3</td>
            <td>4</td>
            <td>4</td>
            <td>4</td>
            <td>4</td>
            <td>4</td>
            <td>3</td>
            <td>4</td>
            <td>35</td>
            <td>4</td>
            <td>4</td>
            <td>3</td>
            <td>4</td>
            <td>3</td>
            <td>5</td>
            <td>4</td>
            <td>4</td>
            <td>5</td>
            <td>36</td>
            <td>71</td>
          </tr>

          <tr class="score">
            <td><strong>Player 1</strong></td>
            <td><input id="1" type="number" min="1" /></td>
            <td><input id="2" type="number" min="1" /></td>
            <td><input id="3" type="number" min="1" /></td>
            <td><input id="4" type="number" min="1" /></td>
            <td><input id="5" type="number" min="1" /></td>
            <td><input id="6" type="number" min="1" /></td>
            <td><input id="7" type="number" min="1" /></td>
            <td><input id="8" type="number" min="1" /></td>
            <td><input id="9" type="number" min="1" /></td>
            <td id="out-total"></td>
            <td><input id="11" type="number" min="1" /></td>
            <td><input id="12" type="number" min="1" /></td>
            <td><input id="13" type="number" min="1" /></td>
            <td><input id="14" type="number" min="1" /></td>
            <td><input id="15" type="number" min="1" /></td>
            <td><input id="16" type="number" min="1" /></td>
            <td><input id="17" type="number" min="1" /></td>
            <td><input id="18" type="number" min="1" /></td>
            <td><input id="19" type="number" min="1" /></td>
            <td id="in-total"></td>
            <td id="total-total"></td>
          </tr>
          <tr id="par" class="women-par">
            <td><strong>Women's Par</strong></td>
            <td>5</td>
            <td>3</td>
            <td>4</td>
            <td>4</td>
            <td>4</td>
            <td>4</td>
            <td>4</td>
            <td>3</td>
            <td>4</td>
            <td>35</td>
            <td>4</td>
            <td>4</td>
            <td>3</td>
            <td>5</td>
            <td>3</td>
            <td>5</td>
            <td>4</td>
            <td>5</td>
            <td>5</td>
            <td>38</td>
            <td>73</td>
          </tr>
          <tr class="women-hand">
            <td><strong>Women's Handicap</strong></td>
            <td>3</td>
            <td>17</td>
            <td>11</td>
            <td>15</td>
            <td>5</td>
            <td>7</td>
            <td>1</td>
            <td>13</td>
            <td>9</td>
            <td></td>
            <td>12</td>
            <td>6</td>
            <td>14</td>
            <td>16</td>
            <td>18</td>
            <td>2</td>
            <td>4</td>
            <td>8</td>
            <td>10</td>
            <td></td>
            <td></td>
          </tr>
        </tbody>
      </table>
      <div class="btn-group">
        <button class="btn btn-warning" @click.once="button0Click()">
          OUT
        </button>
        <button class="btn btn-warning" @click.once="button1Click()">IN</button>
        <button class="btn btn-warning" @click.once="button2Click()">
          TOTAL
        </button>
      </div>
    </main>
  </div>
</template>

<script>
export default {
  //     //function myFunc(variable){
  //   var s= document.getElementById(variable);
  //   s.value = 'New value'
  //document.getElementByid('1').value

  // }

  methods: {
    button0Click() {
      var total = 0;
      var data = document.getElementById("1").value;
      var data2 = document.getElementById("2").value;
      var data3 = document.getElementById("3").value;
      var data4 = document.getElementById("4").value;
      var data5 = document.getElementById("5").value;
      var data6 = document.getElementById("6").value;
      var data7 = document.getElementById("7").value;
      var data8 = document.getElementById("8").value;
      var data9 = document.getElementById("9").value;

      total =
        parseInt(data) +
        parseInt(data2) +
        parseInt(data3) +
        parseInt(data4) +
        parseInt(data5) +
        parseInt(data6) +
        parseInt(data7) +
        parseInt(data8) +
        parseInt(data9);
      let x = document.getElementById("out-total");
      x.value = total.toString();
      let text = document.createTextNode(total.toString());
      x.appendChild(text);
    },
    button1Click() {
      var total = 0;
      var data11 = document.getElementById("11").value;
      var data12 = document.getElementById("12").value;
      var data13 = document.getElementById("13").value;
      var data14 = document.getElementById("14").value;
      var data15 = document.getElementById("15").value;
      var data16 = document.getElementById("16").value;
      var data17 = document.getElementById("17").value;
      var data18 = document.getElementById("18").value;
      var data19 = document.getElementById("19").value;

      total =
        parseInt(data11) +
        parseInt(data12) +
        parseInt(data13) +
        parseInt(data14) +
        parseInt(data15) +
        parseInt(data16) +
        parseInt(data17) +
        parseInt(data18) +
        parseInt(data19);
      let x = document.getElementById("in-total");
      x.value = total.toString();
      let text = document.createTextNode(total.toString());
      x.appendChild(text);
    },
    button2Click() {
      var total = 0;
      var OUT = document.getElementById("out-total").value;
      var IN = document.getElementById("in-total").value;
      total = parseInt(OUT) + parseInt(IN);
      let x = document.getElementById("total-total");
      let text = document.createTextNode(total.toString());
      x.appendChild(text);
    },
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

.app {
  display: flex;
  min-height: 100vh;
}

.sidebar {
	display: inline-block;
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

/* body {
  background-color: white;
} */

.container {
  margin-left: auto;
  margin-right: auto;
}

.scorecard {
  overflow: hidden;
  margin-left: auto;
  margin-right: auto;
  border: black solid 2px;
  border-radius: 20px;
  border-collapse: collapse;
  text-align: center;
  vertical-align: middle;
  width: auto;
  height: 200px;
  font-weight: bold;
}

th {
  border: black solid 2px;
  padding: 5px;
}

td {
  border: black solid 2px;

  text-align: center;
  height: 15px;
  width: 15px;
  padding: 7px;
}

td > input {
  border: none;
  text-align: center;
  width: 50px;
}

.hole {
  background-color: #03844c;
}

.white-tee {
  background-color: #7cb320;
}

.men-hand {
  background-color: #fff0cc;
}

.men-par {
  background-color: black;
  color: white;
}

.women-hand {
  background-color: #cfaf65;
}

.women-par {
  background-color: black;
  color: white;
}

.btn {
  margin: 10px 5px;
  align-self: center;
  background-color: #7cb320;
  color: #fff;
  border: none;
  height: 25px;
  width: 70px;
  border-radius: 5px;
  font-weight: bolder;
}

.btn:hover {
  background-color: #03844c;
  color: #fff0cc;
}

.over-par {
  color: red;
}

.under-par {
  color: blue;
}

.player {
  border: none;
}
</style>