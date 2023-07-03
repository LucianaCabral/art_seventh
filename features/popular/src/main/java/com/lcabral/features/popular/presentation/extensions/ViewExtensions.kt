package com.lcabral.features.popular.presentation.extensions

import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.lcabral.features.popular.presentation.PopularFragment

internal fun PopularFragment.showError() {
    val materialAlertDialogBuilder =
        MaterialAlertDialogBuilder(
            requireContext(),
            com.google.android.material.R.style.AlertDialog_AppCompat
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

internal fun PopularFragment.showToast(string: String) {
    android.widget.Toast.makeText(requireContext(), string, android.widget.Toast.LENGTH_SHORT).show()
}

