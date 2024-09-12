package com.example.practiceagrid.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val stringResId: Int ,
                val intAmountOfTopic: Int ,
    @DrawableRes val imageResId: Int
)
