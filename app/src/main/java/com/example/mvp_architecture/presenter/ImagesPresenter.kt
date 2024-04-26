package com.example.mvp_architecture.presenter

import android.util.Log
import com.example.mvp_architecture.network.ApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class ImagesPresenter @Inject constructor (

    private val apiService: ApiService
) : ImagesContract.Presenter{
    lateinit var view : ImagesContract.View
    override fun getImages() {
      view.showLoading()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val images =apiService.getData()
                view.showImages(images)
                    view.hideLoading()
            }catch (e: Exception){
                Log.d("eeeeee", "getImages: "+e.printStackTrace())
                view.showError(e.message ?: "Unkonwn error")
                view.hideLoading()
            }
        }
    }

}