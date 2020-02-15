package com.github.jacobpatterson1549.yaml_types_demo.movie;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Tests for {@link MovieGenre}.
 */
public class MovieGenreTest {
    /**
     * Ensures each movieGenre displayName is unique.
     */
    @Test
    public void testInternalNames_unique() {
        MovieGenre[] values = MovieGenre.values();

        long actualUniqueCount = Arrays.stream(values)
            .map(MovieGenre::getInternalName)
            .distinct()
            .count();
        long expectedUniqueCount = values.length;

        assertThat(actualUniqueCount, is(equalTo(expectedUniqueCount)));
    }

    /**
     * Ensures each MovieGenre enum name is all uppercase and underscores.
     * 
     * @param movieGenre The MovieGenre to test
     */
    @ParameterizedTest
    @EnumSource(MovieGenre.class)
    public void testName_Uppercase(MovieGenre movieGenre) {
        String actualName = movieGenre.name();
        String expectedName = movieGenre.name()
            .toUpperCase()
            .replaceAll("\\W", "_");

        assertThat(actualName, is(equalTo(expectedName)));
    }


    /**
     * Ensures each MovieGenre displayName contains all the letters of it's
     * enum name.
     * 
     * @param movieGenre The MovieGenre to test
     */
    @ParameterizedTest
    @EnumSource(MovieGenre.class)
    public void testDisplayNameLikeName(MovieGenre movieGenre) {
        String actualName = movieGenre.getDisplayName()
            .toUpperCase()
            .replaceAll("\\W", "_");
        String expectedName = movieGenre.name();

        assertThat(actualName, is(equalTo(expectedName)));
    }

    /**
     * Ensures each MovieGenre internalName is camel-cased.
     * 
     * @param movieGenre The MovieGenre to test.
     */
    @ParameterizedTest
    @EnumSource(MovieGenre.class)
    public void testInternalName_camelCased(MovieGenre movieGenre) {
        Stream<String> nameParts
            = Arrays.stream(movieGenre.name().split("_"))
            .map(part -> part.substring(0, 1)
                .concat(part.substring(1).toLowerCase()));

        String actualName = nameParts.collect(Collectors.joining());
        actualName = actualName.replaceFirst(
            "^.", actualName.substring(0, 1).toLowerCase());
        String expectedName = movieGenre.getInternalName();

        assertThat(actualName, is(equalTo(expectedName)));
    }
}