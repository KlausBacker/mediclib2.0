<template>
  <b-container id="container" fluid>
    <b-form id="form" inline>
      <label class="sr-only align-content-center">research</label>
      <b-form-input
        id="inline-form-input-research"
        class="mb-4 mr-sm-4 mb-sm-0"
        placeholder="doctor, clinic, specialty..."
      ></b-form-input>

      <b-button variant="primary">Search</b-button>
    </b-form>
  </b-container>

</template>

<script>
export default {
  name: 'ui-appointment-search-form'
}
</script>

<style scoped>
#container {
  padding: 100px;
  align-content: center;
}
#form{

 }
</style>
