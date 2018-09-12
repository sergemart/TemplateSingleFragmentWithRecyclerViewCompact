package com.github.sergemart.mobile.myapp.activities;

import android.support.v4.app.Fragment;

import com.github.sergemart.mobile.myapp.ui.MainFragment;
import com.github.sergemart.mobile.myapp.R;


public class MainActivity extends GenericActivity {

    // --------------------------- Implement generic abstracts

    /**
     * Specifies an activity layout
     */
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_one_pane;
    }


    /**
     *  Specifies a fragment to use in the parent activity
     */
    @Override
    protected Fragment createFragment() {
        return MainFragment.newInstance();
    }
}
