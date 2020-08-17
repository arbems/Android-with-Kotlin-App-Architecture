package com.arbems.recommendedapparchitecture.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.arbems.recommendedapparchitecture.data.User
import com.arbems.recommendedapparchitecture.model.UserRepository

class UserProfileViewModel(
    savedStateHandle: SavedStateHandle,
    userRepository: UserRepository
) : ViewModel() {
    private val userId: String =
        savedStateHandle["uid"] ?: throw IllegalArgumentException("missing user id")

    private val _user = MutableLiveData<User>()
    val user: LiveData<User> get() = _user

    init {
        if(userId != null) {
            _user.value = userRepository.getUser(userId)?.value
        }
    }
}