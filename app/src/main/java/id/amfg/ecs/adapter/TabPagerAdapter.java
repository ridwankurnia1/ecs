package id.amfg.ecs.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import id.amfg.ecs.fragment.ChecksheetFragment;
import id.amfg.ecs.fragment.LaboratoriumFragment;
import id.amfg.ecs.fragment.PatrolFragment;

public class TabPagerAdapter extends FragmentPagerAdapter {
    public TabPagerAdapter(FragmentManager fragmentManager){
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int possition){
        switch (possition) {
            case 0:
                return new ChecksheetFragment();
            case 1:
                return new LaboratoriumFragment();
            case 2:
                return new PatrolFragment();
        }

        return  null;
    }

    @Override
    public int getCount(){
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "CHECK SHEET";
            case 1:
                return "LABORATORIUM";
            case 2:
                return "PATROL";
            default:
                return null;
        }
    }
}
