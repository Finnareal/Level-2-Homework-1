package Lesson_2;

public class Product {
    private String name;

    @RandomInt(min = 30, max = 90)
    private int inStock;

    @RandomInt(min = 0, max = 29)
    private int reserved;

    @RandomInt(min = 1, max = 90)
    private int freeInStock;

    private Product(){}

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", inStock=" + inStock +
                ", reserved=" + reserved +
                ", freeInStock=" + freeInStock +
                '}';
    }
}
