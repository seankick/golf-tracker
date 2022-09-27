<template>
  
    <div id="login" class="text-center">
      <form class="form-signin" @submit.prevent="login">
        <h1 class="h3 mb-3 font-weight-normal">Edit Course</h1>

        <div class="alert alert-danger" role="alert" v-if="invalidCredentials">
          Invalid username and password!
        </div>
        <div
          class="alert alert-success"
          role="alert"
          v-if="this.$route.query.registration"
        >
          Thank you for registering, please sign in.
        </div>
        <div class="txt_field">
          <input
            type="text"
            id="course-name"
            class="form-control"
            placeholder=""
            v-model="course.courseName"
            required
            autofocus
          />
          <span></span>
          <label for="course-name" class="sr-only">Course Name</label>
        </div>

        <div class="txt_field">
          <input
            type="text"
            id="city"
            class="form-control"
            placeholder=""
            v-model="course.city"
            required
          />
          <label for="city" class="sr-only">City</label>
        </div>

        <div class="txt_field">
          <input type="text" id="city" class="state" placeholder="" v-model="course.state" required />
          <label for="state" class="sr-only">State</label>
        </div>

        <div class="txt_field">
          <input type="text" id="city" class="postalCode" placeholder="" v-model="course.postalCode" required />
          <label for="state" class="sr-only">Postal Code</label>
        </div>

        <div class="txt_field">
          <input type="text" id="city" class="googlePlusCode" placeholder="" v-model="course.googlePlusCode" required />
          <label for="state" class="sr-only">Google Plus Code</label>
        </div>

        <!-- <div class="txt_field">
          <input type="text" id="city" class="imagePath" placeholder="" v-model="course.imagePath" required />
          <label for="state" class="sr-only">Image Path</label>
        </div> -->
        
        <button type="submit" v-on:click.prevent="submitForm">Save</button>
      </form>
    </div>
  
</template>

<script>

import courseService from '../services/CourseService'

export default {
    name: "editCourse",
    data() {
    return {
      newCourse: {
        courseId: "",
        courseName: "",
        city: "",
        state: "",
        postalCode: "",
        googlePlusCode: "",

        imagePath: "",
        redTeeExists: "",
        goldTeeExists: "",
        whiteTeeExists: "",
        blackTeeExists: "",
        blueTeeExists: "",
        greenTeeExists: "",
        silverTeeExists: "",

        redTeeFrontPar: "",
        goldTeeFrontPar: "",
        whiteTeeFrontPar: "",
        blackTeeFrontPar: "",
        blueTeeFrontPar: "",
        greenTeeFrontPar: "",
        silverTeeFrontPar: "",

        redTeeBackPar: "",
        goldTeeBackPar: "",
        whiteTeeBackPar: "",
        blackTeeBackPar: "",
        blueTeeBackPar: "",
        greenTeeBackPar: "",
        silverTeeBackPar: "",

        redTeeFrontYards: "",
        goldFrontYards: "",
        whiteFrontYards: "",
        blackFrontYards: "",
        blueFrontYards: "",
        greenFrontYards: "",
        silverFrontYards: "",

        redTeeBackYards: "",
        goldBackYards: "",
        whiteBackYards: "",
        blackBackYards: "",
        blueBackYards: "",
        greenBackYards: "",
        silverBackYards: "",
      },
    };
  },
  methods: {
      submitForm() {
          courseService.update(this.course.courseId, this.course)
          .then(response => {
            if (response.status === 200) {
              this.$router.push('/courses');
            }
          })
          .catch(error => {
            this.handleErrorResponse(error, "updating");
          });
      }
  },
    // computed: {
    //     course() {
    //         return this.$store.state.courses.find((course) => {
    //             return course.courseId == this.$route.params.courseId;
    //             });
    //     }
    // }
    created() {
        this.course = this.$store.state.courses.find((course) => {
                 return course.courseId == this.$route.params.courseId;
                });

        // courseService.get(this.$route.params.courseId)
        // .then(response => {
        //     this.course = response.data;
        // })
        // .catch(err => {
        //     if(err.response && err.response.status === 404) {
        //         alert("Could not save changes, invalid course id")
        //     }
        // })
    }
    
        
}
</script>

<style>

/* body {
  
  margin: 0;
  padding: 0;
  font-family: montserrat;
  background: #3c3f56;
  height: 100vh;
  
} */



.text-center {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 400px;
  background: white;
  border-radius: 10px;
  
}

.text-center h1 {
  text-align: center;
  padding: 20px 0 20px 0;
  border-bottom: 1px solid silver;
}

.text-center form {
  padding: 0 40px;
  box-sizing: border-box;
}

form .txt_field {
  position: relative;
  border-bottom: 2px solid #adadad;
  margin: 30px 0;
}

.txt_field input {
  width: 100%;
  padding: 0 5px;
  height: 40px;
  font-size: 16px;
  border: none;
  background: none;
  outline: none;
}

.txt_field label {
  position: absolute;
  top: 50%;
  left: 5px;
  color: #adadad;
  transform: translateY(-50%);
  font-size: 16px;
  pointer-events: none;
  transition: 0.5s;
}

.txt_field span::before {
  content: "";
  position: absolute;
  top: 40px;
  left: 0;
  width: 100%;
  height: 20px;

  transition: 0.5s;
}

.txt_field input:focus ~ label,
.txt_field input:valid ~ label {
  top: -5px;
  color: #2691d9;
}

.txt_field input:focus ~ span:before,
.txt_field input:valid ~ span:before {
  width: 100%;
}

.pass {
  margin: -5px 0 20px 5px;
  color: #a6a6a6;
  cursor: pointer;
}
.pass:hover {
  text-decoration: underline;
}

button[type="submit"] {
  width: 100%;
  height: 50px;
  border: 1px solid;
  background: #2691d9;
  border-radius: 25px;
  font-size: 18px;
  color: #e9f4fb;
  font-weight: 700;
  outline: none;
}
button[type="submit"]:hover {
  border-color: #2691d9;
  transition: 0.5s;
}

.signup_link {
  margin: 30px 0;
  text-align: center;
  font-size: 16px;
  color: #666666;
}

.signup_link a {
  color: #2691d9;
  text-decoration: none;
}

.signup_link a:hover {
  text-decoration: underline;
}

.alert {
  border: none;
  color: red;
}
</style>