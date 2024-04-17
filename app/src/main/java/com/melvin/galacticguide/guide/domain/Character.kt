package com.melvin.galacticguide.guide.domain

data class Character(
    val name: String,
    val height: String,
    val mass: String,
    val hairColor: String,
    val skinColor: String,
    val eyeColor: String,
    val birthYear: String,
    val gender: String,
    val url: String
) {
    val initials: String get() = getInitials(name)
}
