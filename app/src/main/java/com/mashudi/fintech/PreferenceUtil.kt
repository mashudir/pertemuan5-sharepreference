package com.mashudi.fintech

import android.content.Context
import androidx.preference.PreferenceManager

class PreferenceUtil private constructor(context: Context) {

    companion object {
        private var instance: PreferenceUtil? = null

        fun newInstance(context: Context) = instance ?: PreferenceUtil(context).also {
            instance = it
        }
    }


    private val pref = PreferenceManager.getDefaultSharedPreferences(context)

    fun setString(key: String, value: String) = pref.edit().putString(key, value).apply()
    fun setBoolean(key: String, value: Boolean) = pref.edit().putBoolean(key, value).apply()

    fun getString(key: String) = pref.getString(key, null)
    fun getBoolean(key: String) = pref.getBoolean(key, false)
}