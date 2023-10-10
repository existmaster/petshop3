<template>
    <div>
        <String label="PostId" v-model="value.postId" :editMode="editMode"/>
        <String label="Content" v-model="value.content" :editMode="editMode"/>
        <String label="ImageUrl" v-model="value.imageUrl" :editMode="editMode"/>

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
    name: 'SocialMediaPost',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "socialMediaPosts"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>

