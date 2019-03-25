package id.amfg.ecs.adapter;

import androidx.recyclerview.widget.RecyclerView;
import id.amfg.ecs.R;
import id.amfg.ecs.model.MenuChecksheet;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterChecksheet extends RecyclerView.Adapter<AdapterChecksheet.MenuChecksheetViewHolder>{

    private  ArrayList<MenuChecksheet> menuList;
    private OnMenuClickListener onMenuClickListener;

    public interface OnMenuClickListener {
        void onMenuClick(int position);
    }

    public AdapterChecksheet(ArrayList<MenuChecksheet> menuList, OnMenuClickListener onMenuClickListener){
        this.menuList = menuList;
        this.onMenuClickListener = onMenuClickListener;
    }

    @Override
    public MenuChecksheetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from((parent.getContext()));
        View view = layoutInflater.inflate(R.layout.menu_checksheet, parent, false);

        return new MenuChecksheetViewHolder(view, onMenuClickListener);
    }

    @Override
    public void onBindViewHolder(MenuChecksheetViewHolder holder, int position) {
        holder.img_name.setText(menuList.get(position).getImg_name());
        holder.img.setImageResource(menuList.get(position).getImg());

    }

    @Override
    public int getItemCount() {
        return (menuList != null) ? menuList.size() :0;
    }

    public class MenuChecksheetViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView img_name;
        private ImageView img;
        OnMenuClickListener onMenuClickListener;

        public MenuChecksheetViewHolder(View itemView, OnMenuClickListener onMenuClickListener) {
            super(itemView);
            img_name = (TextView) itemView.findViewById(R.id.img_name);
            img = (ImageView) itemView.findViewById(R.id.img);
            this.onMenuClickListener = onMenuClickListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onMenuClickListener.onMenuClick(getAdapterPosition());
        }
    }
}
