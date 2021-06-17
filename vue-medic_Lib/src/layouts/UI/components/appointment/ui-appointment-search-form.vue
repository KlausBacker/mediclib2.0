<template>
  <b-container id="container" fluid>
    <b-form-group id="form" inline>
      <label class="sr-only align-content-center">research</label>
      <b-form-select-option
        id="inline-form-input-research"
        class="mb-4 mr-sm-4 mb-sm-0"
        placeholder="doctor, clinic, specialty..."
      ></b-form-select-option>

      <b-button variant="primary">Search</b-button>
      </b-form-group>
  </b-container>

</template>

<script>
export default {
  name: 'ui-appointment-search-form',
  data () {
    return {
      docList: []
    }
  },
  methods: {
  }

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
