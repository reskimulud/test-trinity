package io.github.reskimulud.testtrinity.model

data class Contact(
    val id: String,
    val firstName: String,
    val lastName: String,
    val email: String? = "",
    val dob: String? = "",
)