package cn.com.andaeshop.ui;


import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;
import cn.com.andaeshop.R;
import cn.com.andaeshop.ui.views.AdvViewPager;
import cn.com.andaeshop.utils.Constants;
import cn.com.andaeshop.utils.LogUtils;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

public class OndaMainPageFragment extends Fragment {
    public static OndaMainPageFragment fragmentActivity;
    ImageLoader imageLoader= ImageLoader.getInstance();
    DisplayImageOptions options;
    AdvAdapter mAdvAdapter;
    AdvViewPager mAdvViewPager;
    public static Fragment newInstance(Context context) {
        OndaMainPageFragment f = new OndaMainPageFragment();
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtils.LogE(this.getClass().getName() + ".onCreate", "is Createed");
        fragmentActivity = this;
        //imageLoader=ImageLoader.getInstance();
    }

    @Override
    public void onDestroy() {

        LogUtils.LogE(this.getClass().getName() + ".onDestroy", "is Destroyed");

        super.onDestroy();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        
        imageLoader.init(ImageLoaderConfiguration.createDefault(getActivity()));

        LogUtils.LogE(this.getClass().getName() + ".onCreateView",
                "is onCreateView");

        ViewGroup root = (ViewGroup) inflater.inflate(
                R.layout.onda_home_fragment, container, false);
        intialUiComponent(root);
        return root;
    }

    @Override
    public void onDestroyView() {
        LogUtils.LogE(this.getClass().getName() + ".onDestroyView",
                "is onDestroyView");

        super.onDestroyView();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public void onBack() {
        getParentFragment().getChildFragmentManager().popBackStackImmediate();
    }

    /**
     * 初始化Ui组件
     * 
     * @param root
     */
    private void intialUiComponent(ViewGroup root) {
//        Button button = (Button) root
//                .findViewById(R.id.onda_main_fragment_button);
//        button.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast toast = Toast.makeText(getActivity(),
//                        "main fragment press key", Toast.LENGTH_LONG);
//                toast.setGravity(Gravity.CENTER, 0, 0);
//                toast.show();
//            }
//        });
        
        options = new DisplayImageOptions.Builder()
        .showImageForEmptyUri(R.drawable.onda_ic_empty)
        .showImageOnFail(R.drawable.onda_ic_error)
        .resetViewBeforeLoading(true)
        .cacheOnDisc(true)
        .imageScaleType(ImageScaleType.EXACTLY)
        .bitmapConfig(Bitmap.Config.RGB_565)
        .considerExifParams(true)
        .displayer(new FadeInBitmapDisplayer(300))
        .build();
        LogUtils.LogE("OndaMainFragment intialUiComponent", "  getActivity()="
                +getActivity().toString());
        initalAdViewGrop(root);
    }

    private void initalAdViewGrop(ViewGroup root) {
        RelativeLayout mAdViewGrop = (RelativeLayout) root
                .findViewById(R.id.onda_mainpage_ad);
         mAdvViewPager = (AdvViewPager) mAdViewGrop
                .findViewById(R.id.onda_main_page_ad_viewpager);
//        ViewGroup mIndicator = (ViewGroup) activity
//                .findViewById(R.id.onda_main_page_ad_indicator);
        String[] images = Constants.IMAGES;
        mAdvAdapter = new AdvAdapter(images,getActivity());
        LogUtils.LogE("OndaMainFragment initalAdViewGrop", "  mAdvViewPager="
                +mAdvViewPager.toString());
        LogUtils.LogE("OndaMainFragment initalAdViewGrop", "  mAdvAdapter="
                +mAdvAdapter.toString());
        mAdvViewPager.setAdapter(mAdvAdapter);
        
    }

    /**
     * PageAdapter for AdvViewPager
     * 
     * @author zhoubing
     * 
     */
    private class AdvAdapter extends PagerAdapter {

        private String[] images;
        private LayoutInflater inflater;

        AdvAdapter(String[] images, Activity activity) {
            this.images = images;
            inflater = activity.getLayoutInflater();
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {

            container.removeView((View) object);
        }

        @Override
        public Object instantiateItem(ViewGroup view, int position) {
            View imageLayout = inflater.inflate(R.layout.onda_mainpage_ad_item,
                    view, false);
            assert imageLayout != null;
            ImageView imageView = (ImageView) imageLayout
                    .findViewById(R.id.onda_mainpage_ad_itme_image);
            final ProgressBar spinner = (ProgressBar) imageLayout
                    .findViewById(R.id.onda_mainpage_ad_itme_loading);
            imageLoader.displayImage(images[position], imageView, options,
                    new SimpleImageLoadingListener() {
                        @Override
                        public void onLoadingStarted(String imageUri, View view) {
                            spinner.setVisibility(View.VISIBLE);
                        }

                        @Override
                        public void onLoadingFailed(String imageUri, View view,
                                FailReason failReason) {
                            String message = null;
                            switch (failReason.getType()) {
                            case IO_ERROR:
                                message = "Input/Output error";
                                break;
                            case DECODING_ERROR:
                                message = "Image can't be decoded";
                                break;
                            case NETWORK_DENIED:
                                message = "Downloads are denied";
                                break;
                            case OUT_OF_MEMORY:
                                message = "Out Of Memory error";
                                break;
                            case UNKNOWN:
                                message = "Unknown error";
                                break;
                            }
                            Toast.makeText(getActivity(), message,
                                    Toast.LENGTH_SHORT).show();

                            spinner.setVisibility(View.GONE);
                        }

                        @Override
                        public void onLoadingComplete(String imageUri,
                                View view, Bitmap loadedImage) {
                            spinner.setVisibility(View.GONE);
                        }
                    });

            view.addView(imageLayout, 0);

            return imageLayout;
        }

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view.equals(object);
        }
        @Override
        public void restoreState(Parcelable state, ClassLoader loader) {
        }

        @Override
        public Parcelable saveState() {
            return null;
        }
    }

    public class ViewHolder {
        public ImageView imageViewAD;

    }
}
