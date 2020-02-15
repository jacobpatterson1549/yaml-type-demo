package com.github.jacobpatterson1549.yaml_types_demo.movie;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.github.jacobpatterson1549.yaml_types_demo.movie.type.ComedyMovie;

import java.io.IOException;
import java.io.InputStream;

/**
 * A utility to retrieve Movies from files.
 */
public class MovieManager {
    /**
     * An ObjectMapper which serializes and deserializes YAML Objects.
     */
    private final ObjectMapper yamlMapper;

    public MovieManager() {
        YAMLFactory yamlFactory = new YAMLFactory();
        yamlMapper = new ObjectMapper(yamlFactory);
        yamlMapper.registerSubtypes(new NamedType(
            ComedyMovie.class, MovieGenre.COMEDY.getInternalName()));
    }

    /**
     * Gets a movie from a YAML InputStream.
     * 
     * @param yamlInputStream The InputStream to read the Movie from.
     * @return The Movie represented by the InputStream.
     * @throws IOException If a problem occurs reading the InputStream or
     * converting it to a Movie.
     */
    public Movie getMovieFromYaml(InputStream yamlInputStream)
        throws IOException {
        return yamlMapper.readValue(yamlInputStream, Movie.class);
    }
}