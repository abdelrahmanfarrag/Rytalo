package comr.example.mana.rytalo.Helpers;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import comr.example.mana.rytalo.Models.Table_Datamodel;
import comr.example.mana.rytalo.Models.Tags_Table;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

/**
 * Created by MANA on 4/5/2018.
 */

public class CommonMethods {
    public static Realm RealmInit(Context ctx)
    {
        Realm.init(ctx);
        RealmConfiguration config = new RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build();
        Realm.setDefaultConfiguration(config);
        Realm realm = Realm.getDefaultInstance();
        return realm;

    }
    public static int setPrimaryKey(Realm realm)
    {
        try
        {return realm.where(Table_Datamodel.class).max("id").intValue() + 1;}
        catch (Exception e)
        {return 0;}
    }
    public static void RecyclerView_Settings(Context context,RecyclerView view)
    {
        view.setLayoutManager(new LinearLayoutManager(context));
        view.setHasFixedSize(true);
    }
    public  static void DeleteAllData(Realm realm,Class c,Context ctx)
    {
        RealmResults<Table_Datamodel> data = CommonMethods.RealmInit(ctx).where(c).findAll();
        realm.beginTransaction();
        data.deleteAllFromRealm();
        realm.commitTransaction();
    }
    public static void ToastMsg(Context ctx,String msg)
    {
        Toast.makeText(ctx,msg,Toast.LENGTH_SHORT).show();
    }




}
