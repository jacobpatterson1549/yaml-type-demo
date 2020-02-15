package com.github.jacobpatterson1549.yaml_types_demo.movie;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

/**
 * A video that can be shown to an audience in a theater.
 */
@JsonTypeInfo(
    use = Id.NAME,
    include = As.PROPERTY,
    property = "genre"
)
public interface Movie {
    /**
     * Gets the title of the Movie
     * 
     * @return The title of the Movie.
     */
    String getTitle();

    /**
     * Gets the MovieGenre of the Movie.
     * 
     * @return The MovieGenre of the Movie.
     */
    MovieGenre getMovieGenre();
}