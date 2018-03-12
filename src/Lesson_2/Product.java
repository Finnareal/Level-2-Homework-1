package Lesson_2;

public class Product {
    private String name;

    @RandomInt(min = 0, max = 90)
    private int inStock;

    @RandomInt(min = 0, max = 50)
    private int reserved;

    @RandomInt(min = 20, max = 70)
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
