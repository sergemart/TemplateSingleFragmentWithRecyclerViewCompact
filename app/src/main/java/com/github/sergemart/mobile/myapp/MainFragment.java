package com.github.sergemart.mobile.myapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.github.sergemart.mobile.myapp.data.Repository;


public class MainFragment extends Fragment {

    private RecyclerView mRecyclerView;


    // --------------------------- Override fragment event handlers

    /**
     * View-unrelated startup actions
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setHasOptionsMenu(true);                                                               // tell the fragment manager that this.onCreateOptionsMenu() should be called
    }


    /**
     * View-related startup actions
     * @return Inflated content view of the fragment
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_list, container, false);

        this.initMemberVariables(fragmentView);
        this.setAttributes();
        this.setListeners();

        return fragmentView;
    }


    /**
     * Inflate the menu
     */
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);                                                  // useless here, but is a good rule
        inflater.inflate(R.menu.fragment_main, menu);
    }


    /**
     * Process menu item selection
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch ( item.getItemId() ) {
            case R.id.menuItem_action:
                return true;                                                                        // no further processing needed

            default:
                return super.onOptionsItemSelected(item);                                           // unknown item id - call parent
        }
    }


    // --------------------------- Widget controls

    /**
     * Init member variables
     */
    private void initMemberVariables(View fragmentView) {
        mRecyclerView = fragmentView.findViewById(R.id.recyclerView_list);
    }


    /**
     * Set attributes
     */
    private void setAttributes() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager( this.getActivity() ));              // set up the RecyclerView
        this.setupAdapter();
    }


    /**
     * Set listeners to widgets and containers
     */
    private void setListeners() {
    }


    // --------------------------- Subroutines

    /**
     * Set a new Adapter instance loaded with a displayed collection into the member Recycler View
     */
    private void setupAdapter() {
        mRecyclerView.setAdapter(new MainItemAdapter( this.getActivity(), Repository.get().getItems() ));
    }


    // --------------------------- Static encapsulation-leveraging methods

    /**
     * Create MainFragment instance
     */
    public static MainFragment newInstance() {
        return new MainFragment();
    }


}
