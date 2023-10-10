<template>
    <div>
        <String label="상품명" v-model="value.name" :editMode="editMode"/>
        <String label="상세설명" v-model="value.description" :editMode="editMode"/>
        <Money offline label="가격" v-model="value.price" :editMode="editMode" @change="change"/>
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
    name: 'Product',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "products"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>

