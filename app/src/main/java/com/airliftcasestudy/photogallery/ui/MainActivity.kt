package com.airliftcasestudy.photogallery.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airliftcasestudy.base.networking.ApiResponseCallback
import com.airliftcasestudy.base.networking.response.ImagesResponse
import com.airliftcasestudy.base.util.K.throwErrorMessage
import com.airliftcasestudy.photogallery.R
import com.airliftcasestudy.photogallery.adapter.ImageLoadStateAdapter
import com.airliftcasestudy.photogallery.adapter.ImagesAdapter
import com.airliftcasestudy.photogallery.adapter.OnItemClickListener
import com.airliftcasestudy.photogallery.bottomsheet.ImageDetailBottomSheet
import com.airliftcasestudy.photogallery.databinding.ActivityMainBinding
import com.airliftcasestudy.photogallery.extension.gotoWebView
import com.airliftcasestudy.photogallery.extension.obtainViewModel
import com.airliftcasestudy.photogallery.extension.shareImage
import com.airliftcasestudy.photogallery.extension.visible
import com.airliftcasestudy.photogallery.viewmodel.MainViewModel
import com.google.android.material.appbar.AppBarLayout
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import org.apache.commons.lang3.math.NumberUtils
import kotlin.coroutines.CoroutineContext
import kotlin.math.abs

/**
 * Created by Mustufa Ansari on 21/08/2021.
 * Email : mustufaayub82@gmail.com
 */
class MainActivity : BaseActivity() {

    lateinit var viewModel: MainViewModel
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: ImagesAdapter
    private var bottomSheet: ImageDetailBottomSheet? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = obtainViewModel(MainViewModel::class.java)

        initToolbar()
        setAdapter()


        lifecycleScope.launch {
            viewModel.images.collect {
                adapter.submitData(it)
            }

        }
        adapter.addLoadStateListener { state ->
            if (state.refresh is LoadState.Loading) {
                binding.placeHolderLayout.visible(false)
                binding.progressBar.visible(true)
                binding.imagesList.visible(false)
            }else{
                binding.placeHolderLayout.visible(false)
                binding.progressBar.visible(false)
                binding.imagesList.visible(true)

            }
        }

    }

    private fun initToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "Welcome To App Gallery"
    }

    private fun setAdapter() {
        adapter = ImagesAdapter(object : OnItemClickListener {
            override fun onItemClick(item: ImagesResponse.Hit) {
                bottomSheet = ImageDetailBottomSheet(item, object :
                    ImageDetailBottomSheet.OnClickListener {
                    override fun onClickShare(link: String) {
                        bottomSheet?.dismiss()
                        shareImage(link)
                    }

                    override fun onClickKnowMore(url: String) {
                        bottomSheet?.dismiss()
                        gotoWebView(url)
                    }
                })
                bottomSheet?.show(supportFragmentManager, "ImageDetailSheet")
            }
        })
        binding.imagesList.layoutManager =
            GridLayoutManager(this, NumberUtils.INTEGER_TWO, RecyclerView.VERTICAL, false)
        binding.imagesList.setHasFixedSize(true)
        binding.imagesList.adapter = adapter.withLoadStateFooter(
            ImageLoadStateAdapter { adapter.retry() }
        )
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        } else {
            Toast.makeText(applicationContext, item.title, Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }
}