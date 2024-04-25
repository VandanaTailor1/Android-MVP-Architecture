package com.example.mvp_architecture.presenter

import com.example.mvp_architecture.model.ListModel

class ImagesContract {

    interface View{
        fun showLoading();
        fun hideLoading();
        fun showImages(images : List<ListModel>)
        fun showError(message : String)
    }

    interface Presenter{
        fun getImages()
    }
}