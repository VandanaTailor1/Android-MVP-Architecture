package com.example.mvp_architecture.presenter

import com.example.mvp_architecture.network.ApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class ImagesPresenter @Inject constructor (
    private val view : ImagesContract.View,
    private val apiService: ApiService
) : ImagesContract.Presenter{
    override fun getImages() {
      view.showLoading()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val images =apiService.getData()
                view.showImages(images)
                    view.hideLoading()
            }catch (e: Exception){
                view.showError(e.message ?: "Unkonwn error")
                view.hideLoading()
            }
        }
    }

}