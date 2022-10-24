package com.benten.lastfmapp.signup


data class SignUpFormState(val fullnameError: Int? = null,
                           val usernameError: Int? = null,
                           val passwordError: Int? = null,
                           val isDataValid: Boolean = false)