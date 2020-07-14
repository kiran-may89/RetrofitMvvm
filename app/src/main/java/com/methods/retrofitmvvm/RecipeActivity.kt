package com.methods.retrofitmvvm

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.methods.retrofitmvvm.databinding.ActivityMainBinding
import com.methods.retrofitmvvm.dto.ReciepResponse
import com.methods.retrofitmvvm.injection.Injection
import com.methods.retrofitmvvm.viewmodels.RecipeViewModel


class RecipeActivity : BaseActivity() {
    private val log = RecipeActivity::class.java.simpleName
    private var factory: ViewModelProvider.Factory = Injection.provideFactory()
    private lateinit var viewBinding: ActivityMainBinding;
    val viewModel: RecipeViewModel by lazy {
        ViewModelProvider(this, factory).get(RecipeViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        viewBinding.viewmodel = viewModel
setSupportActionBar(viewBinding.toolBar)
        init();
    }

    fun init() {


        val observer = Observer<ReciepResponse> {
            viewModel.adapter.data = it.recipes

        }
        viewModel.getRecipes().observe(this, observer)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        (menu.findItem(R.id.search).actionView as androidx.appcompat.widget.SearchView).apply {
             maxWidth = Integer.MAX_VALUE
            setSearchableInfo(searchManager.getSearchableInfo(componentName))
        }
        return super.onCreateOptionsMenu(menu);
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }
}
