package com.androidmodule.dialoglibrary

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

object DialogUtils {

    /**
     * NATIVE ANDROID DIALOG with OK and CANCEL, not any Operation on clicking buttons
     */
    fun showAndroidNativeDialogOnly(context: Context, messageOnDialog:String){
        AlertDialog.Builder(context)
            .setTitle("Application Name")
            .setMessage(messageOnDialog)

            // Specifying a listener allows you to take an action before dismissing the dialog.
            // The dialog is automatically dismissed when a dialog button is clicked.
            .setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->
                // Continue with delete operation
                //Toast.makeText(context, "Clicked on YES!", Toast.LENGTH_SHORT).show()
            })

            // A null listener allows the button to dismiss the dialog and take no further action.
            .setNegativeButton("Cancel", null)
            .setIcon(android.R.drawable.ic_dialog_alert)
            .show()
    }

    /**
     * SINGLE BUTTON DIALOG: NO CALLBACK
     *
     * 1. WILL AUTO CANCEL ON OUTSIDE TOUCH
     * 2. CANCELABLE
     *
     */

    fun showSingleButtonDialog(context: Context, messageToShow:String){
        showSingleButtonDialogWithCallback(context, messageToShow, null)
    }

    fun showSingleButtonDialogWithCallback(context: Context, message:String, clickListener: View.OnClickListener?){

        val singleDialog = Dialog(context)
        singleDialog.setContentView(R.layout.single_button_dialog_layout)
        singleDialog.setCanceledOnTouchOutside(true)
        singleDialog.setCancelable(true)
        singleDialog.window?.apply {
            attributes?.windowAnimations = R.style.DialogDroppingAnimation
            setBackgroundDrawableResource(android.R.color.transparent)
        }
        (singleDialog.findViewById<Button>(R.id.buttonOk)).setOnClickListener{
            singleDialog.dismiss()
            clickListener?.apply {
                clickListener.onClick(it)
            }
        }
        (singleDialog.findViewById<TextView>(R.id.msgTV)).text = message
        singleDialog.show()
    }



}