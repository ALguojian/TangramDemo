package com.alguojian.tangramdemo;

import android.app.Application;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.tmall.wireless.tangram.TangramBuilder;
import com.tmall.wireless.tangram.util.IInnerImageSetter;

/**
 * ${Descript}
 *
 * @author alguojian
 * @date 2018/9/5
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //第一步，先注册tangran
        TangramBuilder.init(this, new IInnerImageSetter() {
            @Override
            public <IMAGE extends ImageView> void doLoadImageUrl(@NonNull IMAGE view, @Nullable String url) {

                Picasso.get().load(url).into(view);
            }
        },ImageView.class);
    }
}
