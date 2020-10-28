package com.pliakhanau.myfirstapplication.homeWorkNetwork.mapper

import com.pliakhanau.myfirstapplication.homeWorkNetwork.dto.CoinResponse
import com.pliakhanau.myfirstapplication.homeWorkNetwork.entity.CoinInfo

class CoinMapper {

    fun map(from: CoinResponse.Data): CoinInfo {

        return CoinInfo(
            id = from.id ?: 0,
            name = from.name.orEmpty(),
            percentChange1h = from.quote?.uSD?.percentChange1h ?: 0.0,
            price =from.quote?.uSD?.price ?: 0.0
        )
    }
}
