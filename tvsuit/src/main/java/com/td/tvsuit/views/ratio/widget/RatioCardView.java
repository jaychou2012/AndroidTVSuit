/*
 * <pre>
 * Copyright 2015 The Android Open Source Project for Android-RatioLayout
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </pre>
 */
package com.td.tvsuit.views.ratio.widget;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;

import com.td.tvsuit.views.ratio.RatioDatumMode;
import com.td.tvsuit.views.ratio.RatioLayoutDelegate;
import com.td.tvsuit.views.ratio.RatioMeasureDelegate;

public class RatioCardView extends CardView implements RatioMeasureDelegate {

    private RatioLayoutDelegate mRatioLayoutDelegate;

    public RatioCardView(Context context) {
        super(context);
    }

    public RatioCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mRatioLayoutDelegate = RatioLayoutDelegate.obtain(this, attrs);
    }

    public RatioCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mRatioLayoutDelegate = RatioLayoutDelegate.obtain(this, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (mRatioLayoutDelegate != null) {
            mRatioLayoutDelegate.update(widthMeasureSpec, heightMeasureSpec);
            widthMeasureSpec = mRatioLayoutDelegate.getWidthMeasureSpec();
            heightMeasureSpec = mRatioLayoutDelegate.getHeightMeasureSpec();
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public void setRatio(RatioDatumMode mode, float datumWidth, float datumHeight) {
        if (mRatioLayoutDelegate != null) {
            mRatioLayoutDelegate.setRatio(mode, datumWidth, datumHeight);
        }
    }

    @Override
    public void setSquare(boolean square) {
        if (mRatioLayoutDelegate != null) {
            mRatioLayoutDelegate.setSquare(square);
        }
    }

    @Override
    public void setAspectRatio(float aspectRatio) {
        if (mRatioLayoutDelegate != null) {
            mRatioLayoutDelegate.setAspectRatio(aspectRatio);
        }
    }
}
