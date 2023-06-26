package com.lcabral.trends.presentation.extensions

import android.widget.Toast
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.lcabral.trends.R
import com.lcabral.trends.domain.model.Trending
import com.lcabral.trends.presentation.TrendingFragment

internal fun TrendingFragment.showError() {
    val materialAlertDialogBuilder =
        MaterialAlertDialogBuilder(
            requireContext(),
            com.google.android.material.R.style.AlertDialog_AppCompat
        )
    materialAlertDialogBuilder
        .setTitle("Opa! Ocorreu um erro")
        .setMessage("Aguarde")
        .setIcon(R.drawable.ic_movie)
        .setNegativeButton("Cancelar") { dialog, which ->
            showToast("cancelado")
        }

    materialAlertDialogBuilder.show()
}

internal fun TrendingFragment.showToast(string: String) {
    Toast.makeText(requireContext(), string, Toast.LENGTH_SHORT).show()
}

