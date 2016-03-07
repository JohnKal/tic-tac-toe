package com.jkalimer.tic_tac_toe_project;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.webkit.WebView;

public class LicensesDialogFragment extends DialogFragment {

	public static LicensesDialogFragment newInstance() {
        return new LicensesDialogFragment();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        WebView view = (WebView) LayoutInflater.from(getActivity()).inflate(R.layout.about_webview, null);
        view.loadUrl("file:///android_asset/about_tic_tac_toe.html");
        return new AlertDialog.Builder(getActivity(), R.style.AppTheme)
                .setTitle("About")
                .setView(view)
                .setPositiveButton(android.R.string.ok, null)
                .create();
    }
}
