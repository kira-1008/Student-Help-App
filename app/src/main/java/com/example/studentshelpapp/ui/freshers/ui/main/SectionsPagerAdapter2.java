package com.example.studentshelpapp.ui.freshers.ui.main;
import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.studentshelpapp.R;
import com.example.studentshelpapp.ui.freshers.others;
import com.example.studentshelpapp.ui.freshers.pharmacy;
import com.example.studentshelpapp.ui.freshers.stationary;

public class SectionsPagerAdapter2 extends FragmentPagerAdapter
{
    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_3, R.string.tab_text_4, R.string.tab_text_5};
    private final Context mContext;

    public SectionsPagerAdapter2(Context context, FragmentManager fm) {
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
                stationary stat = new stationary();
                return stat;
            case 1:
                pharmacy phar = new pharmacy();
                return phar;
            case 2:
                others oth = new others();
                return oth;
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
