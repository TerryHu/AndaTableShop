package cn.com.andaeshop.ui;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import cn.com.andaeshop.R;

public class OndaWelcomePage extends Activity {

    private static final int TIME_JMP_NEXT_ACT = 3000;
    private Timer mTimer = new Timer();
    // 使用TimerTask方法实现等待跳转
    private TimerTask mTimerTask = new TimerTask() {

        @Override
        public void run() {
            // 设置跳转页面到用户引导界面去
            startApp();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onda_welcomepage_activity);
        intialUIComponent();
    }

    
    /**
     * 初始化UI组件
     */
    private void intialUIComponent() { 
        mTimer.schedule(mTimerTask,TIME_JMP_NEXT_ACT);
    }


    /**
     * 跳转到首页
     */
 
    private void startApp() {
        Intent it = new Intent();
        it.setClass(getApplicationContext(), OndaHomePage.class);

        try {
            startActivity(it);
            this.finish();
            // 设置切换动画，从右边进入，左边退出
            overridePendingTransition(R.anim.onda_in_from_right, R.anim.onda_out_to_left);
        } catch (Exception e) {
            // TODO: handle exception
        }



    }

}
