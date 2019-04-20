package app.shakil.com.drinkscorner.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import app.shakil.com.drinkscorner.Model.CoffeeItem;
import app.shakil.com.drinkscorner.Model.Item;
import app.shakil.com.drinkscorner.R;

public class RecyclerViewAdapterDrinks extends RecyclerView.Adapter<RecyclerViewAdapterDrinks.MyViewHolder>{
    private List<Item> drinksItems;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, description, price,rating;
        public ImageView imageView;

        public MyViewHolder(View view) {
            super(view);
            imageView=view.findViewById(R.id.chesseIconXML);
            title = view.findViewById(R.id.cheeseItemNameXML);
            description = view.findViewById(R.id.cheeseItemDescriptionXML);
            price =  view.findViewById(R.id.itemPriceXML);
            rating = view.findViewById(R.id.itemRatingXML);
        }
    }


    public RecyclerViewAdapterDrinks(List<Item> drinksItems) {
        this.drinksItems = drinksItems;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_blueprint_recyclerview, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Item drinksItem = drinksItems.get(position);
        holder.imageView.setImageResource(drinksItem.getImage());
        holder.title.setText(drinksItem.getTitle());
        holder.description.setText(drinksItem.getDescription());
        holder.price.setText(""+drinksItem.getPrice()+"$");
        holder.rating.setText(" / "+drinksItem.getRating());
    }

    @Override
    public int getItemCount() {
        return drinksItems.size();
    }
}
