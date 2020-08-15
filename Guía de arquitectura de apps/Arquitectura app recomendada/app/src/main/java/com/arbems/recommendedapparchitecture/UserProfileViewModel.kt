package com.arbems.recommendedapparchitecture

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

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