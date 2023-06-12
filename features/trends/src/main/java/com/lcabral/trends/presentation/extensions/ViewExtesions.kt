package com.lcabral.trends.presentation.extensions

import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.lcabral.trends.R
import com.lcabral.trends.presentation.TrendingFragment
import com.lcabral.trends.presentation.viewmodel.ViewTrendingState

internal fun TrendingFragment.progressDialog(isLoading:Boolean) {

}

internal fun TrendingFragment.showError() {
    fun showLoginOptionsDialog() {
        val materialAlertDialogBuilder =
            MaterialAlertDialogBuilder(
                requireContext(),
                com.google.android.material.R.style.AlertDialog_AppCompat
            )
        materialAlertDialogBuilder
            .setTitle("Ops. Ocorreu um erro")
            .setMessage("Ops. Ocorreu um erro")
            .setIcon(R.drawable.ic_error)
            .setNegativeButton("Tente novamente") { dialog, which ->
                showToast("cancel")
            }

        materialAlertDialogBuilder.show()
    }
}

private fun TrendingFragment.showToast(string: String) {
    Toast.makeText(requireContext(), string, Toast.LENGTH_SHORT).show()
}

