package com.benten.lastfmapp.signup

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.benten.lastfmapp.R


class SignUpViewModel : ViewModel() {
    private val _signupForm = MutableLiveData<SignUpFormState>()
    val signupFormState: LiveData<SignUpFormState> = _signupForm



    fun signup(fullname: String, username: String, password: String) {

    }

    fun signupDataChanged(fullname: String, username: String, password: String) {
        if (!isFullNameValid(fullname)) {
            _signupForm.value = SignUpFormState(fullnameError = R.string.invalid_full_name)
        } else if (!isUserNameValid(username)) {
            _signupForm.value = SignUpFormState(usernameError = R.string.invalid_username)
        } else if (!isPasswordValid(password)) {
            _signupForm.value = SignUpFormState(passwordError = R.string.invalid_password)
        } else {
            _signupForm.value = SignUpFormState(isDataValid = true)
        }
    }

    private fun isFullNameValid(fullname: String): Boolean {
        return fullname.isNotBlank()
    }

    private fun isUserNameValid(username: String): Boolean {
        return if (username.contains("@")) {
            Patterns.EMAIL_ADDRESS.matcher(username).matches()
        } else {
            username.isNotBlank()
        }
    }

    private fun isPasswordValid(password: String): Boolean {
        return password.length > 5
    }
}