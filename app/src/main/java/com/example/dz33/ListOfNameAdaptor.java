package com.example.dz33;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListOfNameAdaptor extends RecyclerView.Adapter<ListOfNameAdaptor.NameViewHolder> {

    private List<String> ListofName;

    //ListofFragment - список который будет приходить из фрагмента
    // и его данные будут присваеватся списку ListOfName
    /*public ListOfNameAdaptor(List<String> listofName) {
        ListofName = listofName;
        notifyDataSetChanged();
    }*/

    //ListofFragment - список который будет приходить из фрагмента
    // и его данные будут присваеватся списку ListOfName
    public void setData(List<String> ListFromFragment) {
        this.ListofName = ListFromFragment;

        //метод для обновления адаптора
        notifyDataSetChanged();
    }


    // адаптор урпавлнние данными
    // coздание экземпляра гащнго рецйцолер вью
    //метод отвечает за созадание ViewHoldera и передает ему созданый Layout(xml)
    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NameViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_name, parent, false));
    }

    // мктод отвечает за привязку данных из списка(ListOfName) и viewшек из ViewHolder
    @Override
    public void onBindViewHolder(@NonNull NameViewHolder holder, int position) {
        holder.onBind(ListofName.get(position));

    }

    // метод возврощающий (отвечающий за) количество элементов в списке (ListOfName)
    @Override
    public int getItemCount() {
        return ListofName.size();
    }

    // Класс отвечающий за упаковку данных в view
    public class NameViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;

        // Конструктор для ViewHolder
        public NameViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
        }


        // Метод отвечающий за привязку данных внутри ViewHolder
        public void onBind(String name) {
            tvName.setText(name);
        }
    }
}
