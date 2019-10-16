package com.zgf.likemeituandianpupage.recycler;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.zgf.likemeituandianpupage.R;

public class TitleDecoration extends RecyclerView.ItemDecoration {

    private PowerGroupListener listener;

    private int titleHeight = 60; // 标题高度

    private Context context;
    private int screenWidth;

    private TitleDecoration(PowerGroupListener listener, Context context) {
        this.listener = listener;

        this.context = context;
        screenWidth = getScreenWidth();
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        int position = parent.getChildAdapterPosition(view);
        int type = getGroupType(position);
        if (type == 0) { // 标题
            outRect.set(0, titleHeight, 0, 0);
        }
    }

    @Override
    public void onDrawOver(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDrawOver(c, parent, state);

        //获取item条数
        int itemCount = state.getItemCount();
        // 获取屏幕上显示的条数
        int childCount = parent.getChildCount();
        //得出距离左边和右边的padding
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();
        //开始绘制
        for (int i = 0; i < childCount; i++) {
            View view = parent.getChildAt(i);
            // 获取当前view实际的position
            int position = parent.getChildAdapterPosition(view);

            if (getGroupType(position) != 0 && i != 0) {
                continue;
            }

            int viewBottom = view.getBottom();
            //top 决定当前顶部第一个悬浮Group的位置
            int top = Math.max(titleHeight, view.getTop());

            if (position + 1 < itemCount) {
                //下一组的第一个View接近头部
                if (getGroupType(position + 1) == 0 && viewBottom < top) {
                    top = viewBottom;
                }
            }

            drawTitle(position, parent, left, right, top, c);
        }
    }

    private void drawTitle(int position, ViewGroup parent, int left, int right, int top, Canvas c) {
        // 绘制悬浮的title
        View groupView = getGroupView(position, parent);

        if (groupView != null) {
            groupView.setBackground(ContextCompat.getDrawable(context, R.color.white));
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, titleHeight);
            groupView.setLayoutParams(layoutParams);
            groupView.setDrawingCacheEnabled(true);
            groupView.measure(
                    View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                    View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
            //指定高度、宽度的groupView
            groupView.layout(0, 0, right, titleHeight);
            groupView.buildDrawingCache();
            Bitmap bitmap = groupView.getDrawingCache();
            c.drawBitmap(bitmap, left, top - titleHeight, null);
        }
    }

    private int getGroupType(int position) {
        if (listener != null) {
            return listener.getGroupType(position);
        } else {
            return -1;
        }
    }

    private View getGroupView(int position, ViewGroup parent) {
        if (listener != null) {
            return listener.getGroupView(position, parent);
        } else {
            return null;
        }
    }

    public int getScreenWidth() {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        return wm.getDefaultDisplay().getWidth();
    }

    public static class Builder {

        private TitleDecoration mDecoration;

        private Builder(PowerGroupListener listener, Context context) {
            mDecoration = new TitleDecoration(listener, context);
        }

        public static Builder init(PowerGroupListener listener, Context context) {
            return new Builder(listener, context);
        }

        public Builder setGroupHeight(int groutHeight) {
            mDecoration.titleHeight = groutHeight;
            return this;
        }

        public TitleDecoration build() {
            return mDecoration;
        }
    }

    public interface PowerGroupListener {
        View getGroupView(int position, ViewGroup parent);

        int getGroupType(int position);
    }
}
