package utils;

import model.author.Author;
import model.author.nested.Birth;
import model.author.nested.Name;
import model.book.Book;
import model.book.nested.Additional;
import model.book.nested.nested.Size;
import model.genre.Genre;

import java.time.LocalDate;

import static utils.Constants.*;

public class EntityGenerator {

    public EntityGenerator() {
    }

    public Author generateRandomAuthor(int authorId){
        Author author = new Author();
        author.setAuthorId(authorId);
        Name name = new Name();
        name.setFirst(RANDOM_AUTHOR_FIRST_NAME);
        name.setSecond(RANDOM_AUTHOR_SECOND_NAME);
        author.setNationality(RANDOM_AUTHOR_NATIONALITY);
        author.setAuthorDescription(RANDOM_AUTHOR_DESCRIPTION);
        author.setAuthorName(name);
        Birth birth = new Birth();
        birth.setCity(RANDOM_AUTHOR_BIRTH_CITY);
        birth.setCountry(RANDOM_AUTHOR_BIRTH_COUNTRY);
        birth.setDate(LocalDate.parse(RANDOM_AUTHOR_BIRTH_DATE));
        author.setBirth(birth);
        return author;
    }

    public Author updateAuthor(Author authorToBeUpdated){
        authorToBeUpdated.setNationality(UPDATED_AUTHOR_NATIONALITY);
        authorToBeUpdated.setAuthorDescription(UPDATED_AUTHOR_DESCRIPTION);
        Birth birthToUpdate = authorToBeUpdated.getBirth();
        birthToUpdate.setDate(LocalDate.parse(UPDATED_AUTHOR_BIRTH_DATE));
        authorToBeUpdated.setBirth(birthToUpdate);
        return authorToBeUpdated;
    }

    public Book generateRandomBook(int bookId){
        Book book = new Book();
        book.setBookId(bookId);
        book.setBookName(RANDOM_BOOK_NAME);
        book.setBookLanguage(RANDOM_BOOK_LANGUAGE);
        book.setBookDescription(RANDOM_BOOK_DESCRIPTION);
        book.setPublicationYear(RANDOM_BOOK_PUBLICATION_YEAR);
        Size size = new Size();
        size.setHeight(RANDOM_BOOK_HEIGHT);
        size.setWidth(RANDOM_BOOK_WIDTH);
        size.setLength(RANDOM_BOOK_LENGTH);
        Additional additional = new Additional();
        additional.setPageCount(RANDOM_BOOK_PAGE_COUNT);
        additional.setSize(size);
        book.setAdditional(additional);
        return book;
    }

    public Genre generateRandomGenre(int genreId){
        Genre genre = new Genre();
        genre.setGenreId(genreId);
        genre.setGenreName(RANDOM_GENRE_NAME);
        genre.setGenreDescription(RANDOM_GENRE_DESCRIPTION);
        return genre;
    }

}
