<template>
  <b-carousel
    id="carousel-1"
    v-model="slide"
    :interval="4000"
    controls
    indicators
    background="#ababab"
    img-width="1024"
    img-height="480"
    style="text-shadow: 1px 1px 2px #333;"
    @sliding-start="onSlideStart"
    @sliding-end="onSlideEnd"
  >

    <!-- Slides with image only -->
    <b-carousel-slide img-src="../../../assets/img/1.jpg"></b-carousel-slide>
    <b-carousel-slide img-src="../../../assets/img/2.jpg"></b-carousel-slide>
    <b-carousel-slide img-src="../../../assets/img/3.jpg"></b-carousel-slide>
    <b-carousel-slide img-src="../../../assets/img/4.jpg"></b-carousel-slide>
    <b-carousel-slide img-src="../../../assets/img/5.jpg"></b-carousel-slide>

  </b-carousel>
</template>

<script>
export default {
  name: 'ui-home-carousel',
  data () {
    return {
      slide: 0,
      sliding: null
    }
  },
  methods: {
    onSlideStart (slide) {
      this.sliding = true
    },
    onSlideEnd (slide) {
      this.sliding = false
    }
  }
}
</script>

<style scoped>

</style>
