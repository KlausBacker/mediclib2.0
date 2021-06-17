<template v-slot:input-fields="{formdata}">
  <div class="footer ">
    <b-card
      overlay
      img-alt="Card Image"
      text-variant="white"
    >
    </b-card>
    <b-navbar toggleable="lg" type="dark" variant="info">

      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

      <b-collapse id="nav-collapse" is-nav>

        <!-- Right aligned nav items -->
        <b-navbar-nav class="ml-auto">

          <b-nav-item-dropdown right>
            <!-- Using 'button-content' slot -->
            <template #button-content>
              <em>BackEnd</em>
            </template>
            <b-dropdown-item to="/admin">Admin</b-dropdown-item>
            <b-dropdown-item to="/doctor-admin">Doctor</b-dropdown-item>
          </b-nav-item-dropdown>
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
  </div>
</template>

<script>
export default {
  name: 'ui-footer'
}
</script>

<style scoped>
.footer {
  padding-top: 20px;
}
</style>
