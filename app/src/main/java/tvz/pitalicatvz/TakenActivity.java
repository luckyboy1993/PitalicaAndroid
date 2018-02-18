package tvz.pitalicatvz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tvz.pitalicatvz.models.Exam;
import tvz.pitalicatvz.remote.APIService;
import tvz.pitalicatvz.remote.ApiUtils;

public class TakenActivity extends AppCompatActivity {

    private APIService mAPIService;
    List<Exam> lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taken);

        ArrayList<String> listExams=null;
        final ListView list;

        mAPIService = ApiUtils.getAPIService();

        Bundle bundle = getIntent().getExtras();
        final String fullName = bundle.getString("fullName");
        final int id = bundle.getInt("id");

        GetExams(id);
        List<Exam> exams=lista;

        for(Exam ex : exams){
            listExams.add(ex.getExamTitle());
        }

        final ArrayAdapter<String> mArrayAdapter;
        mArrayAdapter = new ArrayAdapter<>(this, R.layout.simple_list_item, listExams);
        list = (ListView) findViewById(R.id.exams);
        list.setAdapter(mArrayAdapter);
    }

    private void GetExams(int id) {
        mAPIService.getExam(id).enqueue(new Callback<Exam>() {
            @Override
            public void onResponse(Call<Exam> call, Response<Exam> response) {
                String jsonString = response.body().toString();

                //Type listType = new TypeToken<List<Exam>>() {}.getType();
               // List<Exam> yourList = new Gson().fromJson(jsonString, listType);
            //lista=response.body();
                }

            @Override
            public void onFailure(Call<Exam> call, Throwable t) {

            }
        });
    }
}
