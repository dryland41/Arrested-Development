package com.namespacermcw.arresteddevelopment

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Records(
    val results: List<Record>
)

data class Record (
    @SerializedName("county_state")
    @Expose
    var countyState: String,

    @SerializedName("last_name")
    @Expose
    var name: String,

    @SerializedName("charges")
    @Expose
    var charges: List<String>,

    @SerializedName("id")
    @Expose
    var id: Int,

    @SerializedName("source")
    @Expose
    var source: String,

    @SerializedName("book_date_formatted")
    @Expose
    var bookDateFormatted: String,

    @SerializedName("details")
    @Expose
    var details: List<List<String>>,

    @SerializedName("mugshot")
    @Expose
    var mugshot: String,

    @SerializedName("book_date")
    @Expose
    var bookDate: String,

    @SerializedName("source_id")
    @Expose
    var sourceId: String,

    @SerializedName("more_info_url")
    @Expose
    var moreInfoUrl: String,
)