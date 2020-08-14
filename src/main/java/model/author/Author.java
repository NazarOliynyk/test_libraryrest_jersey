package model.author;

import com.fasterxml.jackson.annotation.JsonProperty;
import model.author.nested.Birth;
import model.author.nested.Name;

import java.util.Objects;

public class Author {
    @JsonProperty
    private int authorId;
    @JsonProperty
    private Name authorName;
    @JsonProperty
    private String nationality;
    @JsonProperty
    private Birth birth;
    @JsonProperty
    private String authorDescription;

    public Author() {
    }

    public Author(int authorId, Name authorName, String nationality, Birth birth, String authorDescription) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.nationality = nationality;
        this.birth = birth;
        this.authorDescription = authorDescription;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public Name getAuthorName() {
        return authorName;
    }

    public void setAuthorName(Name authorName) {
        this.authorName = authorName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Birth getBirth() {
        return birth;
    }

    public void setBirth(Birth birth) {
        this.birth = birth;
    }

    public String getAuthorDescription() {
        return authorDescription;
    }

    public void setAuthorDescription(String authorDescription) {
        this.authorDescription = authorDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return authorId == author.authorId &&
                Objects.equals(authorName, author.authorName) &&
                Objects.equals(nationality, author.nationality) &&
                Objects.equals(birth, author.birth) &&
                Objects.equals(authorDescription, author.authorDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorId, authorName, nationality, birth, authorDescription);
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", authorName=" + authorName +
                ", nationality='" + nationality + '\'' +
                ", birth=" + birth +
                ", authorDescription='" + authorDescription + '\'' +
                '}';
    }
}
