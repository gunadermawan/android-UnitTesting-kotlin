package com.gunder.myunittesting.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import com.gunder.myunittesting.R
import com.gunder.myunittesting.databinding.ActivityMainBinding
import com.gunder.myunittesting.model.CuboidModel
import com.gunder.myunittesting.ui.model.MainViewModel

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var mainViewModel: MainViewModel
    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        mainViewModel = MainViewModel(CuboidModel())

        mainBinding.btnSave.setOnClickListener(this)
        mainBinding.btnCalculateSuraceArea.setOnClickListener(this)
        mainBinding.btnCalculateCircumference.setOnClickListener(this)
        mainBinding.btnCalculateVolume.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val length = mainBinding.edtLength.text.toString().trim()
        val width = mainBinding.edtWidth.text.toString().trim()
        val height = mainBinding.edtHeight.text.toString().trim()
        when {
            TextUtils.isEmpty(length) -> {
                mainBinding.edtLength.error = "tidak boleh kosong"
            }
            TextUtils.isEmpty(width) -> {
                mainBinding.edtWidth.error = "tidak boleh kosong"
            }
            TextUtils.isEmpty(height) -> {
                mainBinding.edtHeight.error = "tidak boleh kosong"
            }
            else -> {
                val valueLength = length.toDouble()
                val valueWidth = length.toDouble()
                val valueHeight = length.toDouble()

                when (v?.id) {
                    R.id.btn_save -> {
                        mainViewModel.save(valueLength, valueWidth, valueHeight)
                        visible()
                    }
                    R.id.btn_calculate_circumference -> {
                        mainBinding.tvResult.text = mainViewModel.getCircumFerence().toString()
                        gone()
                    }
                    R.id.btn_calculate_surace_area -> {
                        mainBinding.tvResult.text = mainViewModel.getSurfaceArea().toString()
                        gone()
                    }
                    R.id.btn_calculate_volume -> {
                        mainBinding.tvResult.text = mainViewModel.getVolume().toString()
                        gone()
                    }
                }
            }
        }
    }

    private fun gone() {
        mainBinding.btnCalculateCircumference.visibility = View.GONE
        mainBinding.btnCalculateSuraceArea.visibility = View.GONE
        mainBinding.btnCalculateVolume.visibility = View.GONE
        mainBinding.btnSave.visibility = View.VISIBLE
    }

    private fun visible() {
        mainBinding.btnCalculateCircumference.visibility = View.VISIBLE
        mainBinding.btnCalculateSuraceArea.visibility = View.VISIBLE
        mainBinding.btnCalculateVolume.visibility =View.VISIBLE
        mainBinding.btnSave.visibility = View.GONE

    }
}