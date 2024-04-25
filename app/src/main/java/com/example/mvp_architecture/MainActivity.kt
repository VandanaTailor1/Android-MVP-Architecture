package com.example.mvp_architecture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.mvp_architecture.model.ListModel
import com.example.mvp_architecture.presenter.ImagesContract
import com.example.mvp_architecture.presenter.ImagesPresenter
import javax.inject.Inject

class MainActivity : AppCompatActivity() ,ImagesContract.View{

    @Inject
    lateinit var imagesPresenter: ImagesPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
          imagesPresenter.getImages()
    }

    override fun showLoading() {
        Log.d("Loading1", "showLoading: ")
    }

    override fun hideLoading() {
        Log.d("Loading2", "hideLoading: ")
    }

    override fun showImages(images: List<ListModel>) {
        Log.d("Loading3", "showLoading: $images ")
    }

    override fun showError(message: String) {
        Log.d("Loading4", "showLoading: $message")
    }

}