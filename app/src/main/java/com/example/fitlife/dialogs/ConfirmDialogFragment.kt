package com.example.fitlife.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class ConfirmDialogFragment : DialogFragment() {

    interface OnConfirmListener {
        fun onConfirm()
        fun onCancel()
    }

    private var listener: OnConfirmListener? = null

    fun setListener(listener: OnConfirmListener) {
        this.listener = listener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireContext())
            .setTitle("¿Añadir a favoritos?")
            .setMessage("¿Estás seguro de que quieres añadir esta rutina a favoritos?")
            .setPositiveButton("Sí") { _, _ ->
                listener?.onConfirm()
            }
            .setNegativeButton("No") { _, _ ->
                listener?.onCancel()
            }
            .create()
    }
}