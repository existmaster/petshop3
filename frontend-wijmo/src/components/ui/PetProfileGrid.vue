<template>
    <div style="max-height:80vh;">
        <div class="hierarchy">
            <div>애견 데이터 관리 &nbsp; ></div>
            <div>&nbsp; 애견 프로필</div>
        </div>
        <div class="gs-bundle-of-buttons" style="max-height:10vh;">
            <v-btn @click="addNewRow" class="contrast-primary-text" small color="primary" :disabled="!hasRole('PetOwner')">
                <v-icon small>mdi-plus-circle-outline</v-icon>등록
            </v-btn>
            <v-btn  @click="editSelectedRow" class="contrast-primary-text" small color="primary" :disabled="!hasRole('')">
                <v-icon small>mdi-pencil</v-icon>수정
            </v-btn>
            <v-btn @click="deleteSelectedRows" class="contrast-primary-text" small color="primary" :disabled="!hasRole('')">
                <v-icon small>mdi-minus-circle-outline</v-icon>삭제
            </v-btn>
            <excel-export-button class="contrast-primary-text" :exportService="this.exportService" :getFlex="getFlex" />
        </div>
        <GetProfile @search="search"></GetProfile>


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
            <wj-flex-grid-filter :filterColumns="['RowHeader','age','size','gender','preferences','needs','allegies','petType',]" />
            <wj-flex-grid-cell-template cellType="RowHeader" v-slot="cell">{{cell.row.index + 1}}</wj-flex-grid-cell-template>
            <wj-flex-grid-column binding="age" header="Age" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="size" header="Size" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="gender" header="Gender" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="preferences" header="Preferences" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="needs" header="Needs" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="petType" header="PetType" width="2*" :isReadOnly="true" align="center" />
        </wj-flex-grid>
        <AllegyDetailGrid label="Allegies" offline v-if="selectedRow" v-model="selectedRow.allegies"/>
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
                            <div style="color:white; font-size:17px; font-weight:700;">애견 프로필 등록</div>
                            <v-spacer></v-spacer>
                            <v-icon
                                color="white"
                                small
                                @click="closeDialog()"
                            >mdi-close</v-icon>
                        </v-toolbar>
                        <v-card-text>
                            <PetProfile :offline="offline"
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
    name: 'petProfileGrid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: 'petProfiles',
    }),
    watch: {
        newValue: {
            deep:true,
            handler:function(){
                if(!this.newValue){
                    this.newValue = {
                        'age': {},
                        'size': '',
                        'gender': '',
                        'preferences': '',
                        'needs': '',
                        'allegies': [],
                        'petType': {},
                    }
                }
            }
        }
    },
    methods:{
    }
}
</script>