package com.pliakhanau.myfirstapplication.homeWorkNetwork.dto


import com.google.gson.annotations.SerializedName

data class CoinResponse(
    @SerializedName("data")
    val `data`: List<Data>? = null,
    @SerializedName("status")
    val status: Status? = null
) {
    data class Data(
        @SerializedName("id")
        val id: Int? = null,
        @SerializedName("name")
        val name: String? = null,
        @SerializedName("quote")
        val quote: Quote? = null,
    ) {
        data class Quote(
            @SerializedName("USD")
            val uSD: USD? = null
        ) {
            data class USD(
                @SerializedName("last_updated")
                val lastUpdated: String? = null,
                @SerializedName("market_cap")
                val marketCap: Double? = null,
                @SerializedName("percent_change_1h")
                val percentChange1h: Double? = null,
                @SerializedName("percent_change_24h")
                val percentChange24h: Double? = null,
                @SerializedName("percent_change_7d")
                val percentChange7d: Double? = null,
                @SerializedName("price")
                val price: Double? = null,
                @SerializedName("volume_24h")
                val volume24h: Double? = null
            )
        }
    }
    data class Status(
        @SerializedName("credit_count")
        val creditCount: Int? = null,
        @SerializedName("elapsed")
        val elapsed: Int? = null,
        @SerializedName("error_code")
        val errorCode: Int? = null,
        @SerializedName("error_message")
        val errorMessage: Any? = null,
        @SerializedName("notice")
        val notice: Any? = null,
        @SerializedName("timestamp")
        val timestamp: String? = null,
        @SerializedName("total_count")
        val totalCount: Int? = null
    )
}