
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import PetProfileManager from "./components/ui/PetProfileGrid"
import RecommendedProductManager from "./components/ui/RecommendedProductGrid"
import ProductProfileManager from "./components/ui/ProductProfileGrid"

import PurchasedProductManager from "./components/ui/PurchasedProductGrid"

import PurchaseCountView from "./components/PurchaseCountView"
import SocialMediaPostManager from "./components/ui/SocialMediaPostGrid"

import ProductReviewManager from "./components/ui/ProductReviewGrid"

import ProductManager from "./components/ui/ProductGrid"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/petProfiles',
                name: 'PetProfileManager',
                component: PetProfileManager
            },
            {
                path: '/recommendedProducts',
                name: 'RecommendedProductManager',
                component: RecommendedProductManager
            },
            {
                path: '/productProfiles',
                name: 'ProductProfileManager',
                component: ProductProfileManager
            },

            {
                path: '/purchasedProducts',
                name: 'PurchasedProductManager',
                component: PurchasedProductManager
            },


            {
                path: '/purchaseCounts',
                name: 'PurchaseCountView',
                component: PurchaseCountView
            },
            {
                path: '/socialMediaPosts',
                name: 'SocialMediaPostManager',
                component: SocialMediaPostManager
            },

            {
                path: '/productReviews',
                name: 'ProductReviewManager',
                component: ProductReviewManager
            },

            {
                path: '/products',
                name: 'ProductManager',
                component: ProductManager
            },



    ]
})
