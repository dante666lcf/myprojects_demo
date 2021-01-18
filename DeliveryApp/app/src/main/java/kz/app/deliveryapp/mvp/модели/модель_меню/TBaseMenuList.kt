package kz.app.deliveryapp.mvp.модели.модель_меню

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TBaseMenuList {

    @SerializedName("menu_list")
    @Expose
    var menuList: ArrayList<TMenuList> = ArrayList()

}