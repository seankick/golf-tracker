<template>
  <div class="app">
    <!-- <aside class="sidebar">
      <h3>Menu</h3>
      <nav class="menu">
      <router-link  class="menu-item" :to="{name: 'home'}">Home</router-link>
            <router-link  class="menu-item" :to="{name: 'findCourses'}">Find Courses</router-link>
            <router-link class="menu-item" :to="{name: 'coursesDatabase' }">Course Database</router-link>
            <router-link class="menu-item" :to="{name: 'addScorecard'}"> Make A Scorecard</router-link>
             <router-link class="menu-item" :to="{name: 'createMatch'}"> Create A Match</router-link>
             <router-link class="menu-item" :to="{ name: 'leagueList' }">Leagues</router-link>
            <router-link class="menu-item" :to="{name: 'about' }">About</router-link>
            <a class="menu-item" href="">Sign out</a>
      </nav>
    </aside> -->

    <div class = "league-round-input">
      <h2>Input League Scorecard:</h2>
      <FormulateForm @submit="saveLeagueScorecard">

        <FormulateInput
          v-model="leagueScorecard.leagueId"
          name="league-id"
          type="text"
          label="League Id"
          validation="required"
          
        />

        <FormulateInput
          v-model="leagueScorecard.courseName"
          name="course-name"
          type="select"
          label="Course Name"
          validation="required"
          :options="courses.map(c => c.courseName)"
        />

         <FormulateInput
          name="match-date"
          type="date"
          label="Match Date"
          validation= "required"
          v-model="leagueScorecard.matchDate"
          min="2022-08-01"
          max= "2100-08-01"
          error-behavior="live"
          />

        <FormulateInput
          type="text"
          name="username"
          label="Username"
          validation="required"
          v-model="leagueScorecard.username"
        />
        <FormulateInput
          type="select"
          name="tee-selection"
          label="Tee Selection"
          validation="required"
          :options="[
            'Red',
            'Gold',
            'White',
            'Black',
            'Blue',
            'Green',
            'Silver',
          ]"
          v-model="leagueScorecard.teeSelection"
        />
        <FormulateInput
          name="hole-1-score"
          type="text"
          label="Score for Hole 1"
          validation="required"
          v-model="leagueScorecard.hole1Score"
        />
        <FormulateInput
          name="hole-2-score"
          type="text"
          label="Score for Hole 2"
          validation="required"
          v-model="leagueScorecard.hole2Score"
        />
        <FormulateInput
          name="hole-3-score"
          type="text"
          label="Score for Hole 3"
          validation="required"
          v-model="leagueScorecard.hole3Score"
        />
        <FormulateInput
          name="hole-4-score"
          type="text"
          label="Score for Hole 4"
          validation="required"
          v-model="leagueScorecard.hole4Score"
        />
        <FormulateInput
          name="hole-5-score"
          type="text"
          label="Score for Hole 5"
          validation="required"
          v-model="leagueScorecard.hole5Score"
        />
        <FormulateInput
          name="hole-6-score"
          type="text"
          label="Score for Hole 6"
          validation="required"
          v-model="leagueScorecard.hole6Score"
        />
        <FormulateInput
          name="hole-7-score"
          type="text"
          label="Score for Hole 7"
          validation="required"
          v-model="leagueScorecard.hole7Score"
        />
        <FormulateInput
          name="hole-8-score"
          type="text"
          label="Score for Hole 8"
          validation="required"
          v-model="leagueScorecard.hole8Score"
        />
        <FormulateInput
          name="hole-9-score"
          type="text"
          label="Score for Hole 9"
          validation="required"
          v-model="leagueScorecard.hole9Score"
        />
        <FormulateInput
          name="hole-10-score"
          type="text"
          label="Score for Hole 10"
          validation="required"
          v-model="leagueScorecard.hole10Score"
        />
        <FormulateInput
          name="hole-11-score"
          type="text"
          label="Score for Hole 11"
          validation="required"
          v-model="leagueScorecard.hole11Score"
        />
        <FormulateInput
          name="hole-12-score"
          type="text"
          label="Score for Hole 12"
          validation="required"
          v-model="leagueScorecard.hole12Score"
        />
        <FormulateInput
          name="hole-13-score"
          type="text"
          label="Score for Hole 13"
          validation="required"
          v-model="leagueScorecard.hole13Score"
        />
        <FormulateInput
          name="hole-14-score"
          type="text"
          label="Score for Hole 14"
          validation="required"
          v-model="leagueScorecard.hole14Score"
        />
        <FormulateInput
          name="hole-15-score"
          type="text"
          label="Score for Hole 15"
          validation="required"
          v-model="leagueScorecard.hole15Score"
        />
        <FormulateInput
          name="hole-16-score"
          type="text"
          label="Score for Hole 16"
          validation="required"
          v-model="leagueScorecard.hole16Score"
        />
        <FormulateInput
          name="hole-17-score"
          type="text"
          label="Score for Hole 17"
          validation="required"
          v-model="leagueScorecard.hole17Score"
        />
        <FormulateInput
          name="hole-18-score"
          type="text"
          label="Score for Hole 18"
          validation="required"
          v-model="leagueScorecard.hole18Score"
        />
        <FormulateInput
          name="total-strokes"
          type="text"
          label="Total Strokes"
          validation="required"
          v-model="leagueScorecard.totalStrokes"
        />
        <FormulateInput
          name="total-course-par"
          type="text"
          label="Total Course Par"
          validation="required"
          v-model="leagueScorecard.totalCoursePar"
        />

        <FormulateInput
          name="Round Score Relative to Par"
          type="text"
          label="Round Score Relative to Par"
          validation="required"
          v-model="leagueScorecard.roundScoreRelativeToPar"
        />

        <FormulateInput
          type="submit"
          label="Input League Round"
        />
      </FormulateForm>
    </div>
  </div>
