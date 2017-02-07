package com.kazman.smog.activity

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.kazman.smog.R
import com.kazman.smog.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }
}
