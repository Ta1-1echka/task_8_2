package com.tanya.task_8_2;

import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import adapter.SimplePagerAdapter;

public class MainActivity extends AppCompatActivity {

    MyViewPager viewPager;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (MyViewPager) findViewById(R.id.viewpager);
        final SimplePagerAdapter adapter = new SimplePagerAdapter(getSupportFragmentManager(), loadPhotos());
        viewPager.setAdapter(adapter);
        viewPager.setPadding(50, 0, 50, 0);
        viewPager.setClipToPadding(false);

        viewPager.setPageMargin(-570);
        viewPager.setPageTransformer(false, new MyPagerTransformer());

    }

    private List<String> loadPhotos() {
        List<String> images = new ArrayList<>();
        String[] projection = {MediaStore.Images.Media._ID};
        String selection = "";
        String[] selectionArgs = null;
        Cursor mImageCursor = managedQuery(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                projection, selection, selectionArgs, null);
        if (mImageCursor != null) {
            int i = 0;
            mImageCursor.moveToFirst();
            do {
                Uri uri = Uri.withAppendedPath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, Integer.toString(Integer.valueOf(mImageCursor.getString(0))));
                images.add(uri.toString());
                i++;
            } while (i < 4 & mImageCursor.moveToNext());
        }
        return images;
    }

    class MyPagerTransformer implements ViewPager.PageTransformer {
        private static final float MIN_SCALE = 0.85f;
        private static final float MIN_ALPHA = 0.5f;

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public void transformPage(View view, float position) {
            System.out.println(position);
            int pageWidth = view.getWidth();
            int pageHeight = view.getHeight();

            if (position < -1) {
                view.setAlpha(0);

            } else if (position <= 1) {
                float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
                float vertMargin = pageHeight * (1 - scaleFactor) / 2;
                float horzMargin = pageWidth * (1 - scaleFactor) / 2;


                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

            } else {
                view.setAlpha(0);
            }
//            }
//            view.setTranslationZ(position < 0 ? 0f : view.getWidth());

        }
    }
}
