<template>
  <div>
    <h3>Doctor</h3>
    <crud-table
      endpoint="api/doctor"
      :columns="['firstName','lastName', 'sector','action']"
      :form-fields="{
               firstName: '',
               lastName:'',
               sector:''
           }"
    >
      <!-- your form input fields in this slot-->
      <template v-slot:input-fields="{formdata}">
        <b-form-group id="input-group-name" label="First Name:" label-for="input-firstName">
          <b-form-input
            id="input-firstName"
            v-model="formdata.firstName"
            required
            placeholder="Enter first name"
          ></b-form-input>
        </b-form-group>
        <b-form-group id="input-group-name" label="Last Name:" label-for="input-lastName">
          <b-form-input
            id="input-lastName"
            v-model="formdata.lastName"
            required
            placeholder="Enter last name"
          ></b-form-input>
        </b-form-group>
        <b-form-group id="input-group-sector" label="sector:" label-for="input-sector">
          <b-form-select
            id="input-sector"
            v-model="formdata.sector"
            required
            placeholder="Select sector">
            <b-form-select-option value="1">Sector 1</b-form-select-option>
            <b-form-select-option value="2">Sector 2</b-form-select-option>
          </b-form-select>
          <div class="mt-3">Selected: <strong>{{ formdata.sector }}</strong></div>
        </b-form-group>

      </template>
    </crud-table>

  </div>
</template>

<script>
import CrudTable from '../crud-table.vue'

export default {
  components: { CrudTable },
  name: 'doctor-list'
}
</script>
<style scoped>

</style>
