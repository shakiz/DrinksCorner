package app.shakil.com.drinkscorner;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;

import app.shakil.com.drinkscorner.Model.Item;

public class SaveCartDetails extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "SaveCartDetails.db";

    // User table name
    private static final String TABLE_CART_DETAILS = "cartdetails";

    // User Table Columns names
    private static final String COLUMN_ITEM_ID = "item_id";
    private static final String COLUMN_ITEM_TITLE = "item_title";
    private static final String COLUMN_ITEM_DESCRIPTION = "item_description";
    private static final String COLUMN_ITEM_PRICE = "item_price";
    private static final String COLUMN_ITEM_RATING = "item_rating";

    // create table sql query
    private String CREATE_ITEM_TABLE = "CREATE TABLE " + TABLE_CART_DETAILS + "("
            + COLUMN_ITEM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_ITEM_TITLE + " TEXT,"
            + COLUMN_ITEM_DESCRIPTION + " TEXT,"+ COLUMN_ITEM_PRICE +" REAL,"+ COLUMN_ITEM_RATING +" REAL"+")";

    // drop table sql query
    private String DROP_EXPENSE_TABLE = "DROP TABLE IF EXISTS " + TABLE_CART_DETAILS;

    /**
     * Constructor
     *
     * @param context
     */
    public SaveCartDetails(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_ITEM_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Drop User Table if exist
        db.execSQL(DROP_EXPENSE_TABLE);
        // Create tables again
        onCreate(db);
    }

    /**
     * This method is to create expense record
     *
     * @param item
     */
    public void addNewItem(Item item) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ITEM_TITLE,item.getTitle());
        values.put(COLUMN_ITEM_DESCRIPTION, item.getDescription());
        values.put(COLUMN_ITEM_PRICE, item.getPrice());
        values.put(COLUMN_ITEM_RATING, item.getRating());
        // Inserting Row
        db.insert(TABLE_CART_DETAILS, null, values);
        Log.v("SUCCESS MESSAGE : ","DATA INSERTED SUCCESSFULLY");
        db.close();
    }
    /**
     * This method is to delete terms record
     */
    public void deleteALLItem() {
        SQLiteDatabase db = this.getWritableDatabase();
        // delete user record by id
        db.delete(TABLE_CART_DETAILS,null,null);
        db.close();
    }

    /**
     * This method is to get a single expense row record
     */
    public Item getSingleItemDetailsByTitle(String title){
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        String query = "select * from " + TABLE_CART_DETAILS + " where "+ COLUMN_ITEM_TITLE + " = '" + title + "'";
        Cursor cursor=sqLiteDatabase.rawQuery(query, null);
        Item item=new Item();
        Log.v("Title : ",""+title);
        if (cursor.moveToFirst()){
            do {
                item.setTitle(cursor.getString(cursor.getColumnIndex(COLUMN_ITEM_TITLE)));
                item.setDescription(cursor.getString(cursor.getColumnIndex(COLUMN_ITEM_DESCRIPTION)));
                item.setPrice(cursor.getDouble(cursor.getColumnIndex(COLUMN_ITEM_RATING)));
                item.setRating(cursor.getDouble(cursor.getColumnIndex(COLUMN_ITEM_PRICE)));
                Log.v("Info : ",""+cursor.getString(cursor.getColumnIndex(COLUMN_ITEM_TITLE)));

            }while (cursor.moveToNext());
        }
        cursor.close();
        sqLiteDatabase.close();
        return item;
    }


    /**
     * This method is to delete a single item row record
     */
    public  void deleteSingleItemByName(String title) {
        SQLiteDatabase db = this.getWritableDatabase();
        Log.v("NAME 2 : ",""+title);
        // delete user record by name
        try{
            db.execSQL("DELETE FROM " + TABLE_CART_DETAILS + " WHERE " + COLUMN_ITEM_TITLE + "= '" + title + "'");
        }
        catch (Exception e){
            Log.v("EXCEPTION : ",""+e.getMessage());
        }
        db.close();
    }
    /**
     * This method is to fetch all expense and return the list of expense records
     *
     * @return list
     */
    public ArrayList<Item> getAllItems() {
        // array of columns to fetch
        String[] columns = {
                COLUMN_ITEM_TITLE,
                COLUMN_ITEM_DESCRIPTION,
                COLUMN_ITEM_PRICE,
                COLUMN_ITEM_RATING,
        };
        ArrayList<Item> itemList = new ArrayList<Item>();
        SQLiteDatabase db = this.getReadableDatabase();
        // query the user table
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
         */
        Cursor cursor = db.query(TABLE_CART_DETAILS, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                null); //The sort order
        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Item item = new Item();
                item.setTitle(cursor.getString(cursor.getColumnIndex(COLUMN_ITEM_TITLE)));
                item.setDescription(cursor.getString(cursor.getColumnIndex(COLUMN_ITEM_DESCRIPTION)));
                item.setPrice(cursor.getDouble(cursor.getColumnIndex(COLUMN_ITEM_RATING)));
                item.setRating(cursor.getDouble(cursor.getColumnIndex(COLUMN_ITEM_PRICE)));
                // Adding user record to list
                itemList.add(item);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return user list
        return itemList;
    }


    /**
     * This method is to fetch only the item title
     *
     * @return list of string which is the expense title
     */
    public ArrayList<String> getItemTitle() {
        // array of columns to fetch
        String[] columns = {
                COLUMN_ITEM_TITLE,
        };
        ArrayList<String> itemList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        // query the user table
        Cursor cursor = db.query(TABLE_CART_DETAILS, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                null); //The sort order
        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                // Adding user record to list
                itemList.add(cursor.getString(cursor.getColumnIndex(COLUMN_ITEM_TITLE)));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        // return user list
        return itemList;
    }
}

