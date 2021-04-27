package lv.lu.guntars.revelins.finalwork.model;

import lombok.Data;

@Data
public class ProductData {

    private final String id;
    private final String name;
    private final String price;

    public ProductData(String id, String name, String price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

}
