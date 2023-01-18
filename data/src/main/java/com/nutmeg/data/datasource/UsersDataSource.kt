package com.nutmeg.data.datasource

import com.nutmeg.domain.models.User

interface UsersDataSource {
    suspend fun getUsers() : List<User>

    suspend fun getUser(userId: Int) : User
}