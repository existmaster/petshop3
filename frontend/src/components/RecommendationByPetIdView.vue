<template>

    <v-data-table
        :headers="headers"
        :items="recommendationByPetId"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'RecommendationByPetIdView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            recommendationByPetId : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/recommendationByPetIds'))

            temp.data._embedded.recommendationByPetIds.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.recommendationByPetId = temp.data._embedded.recommendationByPetIds;
        },
        methods: {
        }
    }
</script>

