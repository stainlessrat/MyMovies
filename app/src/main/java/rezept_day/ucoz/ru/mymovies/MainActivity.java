package rezept_day.ucoz.ru.mymovies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.ArrayList;

import rezept_day.ucoz.ru.mymovies.data.Movie;
import rezept_day.ucoz.ru.mymovies.utils.JSONUtils;
import rezept_day.ucoz.ru.mymovies.utils.NetworkUtils;

public class MainActivity extends AppCompatActivity {

    private Switch switchSort;
    private TextView textViewPopularity;
    private TextView textViewTopRated;
    private RecyclerView recyclerViewPosters;
    private MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();

        adapter = new MovieAdapter();
        recyclerViewPosters.setLayoutManager(new GridLayoutManager(this, 2));

        recyclerViewPosters.setAdapter(adapter);

        switchSort.setChecked(true);
        switchSort.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setMethodOfSort(isChecked);
            }
        });
        switchSort.setChecked(false);
    }

    private void initUI() {
        textViewPopularity = findViewById(R.id.textViewPopularity);
        textViewTopRated = findViewById(R.id.textViewTopRated);
        switchSort = findViewById(R.id.switchSort);
        recyclerViewPosters = findViewById(R.id.recyclerViewPosters);
    }

    public void onClickPopularity(View view) {
        setMethodOfSort(false);
        switchSort.setChecked(false);
    }

    public void onClickRated(View view) {
        setMethodOfSort(true);
        switchSort.setChecked(true);
    }

    private void setMethodOfSort(boolean isTopRated){
        int methodOfSort;
        if(isTopRated){
            textViewTopRated.setTextColor(getResources().getColor(R.color.colorAccent));
            textViewPopularity.setTextColor(getResources().getColor(R.color.white_color));
            methodOfSort = NetworkUtils.TOP_RATED;
        }else{
            textViewTopRated.setTextColor(getResources().getColor(R.color.white_color));
            textViewPopularity.setTextColor(getResources().getColor(R.color.colorAccent));
            methodOfSort = NetworkUtils.POPULARITY;
        }
        JSONObject jsonObject = NetworkUtils.getJSONFromNetwork(methodOfSort,1);
        ArrayList<Movie> movies = JSONUtils.getMoviesFromJSON(jsonObject);
        adapter.setMovies(movies);
    }
}
