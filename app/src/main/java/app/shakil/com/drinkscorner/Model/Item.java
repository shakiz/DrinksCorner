package app.shakil.com.drinkscorner.Model;

public class Item {
    private String title,description;
    private double price,rating;
    private int image;

    public Item(int image, String title, String description, double price, double rating){
        this.image=image;
        this.title=title;
        this.description=description;
        this.price=price;
        this.rating=rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
