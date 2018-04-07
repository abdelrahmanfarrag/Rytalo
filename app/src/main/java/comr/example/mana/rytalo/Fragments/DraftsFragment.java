package comr.example.mana.rytalo.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import comr.example.mana.rytalo.R;

/**
 * Created by MANA on 4/5/2018.
 */

public class DraftsFragment extends Fragment {
    View v;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.draft_fragment,container,false);

return v;
    }
}
