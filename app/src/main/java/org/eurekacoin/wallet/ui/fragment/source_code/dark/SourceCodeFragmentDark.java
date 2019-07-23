package com.eurekanetwork.wallet.ui.fragment.source_code.dark;

import android.text.SpannableString;
import android.widget.TextView;

import com.eurekanetwork.wallet.R;
import com.eurekanetwork.wallet.ui.fragment.source_code.SourceCodeFragment;

public class SourceCodeFragmentDark extends SourceCodeFragment {

    @Override
    protected int getLayout() {
        return R.layout.fragment_source_code;
    }

    @Override
    public void initializeViews() {
        super.initializeViews();
        String sourceCode = getArguments().getString(SOURCE_CODE);
        SpannableString spannableSourceCode = formatCode(sourceCode, R.color.code_reserve_word, R.color.code_type, R.color.code_comment);
        mTextView.setText(spannableSourceCode, TextView.BufferType.SPANNABLE);
    }
}
