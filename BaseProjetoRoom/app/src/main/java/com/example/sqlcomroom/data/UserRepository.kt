package com.example.sqlcomroom.data

import androidx.lifecycle.LiveData
import com.example.sqlcomroom.model.User

class UserRepository(
    private val userDao: UserDao
) {

    val lerDados: LiveData<List<User>> = userDao.lerDados()

    fun addUser(user: User) {
        userDao.addUser(user)
    }

}