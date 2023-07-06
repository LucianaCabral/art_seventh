package com.lcabral.features.toprated.presentation.extensions

import com.google.android.material.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.lcabral.features.toprated.presentation.TopRatedFragment

internal fun TopRatedFragment.showError() {
    val materialAlertDialogBuilder =
        MaterialAlertDialogBuilder(
            requireContext(),
            R.style.AlertDialog_AppCompat
        )
    materialAlertDialogBuilder
        .setTitle("Opa! Ocorreu um erro")
        .setMessage("Aguarde")
        .setIcon(coil.base.R.drawable.notification_tile_bg)
        .setNegativeButton("Cancelar") { dialog, which ->
            showToast("cancelado")
        }

    materialAlertDialogBuilder.show()
}

internal fun TopRatedFragment.showToast(string: String) {
    android.widget.Toast.makeText(requireContext(), string, android.widget.Toast.LENGTH_SHORT).show()
}
