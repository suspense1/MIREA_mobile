package ru.mirea.ishutin.retrofitapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TodoAdapter extends RecyclerView.Adapter<TodoViewHolder> {

    private LayoutInflater layoutInflater;
    private List<Todo> todos;

    public TodoAdapter(Context context, List<Todo> todos) {
        this.layoutInflater = LayoutInflater.from(context);
        this.todos = todos;
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.view_item, parent, false);
        return new TodoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {
        Todo todo = todos.get(position);

        holder.textViewTitle.setText(todo.getTitle());
        holder.checkBoxCompleted.setChecked(todo.getCompleted());

        holder.checkBoxCompleted.setOnCheckedChangeListener((compoundButton, b) -> {
            todo.setCompleted(b);
            updateTodoStatus(todo.getId(), b);
        });

        String[] images = new String[] {
                "https://wallpapers.com/images/hd/3d-waterfall-1920-x-1280-wallpaper-h3mefn9cnkbhgzb8.jpg",
                "https://i.pinimg.com/originals/7c/05/c7/7c05c76d378e5f8ce93705c46c518082.jpg",
                "https://i.pinimg.com/originals/a1/57/e3/a157e33152dbf0d9da5627b28a070bd6.jpg",
                "https://cs.pikabu.ru/post_img/big/2013/10/25/8/1382701770_1701474195.jpg",
                "https://i.pinimg.com/originals/36/76/99/36769945f37cb48d1cc24ba4dc724d94.jpg"
        };
        Picasso.get()
                .load(images[new Random().nextInt(images.length)])
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .resize(50, 50)
                .centerCrop()
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error)
                .into(holder.imageView, new com.squareup.picasso.Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError(Exception e) {
                        Log.d("ERROR", "Error: " + e.getMessage());
                    }
                });
    }

    @Override
    public int getItemCount() {
        return todos.size();
    }

    private void updateTodoStatus(int todoId, boolean completed) {
        ApiService api = RetrofitClient.getRetrofitInstance().create(ApiService.class);
        Todo targetTodo = todos.get(todoId);
        targetTodo.setCompleted(completed);


        Call<Todo> call = api.updateTodo(todoId, targetTodo);
        call.enqueue(new Callback<Todo>() {
            @Override
            public void onResponse(Call<Todo> call, Response<Todo> response) {
                if (response.isSuccessful()) {
                    Log.e("MAIN", "ToDo updated: " + response.code());
                } else {
                    Log.e("MAIN", "onResponse: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<Todo> call, Throwable t) {
                Log.e("MAIN", "onFailure:	" + t.getMessage());
            }
        });
    }
}