</template>

<script>
import moment from 'moment'
import CourseService from '../services/CourseService';
import leagueScorecardService from "../services/LeagueScorecardService";

export default {
  name: "InputLeagueRounds",
  props: ['leagueId'],


  data() {
    return {
      leagueScorecard: {
        leagueScorecardId: "",
        leagueId: "",
        courseName: "",
        matchDate: "",
        username: "",
        teeSelection: "",
        hole1Score: "",
        hole2Score: "",
        hole3Score: "",
        hole4Score: "",
        hole5Score: "",
        hole6Score: "",
        hole7Score: "",
        hole8Score: "",
        hole9Score: "",
        hole10Score: "",
        hole11Score: "",
        hole12Score: "",
        hole13Score: "",
        hole14Score: "",
        hole15Score: "",
        hole16Score: "",
        hole17Score: "",
        hole18Score: "",
        totalStrokes: "",
        totalCoursePar: "",
        roundScoreRelativeToPar: "",
      },
      courses: [],
    };
  },
  handleSubmission: () => alert("League Round Added"),
  methods: {
    methods: { 
      format_date(value){
         if (value) {
           return moment(String(value)).format('YYYYMMDD')
          }
      },
   },
   listCourses() {
      CourseService.list().then((response) => {
        this.courses = response.data;
      });
    },
    saveLeagueScorecard() {
      leagueScorecardService.create(this.leagueScorecard).then((response) => {
        if (response.status === 201) {
          this.leagueScorecard = {
            leagueScorecardId: 0,
            leagueId: "",
            courseName: "",
            matchDate: "",
            username: "",
            teeSelection: "",
            hole1Score: "",
            hole2Score: "",
            hole3Score: "",
            hole4Score: "",
            hole5Score: "",
            hole6Score: "",
            hole7Score: "",
            hole8Score: "",
            hole9Score: "",
            hole10Score: "",
            hole11Score: "",
            hole12Score: "",
            hole13Score: "",
            hole14Score: "",
            hole15Score: "",
            hole16Score: "",
            hole17Score: "",
            hole18Score: "",
            totalStrokes: "",
            totalCoursePar: "",
            roundScoreRelativeToPar: "",
          };
        
          
        }
      });
      this.resetInputLeagueRoundsForm();
    },
    resetInputLeagueRoundsForm() {
      this.leagueScorecard = {};
    },
    
  },
  created() {
    this.listCourses();
  },
};
</script>

<style>

.league-round-input {
  margin-left: auto;
  margin-right: auto;
}
</style>