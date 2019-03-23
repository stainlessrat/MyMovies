package rezept_day.ucoz.ru.mymovies;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import rezept_day.ucoz.ru.mymovies.data.FavouriteMovie;
import rezept_day.ucoz.ru.mymovies.data.MainViewModel;
import rezept_day.ucoz.ru.mymovies.data.Movie;

public class DetailActivity extends AppCompatActivity {

    private ImageView imageViewBigPoster, imageViewAddToFavourite;
    private TextView textViewTitle, textViewOriginalTitle, textViewRating,
                        textViewReleaseDate, textViewOverview;

    private int id;
    private MainViewModel viewModel;
    private Movie movie;
    private FavouriteMovie favouriteMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initUI();

        Intent intent = getIntent();
        if(intent != null && intent.hasExtra("id")){
            id = intent.getIntExtra("id", -1);
        } else {
            finish();//Закрывает активность и будет открыта активность, которая ее вызвала
        }

        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        movie = viewModel.getMovieById(id);
        Picasso.get().load(movie.getBigPosterPath()).into(imageViewBigPoster);
        textViewTitle.setText(movie.getTitle());
        textViewOriginalTitle.setText(movie.getOriginalTitile());
        textViewRating.setText(Double.toString(movie.getVoteAverage()));
        textViewReleaseDate.setText(movie.getReleaseDate());
        textViewOverview.setText(movie.getOverview());
        setFavourite();
    }

    private void initUI() {
        imageViewBigPoster = findViewById(R.id.imageViewBigPoster);
        imageViewAddToFavourite = findViewById(R.id.imageViewAddToFavorite);
        textViewTitle = findViewById(R.id.textViewTitle);
        textViewOriginalTitle = findViewById(R.id.textViewOriginTitle);
        textViewRating = findViewById(R.id.textViewRating);
        textViewReleaseDate = findViewById(R.id.textViewReleaseDate);
        textViewOverview = findViewById(R.id.textViewOverview);

    }

    public void onClickChangeFavorite(View view) {
        if(favouriteMovie == null){
            viewModel.insertFavouriteMovie(new FavouriteMovie(movie));
            Toast.makeText(this, getString(R.string.add_to_favourite), Toast.LENGTH_SHORT).show();
        }
        else{
            viewModel.deleteFavouriteMovie(favouriteMovie);
            Toast.makeText(this, getString(R.string.remove_to_favourite), Toast.LENGTH_SHORT).show();
        }
        setFavourite();
    }
    private void setFavourite(){
        favouriteMovie = viewModel.getFavouriteMovieById(id);
        if (favouriteMovie == null){
            imageViewAddToFavourite.setImageResource(R.drawable.favourite_add_to);
        }else{
            imageViewAddToFavourite.setImageResource(R.drawable.favourite_remove);
        }
    }
}
