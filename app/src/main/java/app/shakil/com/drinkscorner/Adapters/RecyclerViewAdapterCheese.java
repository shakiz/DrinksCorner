package app.shakil.com.drinkscorner.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import app.shakil.com.drinkscorner.Model.CheeseItem;
import app.shakil.com.drinkscorner.R;

public class RecyclerViewAdapterCheese extends RecyclerView.Adapter<RecyclerViewAdapterCheese.MyViewHolder>{
    private List<CheeseItem> cheeseList;
    private Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, description, price,rating;
        public ImageView imageView;
        private Button addToCart;

        public MyViewHolder(View view) {
            super(view);
            imageView=view.findViewById(R.id.chesseIconXML);
            title = view.findViewById(R.id.cheeseItemNameXML);
            description = view.findViewById(R.id.cheeseItemDescriptionXML);
            price =  view.findViewById(R.id.itemPriceXML);
            rating = view.findViewById(R.id.itemRatingXML);
            addToCart=view.findViewById(R.id.addToCartButtonXML);
        }
    }


    public RecyclerViewAdapterCheese(List<CheeseItem> cheeseList,Context context) {
        this.cheeseList = cheeseList;
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_blueprint_recyclerview, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        CheeseItem cheeseItem = cheeseList.get(position);
        holder.imageView.setImageResource(cheeseItem.getImage());
        holder.title.setText(cheeseItem.getTitle());
        holder.description.setText(cheeseItem.getDescription());
        holder.price.setText(""+cheeseItem.getPrice()+"$");
        holder.rating.setText(" / "+cheeseItem.getRating());
        holder.addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"Added to cart",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return cheeseList.size();
    }
}
