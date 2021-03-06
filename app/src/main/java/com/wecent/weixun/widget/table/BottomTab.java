package com.wecent.weixun.widget.table;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wecent.weixun.R;
import com.wecent.weixun.utils.SizeUtils;

public class BottomTab extends LinearLayout {

    private Context mContext;
    private ImageView mImageView;
    private TextView mTextView;
    private int mTabPosition = -1;

    public BottomTab(Context context, @DrawableRes int icon, String title) {
        this(context, null, icon,  title);
    }

    public BottomTab(Context context, AttributeSet attrs, int icon, String title) {
        this(context, attrs, 0, icon, title);
    }

    public BottomTab(Context context, AttributeSet attrs, int defStyleAttr, int icon, String title) {
        super(context, attrs, defStyleAttr);
        init(context, icon, title);
    }

    private void init(Context context, int icon, String title) {
        mContext = context;
       /* TypedArray typedArray = context.obtainStyledAttributes(new int[]{R.attr.selectableItemBackgroundBorderless});
        Drawable drawable = typedArray.getDrawable(0);
        setBackgroundDrawable(drawable);
        typedArray.recycle();*/

        setOrientation(LinearLayout.VERTICAL);
        mImageView = new ImageView(context);
        int size = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics());
        LayoutParams imageViewParams = new LayoutParams(size, size);
        imageViewParams.gravity = Gravity.CENTER_HORIZONTAL;
        imageViewParams.topMargin = SizeUtils.dp2px(3.5f);
        mImageView.setImageResource(icon);
        mImageView.setLayoutParams(imageViewParams);

        // mIcon.setColorFilter(ContextCompat.getColor(context, R.color.tab_unselect));
        LayoutParams textViewParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        textViewParams.gravity = Gravity.CENTER_HORIZONTAL;
        // textViewParams.addRule(ALIGN_PARENT_BOTTOM);
//        textViewParams.topMargin = ContextUtils.dip2px(context, 2.5f);
        textViewParams.bottomMargin = SizeUtils.dp2px(3.5f);
        mTextView = new TextView(context);
        mTextView.setText(title);
        mTextView.setTextSize(SizeUtils.dp2px(3.5f));
        mTextView.setLayoutParams(textViewParams);
        mTextView.setTextColor(ContextCompat.getColor(mContext, R.color.color_table));
        addView(mImageView);
        addView(mTextView);
    }

    @Override
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        if (selected) {
            mImageView.setColorFilter(ContextCompat.getColor(mContext, R.color.config_color_blue));
            mTextView.setTextColor(ContextCompat.getColor(mContext, R.color.config_color_blue));
        } else {
            mImageView.setColorFilter(ContextCompat.getColor(mContext, R.color.color_table));
            mTextView.setTextColor(ContextCompat.getColor(mContext, R.color.color_table));
        }
    }

    public void setTabPosition(int position) {
        mTabPosition = position;
        if (position == 0) {
            setSelected(true);
        }
    }

    public int getTabPosition() {
        return mTabPosition;
    }
}
