<script setup>
import { ref } from 'vue'
import ChildComp from './slotComp.vue'

const msg = ref('Vue는 개발자에게 정말 유용하죠! 🎁')
</script>

<template>
  <ChildComp></ChildComp>
  <ChildComp>부모로부터: {{ msg }}</ChildComp>
</template>