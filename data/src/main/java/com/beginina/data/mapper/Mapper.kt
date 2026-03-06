package com.beginina.data.mapper

import com.beginina.data.dto.TelegramUserDto
import com.beginina.domain.entity.TelegramUser

fun TelegramUser.toDto(): TelegramUserDto{
    return TelegramUserDto(
        id = id,
        first_name = first_name,
        last_name = last_name,
        username = username,
        photo_url = photo_url,
        auth_date = auth_date,
        hash = hash
    )
}