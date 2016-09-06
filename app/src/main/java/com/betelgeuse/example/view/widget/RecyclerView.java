package com.betelgeuse.example.view.widget;

import android.content.Context;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class RecyclerView extends android.support.v7.widget.RecyclerView implements android.support.v7.widget.RecyclerView.OnItemTouchListener {

    private OnRecyclerViewScrollListener onRecyclerViewScrollListener;
    private GestureDetector gestureDetector;
    private OnItemClickListener onItemClickListener;
    private LayoutManager layoutManager;

    public static final int HORIZONTAL_LAYOUT = HORIZONTAL;
    public static final int VERTICAL_LAYOUT = VERTICAL;


    private boolean isSingleClickAllowed;

    public RecyclerView(Context context) {
        super(context);
        initGestureDetector(context);
    }

    public RecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initGestureDetector(context);
    }

    public RecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initGestureDetector(context);
    }

    private void initGestureDetector(Context context) {
        gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return isSingleClickAllowed;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                super.onLongPress(e);
            }
        });
        addOnItemTouchListener(this);
    }

    public OnRecyclerViewScrollListener getOnRecyclerViewScrollListener() {
        return onRecyclerViewScrollListener;
    }

    public void setOnRecyclerViewScrollListener(OnRecyclerViewScrollListener onRecyclerViewScrollListener) {
        this.onRecyclerViewScrollListener = onRecyclerViewScrollListener;
        addOnScrollListener(new OnScrollListener());
    }

    @Override
    public boolean onInterceptTouchEvent(android.support.v7.widget.RecyclerView recyclerView, MotionEvent motionEvent) {
        View child = findChildViewUnder(motionEvent.getX(), motionEvent.getY());

        if (child != null && onItemClickListener != null && gestureDetector.onTouchEvent(motionEvent)) {
            int position = getChildAdapterPosition(child);
            long id = getChildItemId(child);
            return onItemClickListener.onItemClick(child, position, id);
        }
        return false;
    }

    @Override
    public void onTouchEvent(android.support.v7.widget.RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }

    public OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
        if (onItemClickListener != null) {
            isSingleClickAllowed = true;
        }
    }

    public void setAsListType(@LayoutOrientation final int layoutOrientation) {
        layoutManager = new LinearLayoutManager(getContext());
        ((LinearLayoutManager) layoutManager).setOrientation(layoutOrientation);
        setLayoutManager(layoutManager);
        setHasFixedSize(true);
    }

    public int findFirstCompletelyVisibleItemPosition() {
        return layoutManager instanceof LinearLayoutManager ?
                ((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition() :
                ((GridLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition();
    }


    public int findFirstVisibleItemPosition() {
        return layoutManager instanceof LinearLayoutManager ?
                ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition() :
                ((GridLayoutManager) layoutManager).findFirstVisibleItemPosition();
    }


    public int findLastCompletelyVisibleItemPosition() {
        return layoutManager instanceof LinearLayoutManager ?
                ((LinearLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition() :
                ((GridLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition();
    }

    public int findLastVisibleItemPosition() {
        return layoutManager instanceof LinearLayoutManager ?
                ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition() :
                ((GridLayoutManager) layoutManager).findLastVisibleItemPosition();
    }


    private class OnScrollListener extends android.support.v7.widget.RecyclerView.OnScrollListener {

        @Override
        public void onScrollStateChanged(android.support.v7.widget.RecyclerView recyclerView, int newState) {
            onRecyclerViewScrollListener.onScrollStateChanged(RecyclerView.this, newState);
        }

        @Override
        public void onScrolled(android.support.v7.widget.RecyclerView recyclerView, int dx, int dy) {
            onRecyclerViewScrollListener.onScrolled(RecyclerView.this, dx, dy);
        }
    }

    public interface OnRecyclerViewScrollListener {
        void onScrollStateChanged(RecyclerView recyclerView, int newState);

        void onScrolled(RecyclerView recyclerView, int dx, int dy);
    }


    public interface OnItemClickListener {
        boolean onItemClick(View clickedItemView, int position, long id);

    }

    @IntDef({HORIZONTAL_LAYOUT, VERTICAL_LAYOUT})
    @Retention(RetentionPolicy.SOURCE)
    public @interface LayoutOrientation {
    }
}
