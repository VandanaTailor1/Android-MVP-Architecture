package com.example.mvp_architecture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.mvp_architecture.databinding.ActivityMainBinding
import com.example.mvp_architecture.model.ListModel
import com.example.mvp_architecture.presenter.ImagesContract
import com.example.mvp_architecture.presenter.ImagesPresenter
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() ,ImagesContract.View{

    @Inject
    lateinit var imagesPresenter: ImagesPresenter
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        imagesPresenter.view=this@MainActivity

        binding.tvApiCall.setOnClickListener(View.OnClickListener {
            imagesPresenter.getImages()
        })


    }

    override fun showLoading() {
        Log.d("Loading1", "showLoading: ")
    }

    override fun hideLoading() {
        Log.d("Loading2", "hideLoading: ")
    }

    override fun showImages(images: ListModel) {
        Log.d("Loading3", "showLoading: $images ");

    }

    override fun showError(message: String) {
        Log.d("Loading4", "showLoading: $message")
    }


}