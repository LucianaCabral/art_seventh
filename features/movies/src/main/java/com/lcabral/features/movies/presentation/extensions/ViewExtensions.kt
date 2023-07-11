package com.lcabral.features.movies.presentation.extensions

import android.widget.Toast
import com.google.android.material.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.lcabral.features.movies.presentation.MovieFragment

internal fun MovieFragment.showError() {
    val materialAlertDialogBuilder =
        MaterialAlertDialogBuilder(
            requireContext(),
            R.style.AlertDialog_AppCompat
        )
    materialAlertDialogBuilder
        .setTitle("Opa! Ocorreu um erro")
        .setMessage("Aguarde")
        .setIcon(R.drawable.ic_mtrl_chip_close_circle)
        .setNegativeButton("Cancelar") { dialog, which ->
            showToast("cancelado")
        }

    materialAlertDialogBuilder.show()
}

internal fun MovieFragment.showToast(string: String) {
    Toast.makeText(requireContext(), string, Toast.LENGTH_SHORT).show()
}
