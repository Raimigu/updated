package meandrick.martin.front_page_risaikuru;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProgramAdapter extends RecyclerView.Adapter<meandrick.martin.front_page_risaikuru.ProgramAdapter.ItemViewHolder> {
    private ArrayList<meandrick.martin.front_page_risaikuru.RecItems> mRecItems;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder{
        public TextView mTitle;
        public TextView mDesc;
        public TextView mLikes;

        public ItemViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.title);
            mDesc = itemView.findViewById(R.id.desc);
            mLikes = itemView.findViewById(R.id.likess);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
    public ProgramAdapter(ArrayList<meandrick.martin.front_page_risaikuru.RecItems> recItems){
        mRecItems = recItems;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.items, parent, false);
        ItemViewHolder ItemHolder = new ItemViewHolder(v, mListener);
        return ItemHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        meandrick.martin.front_page_risaikuru.RecItems currentItem = mRecItems.get(position);

        holder.mTitle.setText(currentItem.getTitle());
        holder.mDesc.setText(currentItem.getDesc());
        holder.mLikes.setText(currentItem.getLikes());
    }

    @Override
    public int getItemCount() {
        return mRecItems.size();
    }
}
