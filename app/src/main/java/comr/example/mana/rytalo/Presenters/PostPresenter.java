package comr.example.mana.rytalo.Presenters;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import comr.example.mana.rytalo.Contracts.ui_contract;
import comr.example.mana.rytalo.Helpers.CommonMethods;
import comr.example.mana.rytalo.Models.ImagesTable;
import comr.example.mana.rytalo.Models.Table_Datamodel;
import comr.example.mana.rytalo.Models.Tags_Table;
import comr.example.mana.rytalo.R;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

/**
 * Created by MANA on 4/5/2018.
 */

public class PostPresenter {
    Context ctx;
    ui_contract contract;
    List<Table_Datamodel> datamodels = new ArrayList<>();
    List<Tags_Table> tags_model = new ArrayList<>();
    List<ImagesTable> images_model = new ArrayList<>();

    public PostPresenter(Context ctx,ui_contract contract)
    {
        this.ctx=ctx;
        this.contract=contract;
    }
//* A method used for Inserting  Posts to Posts Table *//

    public void setDataToDatabase(Realm realm,String title,String location,String salary,String job_status,String tag)
    {
     Table_Datamodel insertJob = new Table_Datamodel();
     insertJob.setJobTitle(title);
     insertJob.setLocation(location);
     insertJob.setSalary(salary);
     insertJob.setStatus(job_status);
     insertJob.setId(CommonMethods.setPrimaryKey(realm));
     insertTags(realm,insertJob.getId(),tag);
     storeImages(realm,insertJob.getId());
     realm.beginTransaction();
     realm.copyToRealm(insertJob);
     realm.commitTransaction();
    }
    //* A method used for insert tags to tags Table *//

    private  void insertTags(Realm realm,int index,String tag)
    {
        Tags_Table insertTags = new Tags_Table();
        insertTags.setTag(tag);
        insertTags.setId(CommonMethods.setPrimaryKey(realm));
        insertTags.setIndex(index);
        realm.beginTransaction();
        realm.copyToRealm(insertTags);
        realm.commitTransaction();
    }
//* A method used for select all Posts from Posts Table *//

    public void LoadData()
    {
        RealmResults<Table_Datamodel> data = CommonMethods.RealmInit(ctx).where(Table_Datamodel.class).findAll();
        data.load();
        for (Table_Datamodel model:data)
        {
            datamodels.add(model);

        }
        contract.LoadPosts(datamodels);
    }
//* A method used for select all tags from Tags Table *//
    public void selectAllTags()
    {
        RealmResults<Tags_Table> data = CommonMethods.RealmInit(ctx).where(Tags_Table.class).distinct("index").findAll();
        data.load();
        for (Tags_Table table:data)
        {
            tags_model.add(table);
        }
        contract.Tags(tags_model);


    }
    //* A Method is used for inserting images inside Realm Database (Images Table)
    private void storeImages(Realm realm,int index)
    {
        Resources res = ctx.getResources();
        Drawable drawable = res.getDrawable(R.mipmap.sample);
        Bitmap bitmap = ((BitmapDrawable)drawable).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte[] bitmapdata = stream.toByteArray();
        ImagesTable insert_Image = new ImagesTable();
        insert_Image.setImage(bitmapdata);
        insert_Image.setIndex(index);
        insert_Image.setId(CommonMethods.setPrimaryKey(realm));
        realm.beginTransaction();
        realm.copyToRealm(insert_Image);
        realm.commitTransaction();
    }
    public void selectAllImages()
    {
        RealmResults<ImagesTable> data = CommonMethods.RealmInit(ctx).where(ImagesTable.class).distinct("index").findAll();
        data.load();

        for (ImagesTable table:data)
        {
            images_model.add(table);
        }
        contract.Image(images_model);

    }
    public long getImagesCount ()
    {


        long data = CommonMethods.RealmInit(ctx).where(ImagesTable.class).distinct("index").count();
        return data;


    }

}
