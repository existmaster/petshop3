<template>
    <div>
        <String label="ReviewId" v-model="value.reviewId" :editMode="editMode"/>
        <String label="ProductId" v-model="value.productId" :editMode="editMode"/>
        <String label="Comment" v-model="value.comment" :editMode="editMode"/>

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
    name: 'ProductReview',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "productReviews"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>

