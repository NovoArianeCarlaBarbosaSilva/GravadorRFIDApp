package com.concert.sierfgravador.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.concert.sierfgravador.R;
import com.concert.sierfgravador.activities.MainActivity;
import com.concert.sierfgravador.fragments.DeleteFragment;
import com.concert.sierfgravador.fragments.EditAllFragment;
import com.concert.sierfgravador.fragments.EditFragment;
import com.concert.sierfgravador.fragments.KillFragment;
import com.concert.sierfgravador.fragments.ReadFragment;
import com.concert.sierfgravador.fragments.WriteAllFragment;
import com.concert.sierfgravador.fragments.WriteFragment;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2, R.string.tab_text_3, R.string.tab_text_4, R.string.tab_text_5};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;

        if(MainActivity.restrictedMode) {
            switch (position) {
                case 0:
                    fragment = new ReadFragment();
                    break;
                case 1:
                    fragment = new EditAllFragment();
                    break;
                case 2:
                    fragment = new WriteAllFragment();
                    break;
                case 3:
                    fragment = new DeleteFragment();
                    break;
                case 4:
                    fragment = new KillFragment();
                    break;
            }
        } else {
            switch (position) {
                case 0:
                    fragment = new ReadFragment();
                    break;
                case 1:
                    fragment = new EditFragment();
                    break;
                case 2:
                    fragment = new WriteFragment();
                    break;
            }
        }

        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Modo restrito
        if(MainActivity.restrictedMode)
            return 5;
        // Modo padrão
        else
            return 3;
    }
}