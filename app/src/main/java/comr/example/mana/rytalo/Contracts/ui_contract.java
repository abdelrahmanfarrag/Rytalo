package comr.example.mana.rytalo.Contracts;

import java.util.List;

import comr.example.mana.rytalo.Models.ImagesTable;
import comr.example.mana.rytalo.Models.Table_Datamodel;
import comr.example.mana.rytalo.Models.Tags_Table;

/**
 * Created by MANA on 4/7/2018.
 */

public interface ui_contract {
    void LoadPosts(List<Table_Datamodel> table);
    void Tags(List<Tags_Table> tables);
    void Image(List<ImagesTable> images);


}
