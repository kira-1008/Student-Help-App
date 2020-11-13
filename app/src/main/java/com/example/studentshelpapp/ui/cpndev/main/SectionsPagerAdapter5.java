package com.example.studentshelpapp.ui.cpndev.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.studentshelpapp.R;
import com.example.studentshelpapp.ui.cpndev.judge_cp;
import com.example.studentshelpapp.ui.cpndev.courses_cp;
import com.example.studentshelpapp.ui.cpndev.books_cp;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter5 extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_8,R.string.tab_text_10,R.string.tab_text_11};
    private final Context mContext;

    public SectionsPagerAdapter5(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        switch(position)
        {
            case 0:
                judge_cp Judge_cp = new judge_cp();
                return Judge_cp;
//            case 1:
//                resources_cp resourcesCp = new resources_cp();
//                return resourcesCp;
            case 1:
                courses_cp coursesCp = new courses_cp();
                return coursesCp;
            case 2:
                books_cp booksCp = new books_cp();
                return booksCp;
            default:
                return null;
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 3;
    }
}