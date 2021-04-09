Original App Design Project - README
===

# Coupon Tracker

## Table of Contents
1. [Overview](#Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)
2. [Schema](#Schema)

## Overview
### Description
Ever wanted to purchase something for cheaper but couldn't find any deals? You might find a discount for some item that someone else wants, or vice versa. If everyone shared their coupons that they find in public, maybe you can get your hands on a bargain! With this app, you can find a coupon of your liking without the hassle of searching on your own. It is community driven, so you can help others help you.
    
### App Evaluation
- **Category:** Market
- **Mobile:** Android
- **Story:** Community-driven app that allows users to share and view coupons.
- **Market:** For users to want a discount on a certain product, or want to share any coupons they find in the public or web.
- **Habit:** Users can post throughout the day and select any coupons of their liking. They can also browse through categories and search any discounts from their local neighborhood.
- **Scope:** Rated E for Everyone

## Product Spec

### 1. User Stories (Required and Optional)

**Required Must-have Stories**

* User must register
* User must login
* User can view coupons
    * User can view details of coupons
* User can post coupons 
* User can delete their own coupons

**Optional Nice-to-have Stories**

* User can sort coupons
* User can favorite coupons
* User can report expired coupons
* User can see where the coupon is from
* Delete outdated coupons automatically

### 2. Screen Archetypes

* Register
    * User must register
* Login
    * User must login
* Coupon Stream
    * User can view coupons
    * User can sort coupons
    * Delete outdated coupons automatically
* Details
    * User can see type of coupon and what it's for
    * User can see coupon price/percent discount
    * User can inspect expiration date
* Compose/Post Coupons
    * User can post coupons
* Favorites
    * User can favorite coupons
    * User can set reminder to use coupon (notification)
* Maps
    * User can specify where the coupon is from
* Settings (EXTRA)
    * User can set stream settings, like preferences for types of coupons
    * User can set notification settings

### 3. Navigation

**Tab Navigation** (Tab to Screen)

* Coupon Stream (can split to API and Local)
* Favorites
* Maps
* Settings

**Flow Navigation** (Screen to Screen)

* Register
    * Login
* Login
    * Register
    * Coupon Stream
* Coupon Stream
    * Compose/Post Coupons
    * Details
    * Maps
    * Favorites
* Favorites
    * Details
    * Maps
* Settings
    * Compose/Post Coupons

## Wireframes
[Add picture of your hand sketched wireframes in this section]
<img src="YOUR_WIREFRAME_IMAGE_URL" width=600>

### [BONUS] Digital Wireframes & Mockups

### [BONUS] Interactive Prototype

## Schema 
[This section will be completed in Unit 9]
### Models
[Add table of models]
### Networking
- [Add list of network requests by screen ]
- [Create basic snippets for each Parse network request]
- [OPTIONAL: List endpoints if using existing API such as Yelp]
