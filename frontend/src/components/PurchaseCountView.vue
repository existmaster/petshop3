<template>

    <v-data-table
        :headers="headers"
        :items="purchaseCount"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'PurchaseCountView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "petId", value: "petId" },
                { text: "count", value: "count" },
            ],
            purchaseCount : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/purchaseCounts'))

            temp.data._embedded.purchaseCounts.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.purchaseCount = temp.data._embedded.purchaseCounts;
        },
        methods: {
        }
    }
</script>

