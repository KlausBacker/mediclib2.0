<template>
  <div>
    <h3>Speciality</h3>
    <crud-table
      endpoint="api/medical-spec"
      :columns="['name','action']"
      :form-fields="{
               name: ''
           }"
    >
      <!-- your form input fields in this slot-->
      <template v-slot:input-fields="{formdata}">
        <b-form-group id="input-group-2" label="Specility Name:" label-for="input-2">
          <b-form-input
            id="input-2"
            v-model="formdata.name"
            required
            placeholder="Enter name"
          ></b-form-input>
        </b-form-group>
      </template>
    </crud-table>

  </div>
</template>

<script>
import CrudTable from '../crud-table.vue'

export default {
  name: 'speciality-list',
  components: { CrudTable }
}
</script>

<style scoped>

</style>
