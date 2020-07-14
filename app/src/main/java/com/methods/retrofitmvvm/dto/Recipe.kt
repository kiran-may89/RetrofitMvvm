package com.methods.retrofitmvvm.dto

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


data class Recipe(
    @SerializedName("image_url") val imageUrl: String,
    @SerializedName("social_rank") val scoialRank: Double,
    @SerializedName("_id") val id: String,
    @SerializedName("publisher") val publisher: String,
    @SerializedName("source_url") val sourceUrl: String,
    @SerializedName("recipe_id") val recipeId: String,
    @SerializedName("publisher_url") val publisherUrl: String,
    @SerializedName("title") val title: String

) : Parcelable {
    constructor(parcel: Parcel) : this(
        imageUrl = parcel.readString()!!,
        scoialRank = parcel.readDouble(),
        id = parcel.readString()!!,
        publisher = parcel.readString()!!,
        sourceUrl = parcel.readString()!!,
        recipeId = parcel.readString()!!,
        publisherUrl = parcel.readString()!!,
        title = parcel.readString()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(imageUrl)
        parcel.writeDouble(scoialRank)
        parcel.writeString(id)
        parcel.writeString(publisher)
        parcel.writeString(sourceUrl)
        parcel.writeString(recipeId)
        parcel.writeString(publisherUrl)
        parcel.writeString(title)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Recipe> {
        override fun createFromParcel(parcel: Parcel): Recipe {
            return Recipe(parcel)
        }

        override fun newArray(size: Int): Array<Recipe?> {
            return arrayOfNulls(size)
        }
    }
}