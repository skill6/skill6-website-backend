<template>
  <div :style="{'width': w,'height': h}" style="background-color: red;"></div>
</template>

<script>
  export default {
    name: "RedLine",
    props: {
      w: [String],
      h: [String]
    }
  }
</script>

<style scoped>

</style>