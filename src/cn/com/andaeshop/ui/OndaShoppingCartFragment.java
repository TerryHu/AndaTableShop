package cn.com.andaeshop.ui;

import cn.com.andaeshop.R;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class OndaShoppingCartFragment extends Fragment {
    public static OndaShoppingCartFragment fragmentActivity;
    public static Fragment newInstance(Context context){
        OndaShoppingCartFragment f = new OndaShoppingCartFragment();
        return f;       
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentActivity = this;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        ViewGroup root =(ViewGroup) inflater.inflate(R.layout.onda_shop_cart_fragment,container, false);
        intialUiComponent(root);
        return root;
        
    }
    

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        Button button = (Button) getActivity().findViewById(
//                R.id.onda_shop_cart_fragment_button);
//        button.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getActivity(), "fragment press key",
//                        Toast.LENGTH_LONG).show();
//            }
//        });
    }
    
    
    public void onBack() {
        getParentFragment().getChildFragmentManager().popBackStackImmediate();
    }
    
    private void intialUiComponent(ViewGroup root) {
        Button button = (Button) root.findViewById(R.id.onda_shop_cart_fragment_button);
        button.setOnClickListener(new OnClickListener() {            
            @Override
            public void onClick(View v) {
               Toast toast =Toast.makeText(getActivity(), "Shopping Cart fragment press key", Toast.LENGTH_LONG);
               toast.setGravity(Gravity.CENTER, 0, 0);
               toast.show();
            }
        });
    }
}
