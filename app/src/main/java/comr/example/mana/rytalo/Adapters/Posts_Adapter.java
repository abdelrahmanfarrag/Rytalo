package comr.example.mana.rytalo.Adapters;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import comr.example.mana.rytalo.Contracts.ui_contract;
import comr.example.mana.rytalo.Models.ImagesTable;
import comr.example.mana.rytalo.Models.Table_Datamodel;
import comr.example.mana.rytalo.Models.Tags_Table;
import comr.example.mana.rytalo.Presenters.PostPresenter;
import comr.example.mana.rytalo.R;

/**
 * Created by MANA on 4/7/2018.
 */

public class Posts_Adapter extends RecyclerView.Adapter<Posts_Adapter.Posts_Holder> implements ui_contract {
    View v;
    Context ctx;
    Posts_Holder holder;
    PostPresenter presenter ;

    List<Table_Datamodel> post_data = new ArrayList<>();
    public Posts_Adapter(Context ctx,List<Table_Datamodel> post_data)
    {
        this.ctx=ctx;
        this.post_data=post_data;
    }
    @Override
    public Posts_Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        v= LayoutInflater.from(ctx).inflate(R.layout.single_post_item,parent,false);
        holder = new Posts_Holder(v);
        presenter= new PostPresenter(ctx,this);
        presenter.selectAllTags();
        presenter.selectAllImages();

        return holder;
    }

    @Override
    public void onBindViewHolder(Posts_Holder holder, int position) {
        Table_Datamodel posts_list = post_data.get(position);
        if (position %2==0)
        {
            holder.price_view.setBackgroundColor(ctx.getColor(R.color.green));
            holder.price_view.setText(posts_list.getSalary());
            holder.post_status.setText(posts_list.getStatus());
            holder.post_status.setTextColor(ctx.getColor(R.color.job_open));
        }
        else {
            holder.price_view.setBackgroundColor(ctx.getColor(R.color.blue));
            holder.price_view.setText(posts_list.getSalary());
            holder.post_status.setText(posts_list.getStatus());
            holder.post_status.setTextColor(ctx.getColor(R.color.job_inreview));
        }
        holder.post_location.setText(posts_list.getLocation());
        holder.post_desc.setText(posts_list.getJobTitle());
    }

    @Override
    public int getItemCount() {
        return post_data.size();
    }
    @Override
    public void LoadPosts(List<Table_Datamodel> table) {

    }
    @Override
    public void Tags(List<Tags_Table> tables) {
    holder.tags.setAdapter(new TagsAdapter(ctx,tables));

    }

    @Override
    public void Image(List<ImagesTable> images) {
        holder.images.setAdapter(new ImagesAdapter(ctx,images));
    }

    class Posts_Holder extends RecyclerView.ViewHolder{
        TextView price_view,post_desc,post_location,post_status;
        RecyclerView tags,images;

        public Posts_Holder(View itemView) {
            super(itemView);
            price_view=itemView.findViewById(R.id.price);
            post_desc=itemView.findViewById(R.id.job_type);
            post_location=itemView.findViewById(R.id.location);
            post_status=itemView.findViewById(R.id.job_status);
            tags=itemView.findViewById(R.id.tags_recycler);
            images=itemView.findViewById(R.id.image_recycler);
            tags.setLayoutManager(new LinearLayoutManager(ctx,LinearLayoutManager.HORIZONTAL,false));
            tags.setHasFixedSize(true);
            images.setLayoutManager(new LinearLayoutManager(ctx,LinearLayoutManager.HORIZONTAL,false));
            images.setHasFixedSize(true);

        }
    }
}
