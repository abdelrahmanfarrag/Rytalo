package comr.example.mana.rytalo.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import comr.example.mana.rytalo.Helpers.CommonMethods;
import comr.example.mana.rytalo.Models.ImagesTable;
import comr.example.mana.rytalo.R;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by MANA on 4/7/2018.
 */

public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.ImagesHolder> {
    Context ctx;
    List<ImagesTable> images;
    View v;
    public ImagesAdapter(Context ctx,List<ImagesTable> images)
    {
        this.ctx=ctx;
        this.images=images;
    }
    @Override
    public ImagesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        v= LayoutInflater.from(ctx).inflate(R.layout.single_interest_item,parent,false);
        return new ImagesHolder(v);
    }

    @Override
    public void onBindViewHolder(ImagesHolder holder, int position) {
        ImagesTable table = images.get(position);
        byte[] imageBytes = table.getImage();
            Bitmap bitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
           holder.userImage.setImageBitmap(bitmap);


    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    class ImagesHolder extends RecyclerView.ViewHolder{
          CircleImageView userImage;
        public ImagesHolder(View itemView) {
            super(itemView);
            userImage = itemView.findViewById(R.id.single_image);

        }
    }
}
