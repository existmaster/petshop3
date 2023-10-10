<template>

    <v-card outlined>
        <v-card-title>
            CreateProduct
        </v-card-title>

        <v-card-text>
            <String label="Name" v-model="value.name" :editMode="editMode"/>
            <Money offline label="Price" v-model="value.price" :editMode="editMode" @change="change"/>
            <String label="Description" v-model="value.description" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="createProduct"
            >
                CreateProduct
            </v-btn>
            
            <v-btn
                    color="deep-purple lighten-2"
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
        name: 'CreateProductCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.name = '';
            this.value.price = {};
            this.value.description = '';
        },
        watch: {
        },
        methods: {
            createProduct() {
                this.$emit('createProduct', this.value);
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

