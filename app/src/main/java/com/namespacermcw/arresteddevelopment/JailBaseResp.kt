package com.namespacermcw.arresteddevelopment

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class JailBaseResp (
    @SerializedName("status")
    @Expose
    var status: Int? = null,

    @SerializedName("next_page")
    @Expose
    var nextPage: Int? = null,

    @SerializedName("records")
    @Expose
    var records: List<Record>? = null,

    @SerializedName("current_page")
    @Expose
    var currentPage: Int? = null,

    @SerializedName("total_records")
    @Expose
    var totalRecords: Int? = null,

    @SerializedName("msg")
    @Expose
    var msg: String? = null
)