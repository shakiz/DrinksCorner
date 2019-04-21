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
import app.shakil.com.drinkscorner.Adapters.RecyclerViewAdapterCheese;
import app.shakil.com.drinkscorner.Model.CheeseItem;
import app.shakil.com.drinkscorner.R;

public class CheeseFragment extends Fragment {

    private RecyclerView recyclerViewCheese;
    private RecyclerView.LayoutManager linearLayoutManager;
    private RecyclerViewAdapterCheese recyclerViewAdapterCheese;
    private List<CheeseItem> cheeseCheeseItemList;

    public CheeseFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_cheese, container, false);
        init(view);

        insertData();

        recyclerViewAdapterCheese=new RecyclerViewAdapterCheese(cheeseCheeseItemList,getContext());
        recyclerViewCheese.setLayoutManager(linearLayoutManager);
        recyclerViewCheese.setItemAnimator(new DefaultItemAnimator());
        recyclerViewCheese.setAdapter(recyclerViewAdapterCheese);
        return view;
    }

    private void insertData() {
        cheeseCheeseItemList.add(new CheeseItem(R.drawable.cheese,"Cheese Burger","Burger with cheese seems pretty amazing",6.7,4.8));
        cheeseCheeseItemList.add(new CheeseItem(R.drawable.cheese,"Oreo Cookie Cheesecake","A  much-loved dessert made with crunchy oreo cookies, " +
                "luscious cream cheese and melted chocolate. This cake is a sweet sweet blessing!",11.9,4.9));
        cheeseCheeseItemList.add(new CheeseItem(R.drawable.cheese,"Savory Corn Tarts","Party snacks get a healthy makeover! Go gluten free with these savory" +
                " tarts made with maize flour and filled with a cheesy vegetable mix.",6.7,4.8));
        cheeseCheeseItemList.add(new CheeseItem(R.drawable.cheese,"Cheese and Pesto Eggplant","Eggplant laced with Parmesan cheese and" +
                " baked in freshly made pesto sauce.",6.7,4.8));
        cheeseCheeseItemList.add(new CheeseItem(R.drawable.cheese,"Four Cheese Pasta","Cheese lovers, rejoice! Gourmet macaroni cheese with parmesan, " +
                "cheddar, brie and emmental. This recipe is as cheesy as it can get.",6.7,4.8));
        cheeseCheeseItemList.add(new CheeseItem(R.drawable.cheese,"Cheese Fondue","Fondue is a Swiss dish made with melted cheese. For all the cheese lover, " +
                "Emmenthaler and Gruyere cheese melted and drizzled with some white wine.",6.7,4.8));
    }

    public void init(View view){
        recyclerViewCheese=view.findViewById(R.id.recyclerViewItemXML);
        linearLayoutManager=new LinearLayoutManager(getContext());
        cheeseCheeseItemList =new ArrayList<>();
    }

}
