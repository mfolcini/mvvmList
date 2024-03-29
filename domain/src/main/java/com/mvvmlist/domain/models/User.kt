package com.mvvmlist.domain.models

data class User (
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val address: Address,
    val phone: String,
    val website: String
)