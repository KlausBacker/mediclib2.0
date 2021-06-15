<template>
  <div>
    <div class="header">
      <b-navbar toggleable="lg" type="dark" variant="info">
        <b-navbar-brand to="/" >Mediclib UI</b-navbar-brand>

        <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

        <b-collapse id="nav-collapse" is-nav>
          <b-navbar-nav>
            <b-nav-item to="/admin">Admin</b-nav-item>
            <b-nav-item href="admin" >Disabled</b-nav-item>
          </b-navbar-nav>

          <!-- Right aligned nav items -->
          <b-navbar-nav class="ml-auto">
            <b-nav-form>
              <b-form-input size="sm" class="mr-sm-2" placeholder="Search"></b-form-input>
              <b-button size="sm" class="my-2 my-sm-0" type="submit">Search</b-button>
            </b-nav-form>

            <b-nav-item-dropdown text="Lang" right>
              <b-dropdown-item href="#">EN</b-dropdown-item>
              <b-dropdown-item href="#">ES</b-dropdown-item>
              <b-dropdown-item href="#">RU</b-dropdown-item>
              <b-dropdown-item href="#">FA</b-dropdown-item>
            </b-nav-item-dropdown>

            <b-nav-item-dropdown right>
              <!-- Using 'button-content' slot -->
              <template #button-content>
                <em>User</em>
              </template>
              <b-dropdown-item to="patient-profile">Profile</b-dropdown-item>
              <b-dropdown-item to="patient-dashboard">Dashboard</b-dropdown-item>
              <b-dropdown-item href="#">Sign Out</b-dropdown-item>
            </b-nav-item-dropdown>
          </b-navbar-nav>
        </b-collapse>
      </b-navbar>
      <!--    Navigation-->
      <ui-navigation/>
    </div>
  </div>
</template>
<script>
import UiNavigation from '@/layouts/UI/components/ui-navigation.vue'

export default {
  name: 'ui-header',
  components: { UiNavigation }
}
</script>

<style scoped></style>
