package br.com.evjdev.usingsomeapismvvm.data.api.service

import okhttp3.ResponseBody
import retrofit2.Response

interface BaseServiceIF {

    fun<T: Any> onResultSuccess(responseIn: Response<T>, wsTagInt: Int) {}

    fun onResultFailure(msgIn: String, responseIn: Any? = null) {

    }
}