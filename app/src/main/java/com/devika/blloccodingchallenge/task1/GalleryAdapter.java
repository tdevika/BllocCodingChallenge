package com.devika.blloccodingchallenge.task1;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.devika.blloccodingchallenge.R;

import java.util.ArrayList;


public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.FolderHolder>{

    private ArrayList<ImageFolder> folders;
    private Context folderContx;

    GalleryAdapter(ArrayList<ImageFolder> folders, Context folderContx) {
        this.folders = folders;
        this.folderContx = folderContx;
    }

    @NonNull
    @Override
    public FolderHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View cell = inflater.inflate(R.layout.picture_folder_item, parent, false);
        return new FolderHolder(cell);

    }

    @Override
    public void onBindViewHolder(@NonNull FolderHolder holder, int position) {
        final ImageFolder folder = folders.get(position);

        Glide.with(folderContx)
                .load(folder.getFirstPic())
                .apply(new RequestOptions().centerCrop())
                .into(holder.folderPic);

        String text = folder.getFolderName();
        String fSize = folder.getNumberOfPics()+" Media ";
        holder.folderName.setText(text);
        holder.folderSize.setText(fSize);
    }

    @Override
    public int getItemCount() {
        return folders.size();
    }

    class FolderHolder extends RecyclerView.ViewHolder{
       ImageView folderPic;
       TextView folderName;
       TextView folderSize;

        FolderHolder(@NonNull View itemView) {
            super(itemView);
           folderPic = itemView.findViewById(R.id.folderPic);
           folderName = itemView.findViewById(R.id.folderName);
           folderSize = itemView.findViewById(R.id.folderSize);
        }
    }

}
