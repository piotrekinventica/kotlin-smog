package com.kazman.smog

import android.content.Context

/**
 * Created by piotrkazmierczak on 23.02.2017.
 */

fun Context.appVersionName(): String = this.packageManager.getPackageInfo(this.packageName, 0).versionName
