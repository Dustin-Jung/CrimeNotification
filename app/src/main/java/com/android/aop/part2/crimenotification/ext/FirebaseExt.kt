package com.android.aop.part2.crimenotification.ext

import com.android.aop.part2.crimenotification.data.repo.FirebaseRepository

fun FirebaseRepository.loginUser(
    email: String,
    password: String,
    callback: (isSuccess: Boolean) -> Unit
) {
    getFirebaseAuth().signInWithEmailAndPassword(email, password)
        .addOnCompleteListener {
            callback(it.isSuccessful)
        }
}

fun FirebaseRepository.register(
    email: String,
    password: String,
    callback: (isSuccess: Boolean) -> Unit
) {
    getFirebaseAuth().createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener {
            callback(it.isSuccessful)
        }
}