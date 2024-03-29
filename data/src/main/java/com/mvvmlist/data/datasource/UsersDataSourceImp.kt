package com.mvvmlist.data.datasource

import com.mvvmlist.data.datasource.UsersDataSource
import com.mvvmlist.data.services.UsersService
import com.mvvmlist.domain.models.User

class UsersDataSourceImp(private val usersService: UsersService) :
    UsersDataSource {
    override suspend fun getUsers(): List<User> {
        return usersService.getUsers()
    }

    override suspend fun getUser(userId: Int): User {
        return usersService.getUser(userId)
    }
}