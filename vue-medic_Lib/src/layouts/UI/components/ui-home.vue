<template>
  <div>
    <!--    Carousel-->
    <Carousel/>
    <!--    Appointment searching form-->
    <AppointmentSearch/>
    <!--    Footer-->
    <Footer/>

  </div>
</template>
<script>
import Carousel from './ui-home-carousel.vue'
import AppointmentSearch from './ui-appointment-search-form.vue'
import Footer from './ui-footer.vue'

export default {

  name: 'ui-home',
  components: {
    Carousel,
    AppointmentSearch,
    Footer
  }
}
</script>

<style scoped></style>
