package com.example.floword;

import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import retrofit2.Call;
import retrofit2.Callback;
// 确保导入正确的 BuildConfig


public class MainActivity extends AppCompatActivity {
    private EditText input;
    private Button bt_search;
    private TextView title;
    private TextView name;
    private TextView name_des;
    private TextView lang;
    private TextView lang_des;
    private TextView stone;
    private TextView stone_des;
    private TextView legend;
    private ScrollView scrollView;
    private ImageView flower;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        initView();
        bt_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchData();
            }
        });

        Glide.with(this)
                .asGif()
                .load(R.drawable.flower)
                .placeholder(R.drawable.flower)
                .error(R.drawable.flower)
                .into(flower);
    }

    private void initView() {
        input = findViewById(R.id.input);
        bt_search = findViewById(R.id.bt_search);
        title = findViewById(R.id.title);
        name = findViewById(R.id.name);
        name_des = findViewById(R.id.name_des);
        lang = findViewById(R.id.lang);
        lang_des = findViewById(R.id.lang_des);
        stone = findViewById(R.id.stone);
        stone_des = findViewById(R.id.stone_des);
        legend = findViewById(R.id.legend);
        scrollView = findViewById(R.id.scrollView);
        flower = findViewById(R.id.flower);
    }

    private void fetchData() {
        String apikey = "bd377a764430efa6e6ac0b04530ad069";
        String key = input.getText().toString().trim();

        ApiService apiService = RetrofitClient.getInstance().getApiService();
        Call<Response> call = apiService.getBirthdayFlower(key, apikey);
        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if (response.isSuccessful() && response.body() != null)
                {
                    Response response1 = response.body();
                    updateUI(response1);
                }else {
                    Log.e("MainActivity", "请求失败，状态码: " + response.code());
                    Toast.makeText(MainActivity.this, "获取用户信息失败: " + response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                Log.e("MainActivity", "网络请求出错: " + t.getMessage());
                Toast.makeText(MainActivity.this, "网络错误: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateUI(Response response) {
        // 1. 检查传入的整个 response 对象是否为 null
        if (response == null) {
            Log.w("MainActivity", "updateUI 收到了一个 null 的 response");
            return;
        }

        // 2. 检查你真正关心的数据对象是否为 null
        Response.ResultDTO result = response.getResult(); // 假设你的 Response 类有 getResult() 方法
        if (result == null) {
            Log.w("MainActivity", "Response 中的 ResultDTO 为 null");
            Toast.makeText(this, "数据为空，请稍后再试", Toast.LENGTH_SHORT).show();
            return;
        }

        title.setText(Html.fromHtml(response.getResult().getTitle(), Html.FROM_HTML_MODE_LEGACY));
        name.setText(Html.fromHtml(response.getResult().getName(), Html.FROM_HTML_MODE_LEGACY));
        name_des.setText(Html.fromHtml(response.getResult().getName_des(), Html.FROM_HTML_MODE_LEGACY));
        lang.setText(Html.fromHtml(response.getResult().getLang(), Html.FROM_HTML_MODE_LEGACY));
        lang_des.setText(Html.fromHtml(response.getResult().getLang_des(), Html.FROM_HTML_MODE_LEGACY));
        stone.setText(Html.fromHtml(response.getResult().getStone(), Html.FROM_HTML_MODE_LEGACY));
        stone_des.setText(Html.fromHtml(response.getResult().getStone_des(), Html.FROM_HTML_MODE_LEGACY));
        legend.setText(Html.fromHtml(response.getResult().getLegend(), Html.FROM_HTML_MODE_LEGACY));
        scrollView.setVisibility(View.VISIBLE);
    }
}