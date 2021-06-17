<template>
  <div>
    <h1> Dashboard</h1>
    <appointment-list/>
  </div>
</template>

<script>
import AppointmentList from '@/layouts/doctor/components/appointmentList'
export default {
  name: 'doctor-dashboard',
  components: { AppointmentList }
}
</script>

<style scoped></style>
