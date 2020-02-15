package com.github.jacobpatterson1549.yaml_types_demo.movie;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * An enumeration of different movie types.
 * Source: https://en.wikipedia.org/wiki/List_of_genres
 */
public enum MovieGenre {
	ABSURDIST("Absurdist", "absurdist"),
	ACTION("Action", "action"),
	ADVENTURE("Adventure", "adventure"),
	COMEDY("Comedy", "comedy"),
	CRIME("Crime", "crime"),
	DRAMA("Drama", "drama"),
	FANTASY("Fantasy", "fantasy"),
	HISTORICAL("Historical", "historical"),
	HISTORICAL_FICTION("Historical fiction", "historicalFiction"),
	HORROR("Horror", "horror"),
	MAGICAL_REALISM("Magical realism", "magicalRealism"),
	MYSTERY("Mystery", "mystery"),
	PARANOID_FICTION("Paranoid fiction", "paranoidFiction"),
	PHILOSOPHICAL("Philosophical", "philosophical"),
	POLITICAL("Political", "political"),
	ROMANCE("Romance", "romance"),
	SAGA("Saga", "saga"),
	SATIRE("Satire", "satire"),
	SCIENCE_FICTION("Science fiction", "scienceFiction"),
	SOCIAL("Social", "social"),
	SPECULATIVE("Speculative", "speculative"),
	THRILLER("Thriller", "thriller"),
	URBAN("Urban", "urban"),
	WESTERN("Western", "western"),
    ;

    private final String displayName;
    private final String internalName;

    private static final Map<String, MovieGenre> INTERNAL_NAMES
        = Arrays.stream(MovieGenre.values())
            .collect(Collectors.toMap(
                MovieGenre::getInternalName,
                Function.identity()));

    MovieGenre(String displayName, String internalName) {
        this.displayName = displayName;
        this.internalName = internalName;
    }

	/**
	 * Gets the display name.
	 * 
	 * @return The display name.
	 */
    public String getDisplayName() {
        return displayName;
    }

	/**
	 * Gets the internal name.  Useful for processing.
	 * 
	 * @return The internal name.
	 */
    public String getInternalName() {
        return internalName;
    }

	/**
	 * Gets the MovieGenre with the specified internal name.
	 * 
	 * @param internalName The internal name of the MovieGenre to get.
	 * @return The MovieGenre with the specified internal name
	 * or null if no such MovieGenre exists.
	 */
    public static MovieGenre fromInternalName(String internalName) {
        return INTERNAL_NAMES.get(internalName);
    }
}