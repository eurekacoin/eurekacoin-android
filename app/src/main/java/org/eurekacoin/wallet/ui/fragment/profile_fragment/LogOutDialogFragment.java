package com.eurekanetwork.wallet.ui.fragment.profile_fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

public class LogOutDialogFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        return new AlertDialog
                .Builder(getActivity())
                .setTitle(com.eurekanetwork.wallet.R.string.are_you_sure)
                .setPositiveButton(com.eurekanetwork.wallet.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        OnYesClickListener onYesClickListener = (OnYesClickListener) getTargetFragment();
                        onYesClickListener.onClick();
                    }
                })
                .setNegativeButton(com.eurekanetwork.wallet.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dismiss();
                    }
                })
                .create();
    }

    public interface OnYesClickListener {
        void onClick();
    }
}
