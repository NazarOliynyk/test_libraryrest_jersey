package model.book.nested;

import com.fasterxml.jackson.annotation.JsonProperty;
import model.book.nested.nested.Size;

public class Additional {

    @JsonProperty
    private int pageCount;
    @JsonProperty
    private Size size;

    public Additional() {
    }

    public Additional(int pageCount, Size size) {
        this.pageCount = pageCount;
        this.size = size;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Additional that = (Additional) o;

        if (pageCount != that.pageCount) return false;
        return size.equals(that.size);
    }

    @Override
    public int hashCode() {
        int result = pageCount;
        result = 31 * result + size.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Additional{" +
                "pageCount=" + pageCount +
                ", size=" + size +
                '}';
    }
}
