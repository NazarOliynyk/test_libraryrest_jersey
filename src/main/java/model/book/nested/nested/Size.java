package model.book.nested.nested;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Size {

    @JsonProperty
    private double height;
    @JsonProperty
    private double width;
    @JsonProperty
    private double length;

    public Size() {
    }

    public Size(double height, double width, double length) {
        this.height = height;
        this.width = width;
        this.length = length;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Size size = (Size) o;

        if (Double.compare(size.height, height) != 0) return false;
        if (Double.compare(size.width, width) != 0) return false;
        return Double.compare(size.length, length) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(height);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(width);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(length);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Size{" +
                "height=" + height +
                ", width=" + width +
                ", length=" + length +
                '}';
    }
}
