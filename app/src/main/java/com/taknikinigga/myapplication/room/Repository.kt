package com.taknikinigga.myapplication.room

import androidx.lifecycle.LiveData

class Repository(private val usersDao: UsersDao) {

    val readAllUsersData: LiveData<List<Users>> = usersDao.getAllUserData()


    suspend fun addUser(users: Users) {
        usersDao.createUser(users)
    }

}