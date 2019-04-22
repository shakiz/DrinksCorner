package app.shakil.com.drinkscorner.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import java.util.ArrayList;
import app.shakil.com.drinkscorner.R;

public class CartRecyclerViewAdapter extends RecyclerView.Adapter<CartRecyclerViewAdapter.ViewHolder> {

    private ArrayList<String> dataSet;
    private Context mContext;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View convertView = inflater.inflate(R.layout.item_blueprint_listview_cart_details, parent, false);
        return new ViewHolder(convertView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
//        result.startAnimation(animation);
//        lastPosition = position;
        holder.txtTitle.setText(dataSet.get(position));
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    // View lookup cache
    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            txtTitle=itemView.findViewById(R.id.cart_title_xml);
        }
    }
    public CartRecyclerViewAdapter(ArrayList<String> data, Context context) {
        this.dataSet = data;
        Log.v("Test : ",""+dataSet.get(0));
        this.mContext=context;
    }
}
