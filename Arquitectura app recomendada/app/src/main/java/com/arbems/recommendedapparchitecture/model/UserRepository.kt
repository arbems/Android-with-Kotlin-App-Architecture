package com.arbems.recommendedapparchitecture.model

import androidx.lifecycle.LiveData
import com.arbems.recommendedapparchitecture.remote.Webservice
import com.arbems.recommendedapparchitecture.data.User
import java.util.concurrent.Executor
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

// Informs Dagger that this class should be constructed only once.
@Singleton
class UserRepository @Inject constructor(
    private val webservice: Webservice,
    // Simple in-memory cache. Details omitted for brevity.
    private val executor: Executor,
    private val userDao: UserDao
) {
    fun getUser(userId: String): LiveData<User> {
        refreshUser(userId)
        // Returns a LiveData object directly from the database.
        return userDao.load(userId)
    }

    private fun refreshUser(userId: String) {
        // Runs in a background thread.
        executor.execute {
            // Check if user data was fetched recently.
            val userExists = userDao.hasUser(FRESH_TIMEOUT)
            if (!userExists) {
                // Refreshes the data.
                val response = webservice.getUser(userId).execute()

                // Check for errors here.

                // Updates the database. The LiveData object automatically
                // refreshes, so we don't need to do anything else here.
                userDao.save(response.body()!!)
            }
        }
    }

    companion object {
        val FRESH_TIMEOUT = TimeUnit.DAYS.toMillis(1)
    }
}