<template>
    <div>
        <String label="ProductType" v-model="value.productType" :editMode="editMode"/>
        <String label="Size" v-model="value.size" :editMode="editMode"/>
        <String label="Gender" v-model="value.gender" :editMode="editMode"/>
        <String label="Preferences" v-model="value.preferences" :editMode="editMode"/>
        <Number offline label="Age" v-model="value.age" :editMode="editMode" @change="change"/>
        <Photo offline label="Photo" v-model="value.photo" :editMode="editMode" @change="change"/>
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
    name: 'RecommendedProduct',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "recommendedProducts"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>

