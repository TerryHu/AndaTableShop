package cn.com.andaeshop.ui;


import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import cn.com.andaeshop.R;
import android.view.View;

public class OndaShopTitleView extends RelativeLayout {
//    private TextView mMainPageBtn;
//    private TextView mCategoryBtn;
//    private TextView mShopCartBtn;
//    private TextView mPersonalCenterBtn;
    private Context mContext;
    public OndaShopTitleView(Context context) {
        super(context);
        mContext = context;
    }
    public OndaShopTitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
       
        mContext = context;
 
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.onda_shop_title_view, this);
        //不能按下面这么写 会报空指针
        //intialUiComponent();
 
    }
    

    /**
     * 初始化ui控件
     */
//    private void intialUiComponent() {
//        mMainPageBtn = (TextView)findViewById(R.id.onda_mainframepage);
//        mCategoryBtn=(TextView)findViewById(R.id.onda_category_pop_menu);
//        mShopCartBtn =(TextView)findViewById(R.id.onda_shopping_cart_framepage);
//        mPersonalCenterBtn =(TextView)findViewById(R.id.onda_personal_center_framepage);
//        
//        mMainPageBtn.setOnClickListener(this);
//        mCategoryBtn.setOnClickListener(this);
//        mShopCartBtn.setOnClickListener(this);
//        mPersonalCenterBtn.setOnClickListener(this);
//    }
    
 //   @Override
//    protected void onFinishInflate() {
//        intialUiComponent();
//        
//        
//        super.onFinishInflate();
//    }
 //   @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//        case R.id.onda_mainframepage:
//            Toast.makeText(mContext, "点击了首页", Toast.LENGTH_SHORT).show();
//            break;
//        case R.id.onda_category_pop_menu:
//            Toast.makeText(mContext, "点击了分类", Toast.LENGTH_SHORT).show();
//        break;
//        case R.id.onda_shopping_cart_framepage:
//            Toast.makeText(mContext, "点击了购物车", Toast.LENGTH_SHORT).show();            
//        break;
//        case R.id.onda_personal_center_framepage:
//            Toast.makeText(mContext, "点击了个人中心", Toast.LENGTH_SHORT).show();             
//        break;
//        default:
//            break;
//        }
//
//    }

}
