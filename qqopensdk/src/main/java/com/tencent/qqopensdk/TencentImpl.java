package com.tencent.qqopensdk;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

public class TencentImpl {
    private Context mContext;
    private Tencent mTencent;

    public TencentImpl(Context context, String authority) {
        mContext = context;
        mTencent = Tencent.createInstance("222222", context, authority);
    }

    public void share(Activity activity, Bundle params) {
        mTencent.shareToQQ(activity, params, mListener);
    }

    public int login(Activity activity, String scope) {
        return mTencent.login(activity, scope, mListener);
    }

    IUiListener mListener = new IUiListener() {
        @Override
        public void onCancel() {
            toastMessage("onCancel: ");
        }

        @Override
        public void onComplete(Object response) {
            toastMessage("onComplete: " + response.toString());
        }

        @Override
        public void onError(UiError e) {
            toastMessage("onError: " + e.errorMessage);
        }
    };

    private void toastMessage(String text) {
        Toast.makeText(mContext, text, Toast.LENGTH_SHORT).show();
    }
}
