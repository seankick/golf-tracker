<template>
  <body>
    <div id="login" class="text-center">
      <form class="form-signin" @submit.prevent="login">
        <h1 class="h3 mb-3 font-weight-normal">Login</h1>
        
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
            id="username"
            class="form-control"
            placeholder=""
            v-model="user.username"
            required
            autofocus
          />
          <span></span>
          <label for="username" class="sr-only">Username</label>
        </div>

        <div class="txt_field">
          <input
            type="password"
            id="password"
            class="form-control"
            placeholder=""
            v-model="user.password"
            required
          />
          <label for="password" class="sr-only">Password</label>
        </div>

        <button type="submit">Sign in</button>

        <div class="signup_link">
          <router-link :to="{ name: 'register' }">Need an account?</router-link>
        </div>
      </form>
    </div>
  </body>
</template>

<script>
import authService from "../services/AuthService";
//import UserList from "../components/UserList.vue";

export default {
  name: "login",
  // components: {
  //   UserList,
  // },
  data() {
    return {
      user: {
        username: "",
        password: "",
      },
      invalidCredentials: false,
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch((error) => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
  },
};
</script>

<style>
body {
  margin: 0;
  padding: 0;
  font-family: montserrat;
  background: #3c3f56;
  height: 100vh;
  overflow: hidden;
}

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
