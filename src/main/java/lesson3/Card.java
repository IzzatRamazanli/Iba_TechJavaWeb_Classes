package lesson3;

public class Card {
    int id;
    String pan;
    String type;
    int price;
    int img;

    public Card(int id, String pan, String type, int price, int img) {
        this.id = id;
        this.pan = pan;
        this.type = type;
        this.price = price;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", pan='" + pan + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", img=" + img +
                '}';
    }
}
