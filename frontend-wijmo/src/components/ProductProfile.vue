<template>
    <div>
        <IngredientDetailGrid label="Ingredients" offline v-model="value.ingredients" :editMode="editMode" @change="change"/>

        <v-divider class="border-opacity-100 my-divider"></v-divider>
        <v-layout row justify-end>
            <v-btn
                width="64px"
                color="primary"
                @click="save"
            >
                저장
            </v-btn>
        </v-layout>
    </div>
</template>


<script>

import BaseEntity from './base-ui/BaseEntity'

export default {
    name: 'ProductProfile',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "productProfiles"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>

