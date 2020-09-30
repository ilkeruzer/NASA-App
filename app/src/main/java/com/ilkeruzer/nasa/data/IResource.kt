package com.ilkeruzer.nasa.data

interface IResource<T> {
    fun onSuccess(t: T)
    //fun onUnauthorized()
    //fun onError()
    fun onFailed()
}