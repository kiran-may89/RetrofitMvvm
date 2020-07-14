package com.methods.retrofitmvvm

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.FrameLayout
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

abstract class BaseActivity : AppCompatActivity() {
    private lateinit var progressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {

        super.onCreate(savedInstanceState, persistentState)
    }

    override fun setContentView(layoutResID: Int) {
        val constraintLayout: ConstraintLayout =
            layoutInflater.inflate(R.layout.activity_base, null) as ConstraintLayout
        progressBar = constraintLayout.findViewById(R.id.progress_bar)
        val frameLayout: FrameLayout = constraintLayout.findViewById(R.id.layout_content)
        layoutInflater.inflate(layoutResID, frameLayout, true)

        super.setContentView(layoutResID)
    }

    public fun showProgressBar(visible: Boolean) {
        progressBar.visibility = if (visible) View.VISIBLE else View.GONE
    }
}