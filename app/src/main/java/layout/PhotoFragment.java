package layout;

import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.tanya.task_8_2.R;

import java.io.IOException;


public class PhotoFragment extends Fragment {
    //
//    ImageView imageView1;
//    ImageView imageView2;
//    ImageView imageView3;
    private String uri;

    public static PhotoFragment newInstance(String param) {
        PhotoFragment fragmentFirst = new PhotoFragment();
       fragmentFirst.setURI(param);
        return fragmentFirst;
    }

    public void setURI(String uri) {
        this.uri = uri;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View itemView = inflater.inflate(R.layout.fragment_photo, container, false);
        ImageView imageView1 = (ImageView) itemView.findViewById(R.id.imageView1);
        try {
            imageView1.setImageBitmap(MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), Uri.parse(uri)));
//            ImageView imageView2 = (ImageView) itemView.findViewById(R.id.imageView2);
//            imageView2.setImageBitmap(MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), Uri.parse("content://media/external/images/media/16950")));
//            ImageView imageView3 = (ImageView) itemView.findViewById(R.id.imageView3);
//            imageView3.setImageBitmap(MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), Uri.parse("content://media/external/images/media/16950")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return itemView;
    }
}
