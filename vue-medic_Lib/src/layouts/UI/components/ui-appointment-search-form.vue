<template>
  <b-container fluid>
    <b-form inline>
      <label class="sr-only">research</label>
      <b-form-input
        id="inline-form-input-research"
        class="mb-2 mr-sm-2 mb-sm-0"
        placeholder="doctor, clinic, specialty..."
      ></b-form-input>

      <label class="sr-only">Location</label>
      <b-input-group class="mb-2 mr-sm-2 mb-sm-0">
        <b-form-input id="inline-form-input-location" placeholder="Location"></b-form-input>
      </b-input-group>
      <b-button variant="primary">Search</b-button>
    </b-form>  </b-container>

</template>

<script>
export default {
  name: 'ui-appointment-search-form'
}
</script>

<style scoped>

</style>
