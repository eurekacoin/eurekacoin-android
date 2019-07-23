package com.eurekanetwork.wallet.ui.fragment.news_detail_fragment.tag_view_holders;

import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;

import org.jsoup.nodes.Element;
import com.eurekanetwork.wallet.R;
import com.eurekanetwork.wallet.utils.FontTextView;

import butterknife.BindView;

public class TagPViewHolder extends TagViewHolder {

    @BindView(R.id.tv_tag_p)
    FontTextView mTextView;

    public TagPViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bindElement(Element element) {
        mTextView.setText(Html.fromHtml(element.html()));
        mTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
