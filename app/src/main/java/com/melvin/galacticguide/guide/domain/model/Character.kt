package com.melvin.galacticguide.guide.domain.model

import com.melvin.galacticguide.guide.domain.getInitials

data class Character(
    val name: String,
    val height: String,
    val mass: String,
    val hairColor: String,
    val skinColor: String,
    val eyeColor: String,
    val birthYear: String,
    val gender: String,
    val id: Int?
) {
    val initials: String get() = getInitials(name)
}
