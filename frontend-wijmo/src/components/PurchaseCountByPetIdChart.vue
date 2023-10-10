<template>
    <div>
        <apexchart 
                width="800" 
                :type="type" 
                :options="options"
                :series="series"
                ref="barChart"
        ></apexchart>
    </div>
</template>

<script>
    import BaseUIChart from './base-ui/BaseUIChart';
    import VueApexCharts from 'vue-apexcharts';

    export default {
        mixins: [BaseUIChart],
        name: 'PurchaseCountByPetIdChart',
        components: {
            'apexchart': VueApexCharts,
        },
        data: () => ({
            type: "bar",
        }),
        async created() {
            const path = "purchaseCounts"
            await this.getValue(path);

            const type = "bar";
            const categories = [ "petId" ];
            const data = [ "count" ];
            await this.setValue(type, categories, data);

            this.$refs.barChart.refresh();
        },
        methods: {
        }
    }
</script>

