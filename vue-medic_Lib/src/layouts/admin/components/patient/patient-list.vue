<template>
  <div>
    <h3>Patient</h3>
    <crud-table
      endpoint="api/patient"
      :columns="['firstName','lastName', 'numberSecSoc', 'birthday','action']"
      :form-fields="{
               firstName: '',
               lastName:'',
               birthday:'',
               numberSecSoc:''
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
        <b-form-group id="input-group-numberSecSoc" label="numberSecSoc:" label-for="input-numberSecSoc">
          <b-form-input
            id="input-numberSecSoc"
            v-model="formdata.numberSecSoc"
            required
            placeholder="Enter numberSecSoc"
          ></b-form-input>
        </b-form-group>
      </template>
    </crud-table>

  </div>
</template>

<script>
import CrudTable from '../crud-table.vue'
export default {
  components: { CrudTable },
  name: 'patient-list'
}
</script>

<style scoped>

</style>
