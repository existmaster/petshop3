<template>
    <div style="max-height:80vh;">
        <div class="hierarchy">
            <div>후기 및 평가 &nbsp; ></div>
            <div>&nbsp; 제품 후기</div>
        </div>
        <div class="gs-bundle-of-buttons" style="max-height:10vh;">
            <v-btn @click="addNewRow" class="contrast-primary-text" small color="primary" :disabled="!hasRole('PetOwner')">
                <v-icon small>mdi-plus-circle-outline</v-icon>등록
            </v-btn>
            <v-btn  @click="editSelectedRow" class="contrast-primary-text" small color="primary" :disabled="!hasRole('')">
                <v-icon small>mdi-pencil</v-icon>수정
            </v-btn>
            <v-btn @click="leaveReviewDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('PetOwner')">
                <v-icon small>mdi-minus-circle-outline</v-icon>후기 남기기
            </v-btn>
            <v-dialog v-model="leaveReviewDialog" width="500">
                <LeaveReviewCommand
                    @closeDialog="leaveReviewDialog = false"
                    @leaveReview="leaveReview"
                ></LeaveReviewCommand>
            </v-dialog>
            <v-btn @click="deleteSelectedRows" class="contrast-primary-text" small color="primary" :disabled="!hasRole('')">
                <v-icon small>mdi-minus-circle-outline</v-icon>삭제
            </v-btn>
            <excel-export-button class="contrast-primary-text" :exportService="this.exportService" :getFlex="getFlex" />
        </div>


        <!-- the grid -->
        <wj-flex-grid
            ref="flexGrid"
            :key="value.length"
            :autoGenerateColumns="false"
            :allowAddNew="false"
            :allowDelete="true"
            :allowPinning="'SingleColumn'"
            :newRowAtTop="false"
            :showMarquee="true"
            :selectionMode="'MultiRange'"
            :validateEdits="false"
            :itemsSource="value"
            :initialized="flexInitialized"
            :selectionChanged="onSelectionChanged"
            style="margin-top:10px; max-height:65vh;"
            class="wj-felx-grid"
        >
            <wj-flex-grid-filter :filterColumns="['RowHeader','productId','rating','comment',]" />
            <wj-flex-grid-cell-template cellType="RowHeader" v-slot="cell">{{cell.row.index + 1}}</wj-flex-grid-cell-template>
            <wj-flex-grid-column binding="productId" header="ProductId" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="rating" header="Rating" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="comment" header="Comment" width="2*" :isReadOnly="true" align="center" />
        </wj-flex-grid>
        <v-col>
            <v-dialog
                v-model="openDialog"
                transition="dialog-bottom-transition"
                width="35%"
            >
                <template>
                    <v-card>
                        <v-toolbar
                            color="primary"
                            class="elevation-0"
                            height="50px"
                        >
                            <div style="color:white; font-size:17px; font-weight:700;">제품 후기 등록</div>
                            <v-spacer></v-spacer>
                            <v-icon
                                color="white"
                                small
                                @click="closeDialog()"
                            >mdi-close</v-icon>
                        </v-toolbar>
                        <v-card-text>
                            <ProductReview :offline="offline"
                                :isNew="!itemToEdit"
                                :editMode="true"
                                v-model="newValue"
                                @add="append"
                                @edit="edit"
                            />
                        </v-card-text>
                    </v-card>
                </template>
            </v-dialog>
        </v-col>
        <v-col style="margin-bottom:40px;">
            <div class="text-center">
                <v-dialog
                    width="332.5"
                    fullscreen
                    hide-overlay
                    transition="dialog-bottom-transition"
                >
                    <v-btn
                        style="position:absolute; top:2%; right:2%"
                        @click="closeDialog()"
                        depressed
                        icon 
                        absolute
                    >
                        <v-icon>mdi-close</v-icon>
                    </v-btn>
                </v-dialog>
            </div>
        </v-col>
    </div>
</template>

<script>
import BaseGrid from '../base-ui/BaseGrid'

export default {
    name: 'productReviewGrid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: 'productReviews',
        leaveReviewDialog: false,
    }),
    watch: {
        newValue: {
            deep:true,
            handler:function(){
                if(!this.newValue){
                    this.newValue = {
                        'reviewId': '',
                        'productId': '',
                        'rating': {},
                        'comment': '',
                    }
                }
            }
        }
    },
    methods:{
        leaveReview(params){
            try{
                this.repository.invoke(this.getSelectedItem(), "leaveReview", params)
                this.$EventBus.$emit('show-success','LeaveReview 성공적으로 처리되었습니다.')
            }catch(e){
                this.$EventBus.$emit('show-error', e);
            }
        },
    }
}
</script>