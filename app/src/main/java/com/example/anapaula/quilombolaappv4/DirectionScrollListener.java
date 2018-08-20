package com.example.anapaula.quilombolaappv4;

import android.view.View;
import android.widget.AbsListView;

public class DirectionScrollListener implements AbsListView.OnScrollListener {
    private static final int DIRECTION_CHANGE_THRESHOLD = 1;
    private final CustomFloatingActionButton mFloatingActionButton;
    private int mPrevPosition;
    private int mPrevTop;
    private boolean mUpdated;

    DirectionScrollListener(CustomFloatingActionButton floatingActionButton) {
        mFloatingActionButton = floatingActionButton;
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        final View topChild = view.getChildAt(0);
        int firstViewTop = 0;
        if (topChild != null) {
            firstViewTop = topChild.getTop();
        }
        boolean goingDown;
        boolean changed = true;
        if (mPrevPosition == firstVisibleItem) {
            final int topDelta = mPrevTop - firstViewTop;
            goingDown = firstViewTop < mPrevTop;
            changed = Math.abs(topDelta) > DIRECTION_CHANGE_THRESHOLD;
        } else {
            goingDown = firstVisibleItem > mPrevPosition;
        }
        if (changed && mUpdated) {
            mFloatingActionButton.hide(goingDown);
        }
        mPrevPosition = firstVisibleItem;
        mPrevTop = firstViewTop;
        mUpdated = true;
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
    }
}
