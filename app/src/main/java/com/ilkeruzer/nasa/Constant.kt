package com.ilkeruzer.nasa

interface Constant {

    interface ITEMTYPE {
        companion object {
            const val NULLTYPE = 0
            const val ONETYPE = 1
        }
    }

    interface BUNDLE {
        companion object {
            const val TYPE = BuildConfig.APPLICATION_ID + ".type"
        }
    }


}