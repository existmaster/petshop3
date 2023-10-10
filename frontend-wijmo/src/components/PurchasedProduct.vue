<template>
    <div>
        <String label="ProductId" v-model="value.productId" :editMode="editMode"/>
        <String label="ProductName" v-model="value.productName" :editMode="editMode"/>
        <Money offline label="Price" v-model="value.price" :editMode="editMode" @change="change"/>
        <PetProfileId offline label="PetProfileId" v-model="value.petProfileId" :editMode="editMode" @change="change"/>

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
    name: 'PurchasedProduct',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "purchasedProducts"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>

