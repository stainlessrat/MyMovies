package rezept_day.ucoz.ru.mymovies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.ArrayList;

import rezept_day.ucoz.ru.mymovies.data.Movie;
import rezept_day.ucoz.ru.mymovies.utils.JSONUtils;
import rezept_day.ucoz.ru.mymovies.utils.NetworkUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JSONObject jsonObject = NetworkUtils.getJSONFromNetwork(NetworkUtils.POPULARITY, 5);
        ArrayList<Movie> movies = JSONUtils.getMoviesFromJSON(jsonObject);

        StringBuilder builder = new StringBuilder();
        for(Movie movie: movies){
            builder.append(movie.getTitle()).append("\n");
        }
        Log.i("MyMovies", builder.toString());
    }
}
