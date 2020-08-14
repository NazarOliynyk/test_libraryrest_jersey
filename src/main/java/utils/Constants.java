package utils;

public interface Constants {

//    authentication
    String AUTH_USERNAME = "defaultUser";
    String AUTH_PASSWORD = "defaultPassword";
    String AUTHENTICATION_URI = "/api/library/login";
    String AUTH_KEY_WORD = "Authorization";

//    uri
    String BASE_URI = "http://localhost:8080";

    String GET_AUTHOR = "/api/library/author/%s";
    String GET_ALL_AUTHORS = "/api/library/authors";
    String POST_AUTHOR = "/api/library/author";
    String PUT_AUTHOR = "/api/library/author";
    String DELETE_AUTHOR = "/api/library/author/%s";

    String POST_BOOK = "/api/library/book/%s/%s";
    String GET_BOOK = "/api/library/book/%s";
    String GET_ALL_BOOKS = "/api/library/books";
    String DELETE_BOOK = "/api/library/book/%s";

    String GET_GENRE = "/api/library/genre/%s";
    String POST_GENRE = "/api/library/genre";
    String GET_ALL_GENRES = "/api/library/genres";
    String DELETE_GENRE = "/api/library/genre/%s";

//    parameter
    String PARAMETER_SIZE = "size";
    String PARAMETER_SORT = "sortBy";
    String PARAMETER_ORDER = "orderType";
    String INITIAL_SIZE_OF_COLLECTION = "200";
    String BOOK_SORTING_PARAMETER = "bookName";
    String DESCENDING_ORDER = "desc";

//    random data
    String RANDOM_AUTHOR_FIRST_NAME = "SomeAuthorFirstName";
    String RANDOM_AUTHOR_SECOND_NAME = "SomeAuthorSecondName";
    String RANDOM_AUTHOR_NATIONALITY = "SomeAuthor Nationality";
    String RANDOM_AUTHOR_DESCRIPTION = "SomeAuthor Description";
    String RANDOM_AUTHOR_BIRTH_CITY = "Some City";
    String RANDOM_AUTHOR_BIRTH_COUNTRY = "Some Country";
    String RANDOM_AUTHOR_BIRTH_DATE = "1999-10-10";

    String UPDATED_AUTHOR_NATIONALITY = "UPDATED Nationality";
    String UPDATED_AUTHOR_DESCRIPTION = "UPDATED Description";
    String UPDATED_AUTHOR_BIRTH_DATE = "1900-05-05";

    double RANDOM_BOOK_HEIGHT = 11.11;
    double RANDOM_BOOK_WIDTH = 22.22;
    double RANDOM_BOOK_LENGTH = 33.33;
    int RANDOM_BOOK_PAGE_COUNT = 150;
    String RANDOM_BOOK_NAME = "Some Book Name";
    String RANDOM_BOOK_LANGUAGE = "Some Book Language";
    String RANDOM_BOOK_DESCRIPTION = "SomeBookName";
    int RANDOM_BOOK_PUBLICATION_YEAR = 2010;

    String RANDOM_GENRE_NAME = "Some Genre Name";
    String RANDOM_GENRE_DESCRIPTION = "Some Genre Description";

}
