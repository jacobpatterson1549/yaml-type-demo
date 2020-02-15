package com.github.jacobpatterson1549.yaml_types_demo.movie;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.stream.Stream;

import com.github.jacobpatterson1549.yaml_types_demo.movie.type.ComedyMovie;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Tests for {@link MovieManager}.
 */
public class MovieManagerTest {
    /**
     * Ensures Movies represented by the specified strings deserialize to the
     * corresponding classes
     */
    @ParameterizedTest
    @MethodSource
    public void testGetMovieFromYaml(String yamlText, Class<Exception> expectedClass)
        throws IOException {
        InputStream yamlInputStream
            = new ByteArrayInputStream(yamlText.getBytes());
        MovieManager movieManager = new MovieManager();

        if (Exception.class.isAssignableFrom(expectedClass)) {
            assertThrows(expectedClass,
                () -> movieManager.getMovieFromYaml(yamlInputStream));
        } else {
            Movie actualMovie = movieManager.getMovieFromYaml(yamlInputStream);
            assertThat(actualMovie, is(instanceOf(expectedClass)));
        }
    }

    /**
     * Gets arguments for the testGetMovieFromYaml @ParameterizedTest.
     * This works because the static method's name is the same as the test's name.
     * 
     * @return Arguments for the testGetMovieFromYaml @ParameterizedTest.
     */
    private static Stream<Arguments> testGetMovieFromYaml() {
        return Stream.of(
            Arguments.of("---\n"
                + "title: Step Brothers\n"
                + "animated: false\n"
                + "genre: comedy\n",
                ComedyMovie.class),
            Arguments.of("---\n"
                + "title: Blazing Saddles\n"
                + "genre: comedy\n",
                ComedyMovie.class),
            Arguments.of("---\n"
                + "title: Step Brothers\n"
                + "genre: adventure\n",
                IOException.class),
            Arguments.of(
                "BAD_YAML",
                IOException.class));
    }
}