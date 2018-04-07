package comr.example.mana.rytalo.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import comr.example.mana.rytalo.Fragments.DraftsFragment;
import comr.example.mana.rytalo.Fragments.PostFragment;

/**
 * Created by MANA on 4/5/2018.
 */

public class PagerAdapter extends FragmentPagerAdapter{


    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0 :
                PostFragment posts = new PostFragment();
                return posts;
            case 1:
                DraftsFragment drafts = new DraftsFragment();
                return drafts;
                default:
                    return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
    public CharSequence getPageTitle(int position)
    {
        switch (position)
        {
            case 0 :
                return "Poster(5)";
            case 1 :
                return "Drafts(3)";
            default:
                return null;
        }

    }
}
