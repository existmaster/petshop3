<template>
    <v-card outlined>
        <v-card-title>
            LeaveReview
        </v-card-title>

        <v-card-text>
            <String label="ReviewId" v-model="value.reviewId" :editMode="editMode"/>
            <String label="ProductId" v-model="value.productId" :editMode="editMode"/>
            <Rating offline label="Rating" v-model="value.rating" :editMode="editMode" @change="change"/>
            <Rating offline label="Rating" v-model="value.rating" :editMode="editMode" @change="change"/>
            <String label="Comment" v-model="value.comment" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="leaveReview"
            >
                LeaveReview
            </v-btn>
            
            <v-btn
                    color="primary"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'LeaveReviewCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.reviewId = '';
            this.value.productId = '';
            this.value.rating = {};
            this.value.comment = '';
        },
        watch: {
        },
        methods: {
            leaveReview() {
                this.$emit('leaveReview', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

