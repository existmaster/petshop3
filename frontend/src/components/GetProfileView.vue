<template>

    <v-data-table
        :headers="headers"
        :items="getProfile"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'GetProfileView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            getProfile : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/getProfiles'))

            temp.data._embedded.getProfiles.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.getProfile = temp.data._embedded.getProfiles;
        },
        methods: {
        }
    }
</script>

