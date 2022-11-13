package com.example.dz33;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class RecyclerFragment extends Fragment {

    // Список который мы заполним данными и передадим в адаптор
    private final List<String> ListFromFragment = new ArrayList<>();

    //Создание экземпляра адаптора
    private ListOfNameAdaptor adaptor = new ListOfNameAdaptor();
    private RecyclerView rvListOfName;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recycler, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvListOfName = view.findViewById(R.id.rv_list_of_name);

        // Заполняем наш список во фрагменте(ListFromFragment)
        ListFromFragment.add("Нурс");
        ListFromFragment.add("Фарух");
        ListFromFragment.add("Жайыл");
        ListFromFragment.add("Азизи");
        ListFromFragment.add("Данилка");
        ListFromFragment.add("Ази");
        ListFromFragment.add("Умар");
        ListFromFragment.add("Арстан");
        ListFromFragment.add("Тима");
        ListFromFragment.add("Русик");
        ListFromFragment.add("Вася");
        ListFromFragment.add("Тоха");
        ListFromFragment.add("Кеша");
        ListFromFragment.add("Саня");
        ListFromFragment.add("Петя");
        initialize();
        // Передаем наш заполненый список в наш адаптор
        adaptor.setData(ListFromFragment);

    }

    // Указываем ориентацию для нашего RecyclerView
    private void initialize() {
        rvListOfName.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));

        // Передаем нашему RecyclerView  наш адаптор
        rvListOfName.setAdapter(adaptor);

    }
}