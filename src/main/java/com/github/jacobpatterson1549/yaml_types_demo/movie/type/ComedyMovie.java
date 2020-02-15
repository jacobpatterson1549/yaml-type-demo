package com.github.jacobpatterson1549.yaml_types_demo.movie.type;

import com.github.jacobpatterson1549.yaml_types_demo.movie.Movie;
import com.github.jacobpatterson1549.yaml_types_demo.movie.MovieGenre;

/**
 * A {@link Movie} that is funny.
 */
public class ComedyMovie implements Movie {
    private String title;
    private boolean animated;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
	public MovieGenre getMovieGenre() {
		return MovieGenre.COMEDY;
    }

    /**
     * Gets whether or not the comedy is animated.
     * 
     * @return whether or not the comedy is animated
     */
    public boolean isAnimated() {
        return animated;
    }
}