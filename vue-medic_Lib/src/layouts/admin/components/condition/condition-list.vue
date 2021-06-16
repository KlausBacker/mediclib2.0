<template>
  <div>
    <h3>Condition</h3>
    <crud-table
      endpoint="api/medical-condition"
      :columns="['name','speciality.id','action']"
      :form-fields="{
               name: '',
               speciality:0,
                    }"
    >
      <!-- your form input fields in this slot-->
      <template v-slot:input-fields="{formdata}">
        <b-form-group id="input-group-name" label="Name:" label-for="input-name">
          <b-form-input
            id="input-"
            v-model="formdata.name"
            required
            placeholder="Enter condition name"
          ></b-form-input>
        </b-form-group>
        <b-form-group id="input-group-name" label="Speciality:" label-for="input-speciality">
          <b-form-select
            id="input-speciality"
            v-model="formdata.speciality"
            :options="medpseSelectList"
            required
            placeholder="Enter speciality name"
          />
<!--          <div class="mt-3">Selected: <strong>{{ selected }}</strong></div>-->
        </b-form-group>
      </template>
    </crud-table>
  </div>
</template>

<script>
import CrudTable from '../crud-table.vue'
import axios from 'axios'

export default {
  components: { CrudTable },
  name: 'condition-list',
  data () {
    return {
      sectors: [{ value: 1, text: 'sector 1' }, { value: 2, text: 'sector 2' }],
      medpseSelectList: [
        { value: { id: 1 }, text: 'Dermatology' },
        { value: { id: 2 }, text: 'Cardiology' },
        { value: { id: 3 }, text: 'Ophthalmology' },
        { value: { id: 4 }, text: 'Urology' },
        { value: { id: 5 }, text: 'Neurology' },
        { value: { id: 6 }, text: 'Oncology' },
        { value: { id: 7 }, text: 'Gynaecology' },
        { value: { id: 8 }, text: 'Psychiatry' },
        { value: { id: 9 }, text: 'Pulmonology' },
        { value: { id: 10 }, text: 'Pediatrics' },
        { value: { id: 11 }, text: 'Radiology' }
      ]
    }
  },
  created () {
    axios('http://localhost:8080/api/medical-spec').then(response => {
      this.specialityList = response.data
    })
  }
}
</script>

<style scoped>

</style>
