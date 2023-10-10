
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import PetDataManagementPetProfileManager from "./components/listers/PetDataManagementPetProfileCards"
import PetDataManagementPetProfileDetail from "./components/listers/PetDataManagementPetProfileDetail"
import PetDataManagementRecommendedProductManager from "./components/listers/PetDataManagementRecommendedProductCards"
import PetDataManagementRecommendedProductDetail from "./components/listers/PetDataManagementRecommendedProductDetail"
import PetDataManagementProductProfileManager from "./components/listers/PetDataManagementProductProfileCards"
import PetDataManagementProductProfileDetail from "./components/listers/PetDataManagementProductProfileDetail"

import ProductPurchasePurchasedProductManager from "./components/listers/ProductPurchasePurchasedProductCards"
import ProductPurchasePurchasedProductDetail from "./components/listers/ProductPurchasePurchasedProductDetail"

import SocialMediaInteractionSocialMediaPostManager from "./components/listers/SocialMediaInteractionSocialMediaPostCards"
import SocialMediaInteractionSocialMediaPostDetail from "./components/listers/SocialMediaInteractionSocialMediaPostDetail"

import ProductReviewProductReviewManager from "./components/listers/ProductReviewProductReviewCards"
import ProductReviewProductReviewDetail from "./components/listers/ProductReviewProductReviewDetail"

import ProductProductManager from "./components/listers/ProductProductCards"
import ProductProductDetail from "./components/listers/ProductProductDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/petDataManagements/petProfiles',
                name: 'PetDataManagementPetProfileManager',
                component: PetDataManagementPetProfileManager
            },
            {
                path: '/petDataManagements/petProfiles/:id',
                name: 'PetDataManagementPetProfileDetail',
                component: PetDataManagementPetProfileDetail
            },
            {
                path: '/petDataManagements/recommendedProducts',
                name: 'PetDataManagementRecommendedProductManager',
                component: PetDataManagementRecommendedProductManager
            },
            {
                path: '/petDataManagements/recommendedProducts/:id',
                name: 'PetDataManagementRecommendedProductDetail',
                component: PetDataManagementRecommendedProductDetail
            },
            {
                path: '/petDataManagements/productProfiles',
                name: 'PetDataManagementProductProfileManager',
                component: PetDataManagementProductProfileManager
            },
            {
                path: '/petDataManagements/productProfiles/:id',
                name: 'PetDataManagementProductProfileDetail',
                component: PetDataManagementProductProfileDetail
            },

            {
                path: '/productPurchases/purchasedProducts',
                name: 'ProductPurchasePurchasedProductManager',
                component: ProductPurchasePurchasedProductManager
            },
            {
                path: '/productPurchases/purchasedProducts/:id',
                name: 'ProductPurchasePurchasedProductDetail',
                component: ProductPurchasePurchasedProductDetail
            },

            {
                path: '/socialMediaInteractions/socialMediaPosts',
                name: 'SocialMediaInteractionSocialMediaPostManager',
                component: SocialMediaInteractionSocialMediaPostManager
            },
            {
                path: '/socialMediaInteractions/socialMediaPosts/:id',
                name: 'SocialMediaInteractionSocialMediaPostDetail',
                component: SocialMediaInteractionSocialMediaPostDetail
            },

            {
                path: '/productReviews/productReviews',
                name: 'ProductReviewProductReviewManager',
                component: ProductReviewProductReviewManager
            },
            {
                path: '/productReviews/productReviews/:id',
                name: 'ProductReviewProductReviewDetail',
                component: ProductReviewProductReviewDetail
            },

            {
                path: '/products/products',
                name: 'ProductProductManager',
                component: ProductProductManager
            },
            {
                path: '/products/products/:id',
                name: 'ProductProductDetail',
                component: ProductProductDetail
            },



    ]
})
