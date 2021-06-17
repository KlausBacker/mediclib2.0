<template>

<b-container class="appoitmentCardLayout">
  <b-row>
    <b-card-group deck>
      <b-col v-for="aptmt in apmtList" :key="aptmt">
        <b-card title-tag="Title" header-tag="header" footer-tag="footer">
          <template #header>
            <h6 class="mb-0">{{ aptmt.id }}</h6>
          </template>
          <div>
            <h3>Doctor : {{ aptmt.doctor.id }}</h3>

          </div>
          <b-card-text>Header and footers using slots.</b-card-text>
          <b-button href="#" variant="primary">Go somewhere</b-button>
          <template #footer>
            <em>Footer Slot</em>
          </template>
        </b-card>
      </b-col>
    </b-card-group>
  </b-row>
</b-container>

</template>

<script>
import axios from 'axios'

export default {
  name: 'appointmentList',
  data () {
    return {
      apmtList: []
    }
  },
  created () {
    axios('http://localhost:8080/api/appointment').then(response => {
      this.apmtList = response.data
    })
  }
}

</script>

<style scoped>

</style>
