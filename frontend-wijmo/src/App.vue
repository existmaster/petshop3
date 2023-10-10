<template>
    <v-app id="inspire">
        <div>
            <Snackbar/>
            <v-app-bar app clipped-left flat color="primary">
                <v-toolbar-title>
                    <v-app-bar-nav-icon class="contrast-primary-text"
                        @click="openSideBar()"
                        style="font-size:56px; font-weight: 300; padding-top:8px; margin-right:5px;"
                    >≡
                    </v-app-bar-nav-icon>
                    <span class="second-word font uppercase contrast-primary-text"
                        style="font-weight:700;"
                    >petshop
                    </span>
                </v-toolbar-title>
                <span v-if="urlPath!=null" 
                    class="mdi mdi-home contrast-primary-text"
                    key="" 
                    to="/" 
                    @click="goHome()"
                    style="margin-left:10px; font-size:20px; cursor:pointer;"
                    ></span> 
                <v-spacer></v-spacer>

                <b style="margin-left:10px; font-size:10px;"
                    class="contrast-primary-text"
                >{{username}} 님</b>
                <v-btn
                    text
                    class="contrast-primary-text"
                    style="font-size:10px"
                    @click="logout()"
                >Logout
                </v-btn>
            </v-app-bar>

            <v-navigation-drawer app clipped flat v-model="sideBar">
                <v-list>
                    <v-list-group
                        v-for="menu in menus"
                        :key="menu.id"
                        no-action
                    >
                        <template v-slot:activator>
                            <v-list-item-content>
                                <v-list-item-title>{{ menu.title }}</v-list-item-title>
                            </v-list-item-content>
                        </template>

                        <v-list-item
                            v-for="item in menu.items"
                            :key="item.key"
                            :to="item.url"
                            @click="changeUrl()"
                            style="margin-left: -40px;"
                        >
                            <v-list-item-content>
                                <v-list-item-title>{{ item.name }}</v-list-item-title>
                            </v-list-item-content>
                        </v-list-item>
                    </v-list-group>
                </v-list>
            </v-navigation-drawer>
        </div>

        <v-main>
            <v-container v-if="urlPath" style="max-width:100vw !important;" class="py-8 px-6 mt-10" fluid>
                <router-view></router-view>
            </v-container>
            <v-container v-else class="py-8 px-6 mt-10" fluid>
                <v-row>
                    <v-card
                        v-for="(card, index) in cards"
                        :key="index"
                        class="mx-auto"
                        style="height:300px; width:300px; margin-bottom:20px;"
                        outlined
                    >
                        <v-list-item>
                            <v-list-item-avatar class="mx-auto" size="80" style="margin-top:80px;">
                                <v-icon color="primary" size="64">mdi-apps</v-icon>
                            </v-list-item-avatar>
                        </v-list-item>
                        
                        <v-card-actions>
                        <v-tooltip bottom>
                            <template v-slot:activator="{ on }">
                                <v-btn
                                    v-on="on"
                                    class="mx-auto"
                                    outlined
                                    rounded
                                    :to="card.link"
                                    @click="changeUrl()"
                                    style="font-weight:500; font-size:20px; padding:15px; border:solid 2px; max-width:250px; overflow:hidden"
                                >
                                    {{ card.text }}
                                </v-btn>
                            </template>
                            <span>{{ card.text }}</span>
                        </v-tooltip>
                        </v-card-actions>
                    </v-card>
                </v-row>
            </v-container>
        </v-main>
    </v-app>
</template>

<script>
import BaseGrid from './components/base-ui/BaseGrid'

export default {
    name: "App",
    mixins:[BaseGrid],
    data: () => ({
        useComponent: "",
        drawer: true,
        components: {},
        sideBar: true,
        urlPath: null,
        menus: [
            { id: 'petDataManagement', title: '애견 데이터 관리',
                items: [
                    { key: 'petProfiles', url: '/petProfiles', name: '애견 프로필' },
                    { key: 'recommendedProducts', url: '/recommendedProducts', name: '추천 제품' },
                    { key: 'productProfiles', url: '/productProfiles', name: 'ProductProfile' },
                ]
            },
            { id: 'productPurchase', title: '상품 구매',
                items: [
                    { key: 'purchasedProducts', url: '/purchasedProducts', name: '구매된 제품' },
                ]
            },
            { id: 'socialMediaInteraction', title: '소셜 미디어 상호작용',
                items: [
                    { key: 'socialMediaPosts', url: '/socialMediaPosts', name: '소셜 미디어 포스트' },
                ]
            },
            { id: 'productReview', title: '후기 및 평가',
                items: [
                    { key: 'productReviews', url: '/productReviews', name: '제품 후기' },
                ]
            },
            { id: 'product', title: 'Product',
                items: [
                    { key: 'products', url: '/products', name: 'Product' },
                ]
            },
        ],
        cards: [
            {
                text: "애견 프로필",
                link: "/petProfiles",
            },
            {
                text: "추천 제품",
                link: "/recommendedProducts",
            },
            {
                text: "ProductProfile",
                link: "/productProfiles",
            },
            {
                text: "구매된 제품",
                link: "/purchasedProducts",
            },
            {
                text: "소셜 미디어 포스트",
                link: "/socialMediaPosts",
            },
            {
                text: "제품 후기",
                link: "/productReviews",
            },
            {
                text: "Product",
                link: "/products",
            },
        ],
        activeMenu: null
    }),
    
    async created() {
      var path = document.location.href.split("#/")
      this.urlPath = path[1];
    },

    mounted() {
        var me = this;
        me.components = this.$ManagerLists;
    },
    computed: {
        activeMenuItems() {
            const activeMenu = this.menus.find(menu => menu.id === this.activeMenu);
            return activeMenu ? activeMenu.items : [];
        }
    },
    methods: {
        changeMenu(menuId) {
            this.activeMenu = this.activeMenu === menuId ? null : menuId;
        },
        changePath(event) {
            let targetUrl = event.currentTarget.getAttribute('data-to');
            this.$router.push(targetUrl);
        },
        openSideBar(){
            this.sideBar = !this.sideBar
        },
        changeUrl() {
            var path = document.location.href.split("#/")
            this.urlPath = path[1];
        },
        goHome() {
            this.urlPath = null;
        },
    }
};
</script>
<style>

</style>
