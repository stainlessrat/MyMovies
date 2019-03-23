package rezept_day.ucoz.ru.mymovies.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;

@Entity(tableName = "favourite_movies")
public class FavouriteMovie extends Movie{
    public FavouriteMovie(int id, int voteCount, String title, String originalTitile, String overview, String posterParth, String bigPosterPath, String backdropPath, double voteAverage, String releaseDate) {
        super(id, voteCount, title, originalTitile, overview, posterParth, bigPosterPath, backdropPath, voteAverage, releaseDate);
    }

    @Ignore
    public FavouriteMovie(Movie movie){
        super(movie.getId(), movie.getVoteCount(), movie.getTitle(), movie.getOriginalTitile(), movie.getOverview(), movie.getPosterParth(),  movie.getBigPosterPath(), movie.getBackdropPath(), movie.getVoteAverage(), movie.getReleaseDate());
    }
}
