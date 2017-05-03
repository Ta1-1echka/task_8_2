package adapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.tanya.task_8_2.R;

import java.io.IOException;
import java.util.List;

import layout.PhotoFragment;

/**
 * Created by Ta1-1 on 02.05.2017.
 */

public class SimplePagerAdapter extends FragmentPagerAdapter {

    public static int LOOPS_COUNT = 1000;
    private FragmentManager fm;
    private List<String> uriPhoto;
    LayoutInflater layoutInflater;

    public SimplePagerAdapter(FragmentManager fm, List<String> uriPhoto) {
        super(fm);
        this.fm = fm;
        this.uriPhoto = uriPhoto;
    }

    @Override
    public Fragment getItem(int position) {
        if (uriPhoto != null && uriPhoto.size() > 0)
        {
            position = position % uriPhoto.size(); // use modulo for infinite cycling
            return PhotoFragment.newInstance(uriPhoto.get(position));
        }
        else
        {
            return null;
        }
    }

    @Override
    public int getCount() {
        if (uriPhoto != null && uriPhoto.size() > 0)
        {
            return uriPhoto.size()*LOOPS_COUNT; // simulate infinite by big number of products
        }
        else
        {
            return 1;
        }
    }

//    @Override
//    public float getPageWidth(int position) {
//        return 0.5f;
//    }

    //    public SimplePagerAdapter(FragmentManager fm,List<String> uriPhoto) {
//        super(fm);
//        this.fm = fm;
//        this.uriPhoto = uriPhoto;
//    }
//
//
//    @Override
//    public int getCount() {
//
//        return (uriPhoto == null) ? 0 : uriPhoto.size();
//    }
//
////    @Override
////    public boolean isViewFromObject(View view, Object object) {
////        return view == object;
////    }
//
//    @Override
//    public Fragment getItem(int position) {
//        PhotoFragment.newInstance();
//        return null;
//    }

//    @Override
//    public Object instantiateItem(ViewGroup viewGroup, int position) {
////        View itemView = layoutInflater.inflate(R.layout.fragment_photo, viewGroup, false);
////        try {
////            ImageView imageView1 = (ImageView) itemView.findViewById(R.id.imageView1);
////            imageView1.setImageBitmap(MediaStore.Images.Media.getBitmap(mContext.getContentResolver(), Uri.parse("content://media/external/images/media/16950")));
////            ImageView imageView2 = (ImageView) itemView.findViewById(R.id.imageView2);
////            imageView2.setImageBitmap(MediaStore.Images.Media.getBitmap(mContext.getContentResolver(), Uri.parse("content://media/external/images/media/16950")));
////            ImageView imageView3 = (ImageView) itemView.findViewById(R.id.imageView3);
////            imageView3.setImageBitmap(MediaStore.Images.Media.getBitmap(mContext.getContentResolver(), Uri.parse("content://media/external/images/media/16950")));
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////        viewGroup.addView(itemView);
//        return viewGroup;
//    }
}
