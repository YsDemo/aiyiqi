package aiyiqi.bwf.com.aiyiqi_lf.gui.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;

import java.lang.reflect.Field;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2016/10/21.
 */

public class AutoScrollViewPager extends ViewPager {
    public AutoScrollViewPager(Context context) {
        super(context);
        init();
    }

    public AutoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    /**
     * 利用反射修改滚动时间
     */
    private void init(){
        try {
            Field field = ViewPager.class.getDeclaredField("mScroller");
            field.setAccessible(true);
            Scroller scroller = new Scroller(getContext()){
                @Override
                public void startScroll(int startX, int startY, int dx, int dy, int duration) {
                    super.startScroll(startX, startY, dx, dy, 2000);
                }
            };
            field.set(this,scroller);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void setAdapter(final PagerAdapter adapter) {
        super.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return adapter.getCount();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return adapter.isViewFromObject(view,object);
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                return adapter.instantiateItem(container, position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                adapter.destroyItem(container, position, object);
            }
        });
        setCurrentItem(Integer.MAX_VALUE/2-(Integer.MAX_VALUE/2)%adapter.getCount());
        startAutoscroll();
    }
    private Timer timer = new Timer();
    private TimerTask timerTask;

    public void startAutoscroll(){
        if(timerTask == null){
            timerTask = new TimerTask() {
                @Override
                public void run() {
                    nextPage();
                }
            };
            timer.schedule(timerTask,2000,2000);
        }
    }
    /**切换到下一页**/
    public void nextPage(){
        post(new Runnable() {
            @Override
            public void run() {
                setCurrentItem(getCurrentItem()+1);
            }
        });
    }

    /**
     * 停止自动滚动
     */
    public void stopAutoscroll(){
        if(timerTask != null){
            timerTask.cancel();
            timerTask = null;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_MOVE:
                stopAutoscroll();
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                startAutoscroll();
                break;
        }
        return super.onTouchEvent(ev);
    }
}
