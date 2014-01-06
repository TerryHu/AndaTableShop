package cn.com.andaeshop.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import cn.com.andaeshop.R;

public class OndaHomePage extends FragmentActivity implements
		View.OnClickListener {
	private TextView mTitleBarMainPageBtn;
	private TextView mTitleBarCategoryBtn;
	private TextView mTitleBarShopCartBtn;
	private TextView mTitlePersonalCenterBtn;
	private Button mTitleFastSearchBtn;
	private Context mContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.onda_home_activity);
		intial();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.onda_mainframepage:
			showMainPageFragment();
			Toast.makeText(this, "点击了首页", Toast.LENGTH_SHORT).show();
			break;
		case R.id.onda_category_pop_menu:
			Toast.makeText(this, "点击了分类", Toast.LENGTH_SHORT).show();
			break;
		case R.id.onda_shopping_cart_framepage:
			showShoppingCartFragment();
			Toast.makeText(this, "点击了购物车", Toast.LENGTH_SHORT).show();
			break;
		case R.id.onda_personal_center_framepage:
			Toast.makeText(this, "点击了个人中心", Toast.LENGTH_SHORT).show();
			break;
		case R.id.onda_fast_search_btn:
			Toast.makeText(this, "点击了快速搜索", Toast.LENGTH_SHORT).show();
			break;
		default:
			break;
		}

	}

	/**
	 * 初始化
	 */
	private void intial() {
		intialFiledVariable();
		intialUiComponent();
	}

	/**
	 * 初始化全局变量
	 */
	private void intialFiledVariable() {
		mContext = OndaHomePage.this;

	}

	/**
	 * 初始化UI控件
	 */
	private void intialUiComponent() {
		intialOndaTitleBarUiComponent();
		showMainPageFragment();
	}

	/**
	 * 显示mainfragement
	 */
	private void showMainPageFragment() {
		Fragment f = new Fragment();
		f = OndaMainPageFragment.newInstance(mContext);
		changePageView(f);
	}

	private void showShoppingCartFragment() {
		Fragment f = new Fragment();
		f = OndaShoppingCartFragment.newInstance(mContext);
		changePageView(f);
	}

	/**
	 * 更换页面内容
	 * 
	 * @param f
	 */
	public void changePageView(Fragment f) {
		FragmentManager manager = getSupportFragmentManager();
		FragmentTransaction ft = manager.beginTransaction();
		ft.replace(R.id.on_content_fragment_container, f);
		ft.commit();

	}

	/**
	 * 初始化title bar控件
	 */
	private void intialOndaTitleBarUiComponent() {
		mTitleBarMainPageBtn = (TextView) findViewById(R.id.onda_mainframepage);
		mTitleBarCategoryBtn = (TextView) findViewById(R.id.onda_category_pop_menu);
		mTitleBarShopCartBtn = (TextView) findViewById(R.id.onda_shopping_cart_framepage);
		mTitlePersonalCenterBtn = (TextView) findViewById(R.id.onda_personal_center_framepage);
		mTitleFastSearchBtn = (Button) findViewById(R.id.onda_fast_search_btn);

		mTitleBarMainPageBtn.setOnClickListener(this);
		mTitleBarCategoryBtn.setOnClickListener(this);
		mTitleBarShopCartBtn.setOnClickListener(this);
		mTitlePersonalCenterBtn.setOnClickListener(this);
		mTitleFastSearchBtn.setOnClickListener(this);
	}

}
