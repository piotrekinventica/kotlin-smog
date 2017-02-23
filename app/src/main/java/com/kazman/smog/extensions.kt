package com.kazman.smog

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by piotrkazmierczak on 23.02.2017.
 */

fun Context.appVersionName(): String = this.packageManager.getPackageInfo(this.packageName, 0).versionName

inline fun SharedPreferences.edit(func: SharedPreferences.Editor.() -> Unit) {
    val editor = edit()
    editor.func()
    editor.apply()
}
