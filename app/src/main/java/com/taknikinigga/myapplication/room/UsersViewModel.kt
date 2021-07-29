package com.taknikinigga.myapplication.room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class UsersViewModel(application: Application) : AndroidViewModel(application) {

    private val readAllData: LiveData<List<Users>>
    private val repository: Repository

    init {

        val userDao = UserRoomDatabase.getRoomDatabase(application).getDao()
        repository = Repository(userDao)
        readAllData = repository.readAllUsersData
    }

    suspend fun adduser(users: Users) {
        repository.addUser(users)
    }

}