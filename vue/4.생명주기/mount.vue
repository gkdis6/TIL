<script setup>
import { ref, onMounted } from 'vue'

const pElementRef = ref(null)

onMounted(() => {
  pElementRef.value.textContent = '마운트 되었어요!'
})
</script>

<template>
  <p ref="pElementRef">안녕</p>
</template>