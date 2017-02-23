package com.kazman.smog.view

import android.content.Context
import android.databinding.BindingAdapter
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import com.kazman.smog.adapter.AbstractRecyclerAdapter
import com.kazman.smog.di.Injector

/**
 * Created by piotrkazmierczak on 23.02.2017.
 */

class BindRecyclerView : RecyclerView {

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {}

}

@BindingAdapter("bind:listAdapter")
fun setListAdapter(view: BindRecyclerView, listAdapter: AbstractRecyclerAdapter?) {
    view.layoutManager = LinearLayoutManager(Injector.component?.getContext())
    if (listAdapter != null) {
        view.adapter = listAdapter
    }
}
