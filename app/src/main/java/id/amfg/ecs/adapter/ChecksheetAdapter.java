package id.amfg.ecs.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import id.amfg.ecs.BracketActivity;
import id.amfg.ecs.R;

public class ChecksheetAdapter extends RecyclerView.Adapter<ChecksheetAdapter.ViewHolder> {
    private static final String TAG = "ChecksheetAdapter";

    //private ArrayList<String> mImage = new ArrayList<>();
    private int[] mImage = new int[2];
    private ArrayList<String> mImageName = new ArrayList<>();
    private Context mContext;

    public ChecksheetAdapter(Context Context, int[] Image, ArrayList<String> ImageName) {
        this.mImage = Image;
        this.mImageName = ImageName;
        this.mContext = Context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_checksheet,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder:called");
        if (position <= 1) {
            Glide.with(mContext)
                    .asBitmap()
                    //.load(mImage.get(position))
                    .load(mImage[position])
                    .into(holder.image);

            holder.imageName.setText(mImageName.get(position));
            holder.parentLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = null;
                    switch (position) {
                        case 0:
                            intent = new Intent(mContext, BracketActivity.class);
                            break;
                        case 1:
                            break;
                    }
                    if (intent != null)
                        mContext.startActivity(intent);
                }
                //Toast.makeText(mContext,mImageName.get(position),Toast.LENGTH_SHORT).show();
            });
        }
    }


    @Override
    public int getItemCount() {
        return mImageName.size();
    }

    public class  ViewHolder extends RecyclerView.ViewHolder{
        //CircleImageView image;
        ImageView image;
        TextView imageName;
        RelativeLayout parentLayout;

        public  ViewHolder(View itemView){
            super(itemView);
            image = itemView.findViewById(R.id.img);
            imageName = itemView.findViewById(R.id.img_name);
            parentLayout = itemView.findViewById(R.id.menu_checksheet);
        }
    }

}
