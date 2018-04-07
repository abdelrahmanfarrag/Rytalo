package comr.example.mana.rytalo.Models;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;

/**
 * Created by MANA on 4/7/2018.
 */

public class Tags_Table extends RealmObject {
    @PrimaryKey
    private int id;
    private String tag;
    @Index
    private int index;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTag() {
        return tag;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    }

