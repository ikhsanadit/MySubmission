package com.isanapp.mysubmission

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class government(
    var name: String,
    var username: String,
    var followers: String,
    var following: String,
    var company: String,
    var location: String,
    var avatar: Int
) : Parcelable



