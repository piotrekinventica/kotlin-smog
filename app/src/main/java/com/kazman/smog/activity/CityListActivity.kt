package com.kazman.smog.activity

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.kazman.smog.R
import com.kazman.smog.databinding.ActivityCityListBinding
import com.kazman.smog.viewmodel.CityListViewModel

class CityListActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val model = CityListViewModel()
        val binding = DataBindingUtil.setContentView<ActivityCityListBinding>(this, R.layout.activity_city_list)
        binding.viewModel = model
        viewModel = model
    }
}
