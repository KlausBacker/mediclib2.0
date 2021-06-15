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
<!--        <b-form-group id="input-group-name" label="Speciality:" label-for="input-speciality">-->
        <!--          <b-form-select-->
        <!--            id="input-speciality"-->
        <!--            v-model="formdata.speciality"-->
        <!--            required-->
        <!--            placeholder="Enter speciality name"-->
        <!--          >-->
        <!--            <b-form-select-option v-for="speciality in specialityList"  value={{speciality.id}}>-->
        <!--              {{ speciality.name }}-->
        <!--            </b-form-select-option>-->
        <!--          </b-form-select>-->
        <!--          <div class="mt-3">Selected: <strong>{{ selected }}</strong></div>-->
        <!--        </b-form-group>-->
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
      selected: null,
      specialityList: [
        { value: 'a', text: 'This is First option' }
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
