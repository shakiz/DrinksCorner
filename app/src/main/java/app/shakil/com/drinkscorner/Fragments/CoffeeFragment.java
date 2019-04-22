package app.shakil.com.drinkscorner.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import app.shakil.com.drinkscorner.Adapters.RecyclerViewAdapterCoffee;
import app.shakil.com.drinkscorner.Model.Item;
import app.shakil.com.drinkscorner.R;

public class CoffeeFragment extends Fragment {

    private RecyclerView recyclerViewCoffee;
    private RecyclerView.LayoutManager linearLayoutManager;
    private RecyclerViewAdapterCoffee recyclerViewAdapterCoffee;
    private List<Item> coffeeItemList;

    public CoffeeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_coffee, container, false);
        init(view);
        insertData();
        recyclerViewAdapterCoffee=new RecyclerViewAdapterCoffee(coffeeItemList,getContext());
        recyclerViewCoffee.setLayoutManager(linearLayoutManager);
        recyclerViewCoffee.setItemAnimator(new DefaultItemAnimator());
        recyclerViewCoffee.setAdapter(recyclerViewAdapterCoffee);
        return view;
    }

    private void insertData() {
        coffeeItemList.add(new Item(R.drawable.coffee,"Flat White","The two most Kiwi coffees available are the long black and the flat white " +
                "– as both originated in New Zealand and Australia.",6.7,4.8));
        coffeeItemList.add(new Item(R.drawable.coffee,"Long Black","Hot water is poured into a cup, and then two shots of espresso are poured " +
                "into the water. If you do the inverse of this, it will result in an Americano.",11.9,4.9));
        coffeeItemList.add(new Item(R.drawable.coffee,"Mochaccino","A ‘mocha’ is just a latte with added chocolate powder or syrup, " +
                "as well as sometimes being topped with whipped cream. ",6.7,4.8));
        coffeeItemList.add(new Item(R.drawable.coffee,"Irish Coffee","Too many of these and you might have to ‘just crash here, bro’," +
                " because this type of coffee is brewed with whiskey, sugar, and a thick layer of cream on the top",6.7,4.8));
        coffeeItemList.add(new Item(R.drawable.coffee,"Vienna","A Vienna is made by adding two shots of particularly strong espresso" +
                " together before whipped cream is added as a substitute for milk and sugar. ",6.7,4.8));
        coffeeItemList.add(new Item(R.drawable.coffee,"Affogato","Affogatos aren’t a coffee at all really, as they’re a shot of" +
                " espresso poured over a desert (usually ice cream). That doesn’t make them any less delicious though.",6.7,4.8));
    }

    public void init(View view){
        recyclerViewCoffee =view.findViewById(R.id.recyclerViewItemXML);
        linearLayoutManager=new LinearLayoutManager(getContext());
        coffeeItemList =new ArrayList<>();
    }

}
