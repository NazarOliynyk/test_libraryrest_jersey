package model.genre;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Genre {

    @JsonProperty
    private int genreId;
    @JsonProperty
    private String genreName;
    @JsonProperty
    private String genreDescription;

    public Genre() {
    }

    public Genre(int genreId, String genreName, String genreDescription) {
        this.genreId = genreId;
        this.genreName = genreName;
        this.genreDescription = genreDescription;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public String getGenreDescription() {
        return genreDescription;
    }

    public void setGenreDescription(String genreDescription) {
        this.genreDescription = genreDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genre genre = (Genre) o;
        return genreId == genre.genreId &&
                Objects.equals(genreName, genre.genreName) &&
                Objects.equals(genreDescription, genre.genreDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genreId, genreName, genreDescription);
    }

    @Override
    public String toString() {
        return "Genre{" +
                "genreId=" + genreId +
                ", genreName='" + genreName + '\'' +
                ", genreDescription='" + genreDescription + '\'' +
                '}';
    }
}
