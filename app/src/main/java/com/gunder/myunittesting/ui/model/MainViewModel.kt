package com.gunder.myunittesting.ui.model

import com.gunder.myunittesting.model.CuboidModel

class MainViewModel(private val cuboidModel: CuboidModel) {
    fun getCircumFerence() = cuboidModel.getCircumFerence()
    fun getSurfaceArea() = cuboidModel.getSurfaceArea()
    fun getVolume() = cuboidModel.getVolume()
    fun save(w: Double, l: Double, h: Double) {
        cuboidModel.save(w,l,h)
    }
}