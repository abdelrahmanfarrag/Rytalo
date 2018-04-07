package comr.example.mana.rytalo.Models;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;

/**
 * Created by MANA on 4/7/2018.
 */

public class ImagesTable extends RealmObject {
    @PrimaryKey
    private int id;
    private byte[] image;
    @Index
    private int index;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
