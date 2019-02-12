package id.amfg.ecs.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;
import id.amfg.ecs.R;

public class ChecksheetAdapter extends RecyclerView.Adapter<ChecksheetAdapter.ViewHolder> {
    private static final String TAG = "ChecksheetAdapter";

    private ArrayList<String> mImage = new ArrayList<>();
    private ArrayList<String> mImageName = new ArrayList<>();
    private Context mContext;

    public ChecksheetAdapter(Context Context, ArrayList<String> Image, ArrayList<String> ImageName) {
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
        Log.d(TAG,"onBindViewHolder:called");
        Glide.with(mContext)
                .asBitmap()
                .load(mImage.get(position))
                .into(holder.image);

        holder.imageName.setText(mImageName.get(position));
        holder.parentLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View view) {
                Toast.makeText(mContext,mImageName.get(position),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mImageName.size();
    }

    public class  ViewHolder extends RecyclerView.ViewHolder{
        CircleImageView image;
        TextView imageName;
        RelativeLayout parentLayout;

        public  ViewHolder(View itemView){
            super(itemView);
            image = itemView.findViewById(R.id.img);
            imageName = itemView.findViewById(R.id.img_name);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }

}
