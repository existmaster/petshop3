<template>
    <div>
        <String label="Size" v-model="value.size" :editMode="editMode"/>
        <String label="Gender" v-model="value.gender" :editMode="editMode"/>
        <String label="Preferences" v-model="value.preferences" :editMode="editMode"/>
        <String label="Needs" v-model="value.needs" :editMode="editMode"/>
        <Number offline label="Age" v-model="value.age" :editMode="editMode" @change="change"/>
        <PetType offline label="PetType" v-model="value.petType" :editMode="editMode" @change="change"/>
        <AllegyDetailGrid label="Allegies" offline v-model="value.allegies" :editMode="editMode" @change="change"/>

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
    name: 'PetProfile',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "petProfiles"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>

