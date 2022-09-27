<template>
  <div id="user-container">
    <h1>Whole Lot of Users</h1>
    <table>
      <tr>
        <th>User ID</th>
        <th>Username</th>
        <th>Role</th>
      </tr>

      <tr v-for="user in users" v-bind:key="user.id">
        <td>{{ user.id }}</td>
        <td>{{ user.username }}</td>
        <td v-show="user.authorities.length > 0">{{ getFirstRole(user) }}</td>
      </tr>
    </table>
  </div>
</template>

<script>
import locationService from "../services/UserService";

export default {
  name: "user-list",
  methods: {
      test() {
          return 'hello';
      },


    getFirstRole(user) {
      if (user && user.authorities) {
        let class_obj;
        if (user.authorities.length > 0) {
          return class_obj = user.authorities[0].name;
        }
        return class_obj;
      }
      return null;
    },
  },

  data() {
    return {
      users: [],
    };
  },
  created() {
    locationService.get().then((response) => {
      this.users = response.data;
    });
  },
};
</script>

<style>
</style>