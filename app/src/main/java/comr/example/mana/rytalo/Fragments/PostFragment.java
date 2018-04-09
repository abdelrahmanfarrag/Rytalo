package comr.example.mana.rytalo.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import comr.example.mana.rytalo.Adapters.Posts_Adapter;
import comr.example.mana.rytalo.Contracts.ui_contract;
import comr.example.mana.rytalo.Helpers.CommonMethods;
import comr.example.mana.rytalo.Models.ImagesTable;
import comr.example.mana.rytalo.Models.Table_Datamodel;
import comr.example.mana.rytalo.Models.Tags_Table;
import comr.example.mana.rytalo.Presenters.PostPresenter;
import comr.example.mana.rytalo.R;
import io.realm.Realm;


/**
 * Created by MANA on 4/5/2018.
 */

public class PostFragment extends Fragment implements ui_contract {
    View v;
    Realm realm;
    RecyclerView posts;
    PostPresenter presenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v= inflater.inflate(R.layout.post_fragment,container,false);
        presenter= new PostPresenter(getActivity(),this);
        realm = CommonMethods.RealmInit(getActivity());
    presenter.setDataToDatabase(realm,"PHOTOGRAPHS SEVERAL SELECTED LOCATIONS","NEW YORK","Fixed = $250.00",
               "Job Open","Fixed");
        presenter.setDataToDatabase(realm,"Videograph Special Events","Los Angelos","Hourly = $22.00",
                "In Review","Hourly");
        presenter.setDataToDatabase(realm,"PHOTOGRAPHS SEVERAL SELECTED LOCATIONS","NEW YORK","Fixed = $250.00",
                "Job Open","Fixed");

        posts= v.findViewById(R.id.posts_view);
   /*     CommonMethods.DeleteAllData(realm,ImagesTable.class,getActivity());
        CommonMethods.DeleteAllData(realm,Table_Datamodel.class,getActivity());
        CommonMethods.DeleteAllData(realm,Tags_Table.class,getActivity());*/

        CommonMethods.RecyclerView_Settings(getActivity(),posts);



        presenter.LoadData();
        return v;
    }
    @Override
    public void LoadPosts(List<Table_Datamodel> table) {
        posts.setAdapter(new Posts_Adapter(getActivity(),table));
    }
    @Override
    public void Tags(List<Tags_Table> tables) {

    }

    @Override
    public void Image(List<ImagesTable> images) {

    }


}
