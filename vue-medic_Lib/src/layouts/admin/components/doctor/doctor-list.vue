<template>
  <div>
    <h3>Doctor</h3>
    <crud-table
      endpoint="api/doctor"
      :columns="['firstName','lastName','specialityList', 'action']"
      :form-fields="{
               firstName: '',
               lastName:'',
               sector:'',
               specialityList:[{}]
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
            :options="sectors"
            required
            placeholder="Select sector">
          </b-form-select>
<!--          <div class="mt-3">Selected: <strong>{{ formdata.sector }}</strong></div>-->
        </b-form-group>
        <b-form-group id="input-group-specialityList" label="speciality(ies)" label-for="input-specialityList">
          <b-form-select
            multiple
            id="input-specialityList"
            v-model="formdata.specialityList"
            :options="medpseSelectList"
            required
            placeholder="Select speciality(ies)">
          </b-form-select>
          <div class="mt-3">Selected: <strong>{{ formdata.specialityList }}</strong></div>
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
  name: 'doctor-list',
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

  createdSpe () {
    axios('http://localhost:8080/' + 'api/medical-spec').then(response => {
      this.MedSpeList = response.data
    })

    this.MedSpeList.forEach((speciality) => {
      const selectListOption = [{
        value: speciality,
        text: speciality.name
      }]
      this.medpseSelectList.push(selectListOption)
    })
  }

}
</script>
<style scoped>

</style>
