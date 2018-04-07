package comr.example.mana.rytalo.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import comr.example.mana.rytalo.Models.Tags_Table;
import comr.example.mana.rytalo.R;

/**
 * Created by MANA on 4/7/2018.
 */

public class TagsAdapter extends RecyclerView.Adapter<TagsAdapter.TagsHolder>  {
    Context ctx;
    List<Tags_Table> tags;
    View v;
    public TagsAdapter(Context ctx,List<Tags_Table> tags)
    {
        this.ctx=ctx;
        this.tags=tags;
    }


    @Override
    public TagsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        v= LayoutInflater.from(ctx).inflate(R.layout.single_tag,parent,false);
        return new TagsHolder(v);
    }

    @Override
    public void onBindViewHolder(TagsHolder holder, int position) {
     Tags_Table table = tags.get(position);
     holder.tv.setText(table.getTag());
    }

    @Override
    public int getItemCount() {
        return tags.size();
    }

    class TagsHolder extends RecyclerView.ViewHolder{
TextView tv;
        public TagsHolder(View itemView) {
            super(itemView);
            tv= itemView.findViewById(R.id.tags);
        }
    }
}
