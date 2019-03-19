package rezept_day.ucoz.ru.mymovies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONObject;

import rezept_day.ucoz.ru.mymovies.utils.NetworkUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JSONObject jsonObject = NetworkUtils.getJSONFromNetwork(NetworkUtils.TOP_RATED, 3);
        if(jsonObject == null){
            Toast.makeText(this, "Произошла ошибка", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Успешно загружено", Toast.LENGTH_SHORT).show();
        }
    }
}
