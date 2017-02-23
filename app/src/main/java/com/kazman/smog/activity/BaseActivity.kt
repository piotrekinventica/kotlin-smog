package com.kazman.smog.activity

import android.support.v7.app.AppCompatActivity
import com.kazman.smog.viewmodel.ViewModel

/**
 * Created by piotrkazmierczak on 07.02.2017.
 */
open class BaseActivity : AppCompatActivity() {
    var viewModel: ViewModel? = null

    override fun onPause() {
        super.onPause()
        viewModel?.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel?.onDestroy()
    }

    override fun onResume() {
        super.onResume()
        viewModel?.onResume()
    }
}
