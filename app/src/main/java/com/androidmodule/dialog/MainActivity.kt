package com.androidmodule.dialog

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.androidmodule.dialoglibrary.DialogUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addEventListeners()
    }

    private fun addEventListeners() {
        nativeDialog.setOnClickListener(this)
        showSingleButtonDialog.setOnClickListener(this)
        showSingleBtnDialogWithCallback.setOnClickListener(this)
    }

    override fun onClick(clickedButton: View?) {
        when(clickedButton?.id){
            R.id.nativeDialog                       -> showNativeDialog()
            R.id.showSingleButtonDialog             -> showSingleButtonDialogs()
            R.id.showSingleBtnDialogWithCallback    -> showSingleBtnDialogWithCallbacks()
        }
    }
    private fun showNativeDialog() {
        DialogUtils.showAndroidNativeDialogOnly(this, "This is the Android Native System Dialog")
    }
    private fun showSingleButtonDialogs() {
        DialogUtils.showSingleButtonDialog(this, "This is custom created dialog with no callback Click events")
    }
    private fun showSingleBtnDialogWithCallbacks() {
        DialogUtils.showSingleButtonDialogWithCallback(this, "This is custom created dialog with Click events Callbacks",
            View.OnClickListener { clickedButton ->
                when(clickedButton?.id) {
                    R.id.buttonOk -> Toast.makeText(this@MainActivity, "Clicked on OK button...", Toast.LENGTH_SHORT).show()
                }
            })
    }



}
