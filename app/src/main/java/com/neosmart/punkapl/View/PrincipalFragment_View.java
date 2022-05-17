package com.neosmart.punkapl.View;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.neosmart.punkapl.Controller.Principal_Controller;
import com.neosmart.punkapl.Interface.LoginInter;
import com.neosmart.punkapl.Interface.PrincipalInter;
import com.neosmart.punkapl.Model.Adapter;
import com.neosmart.punkapl.Model.AdapterCompleto;
import com.neosmart.punkapl.Model.Cerveza;
import com.neosmart.punkapl.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PrincipalFragment_View#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PrincipalFragment_View extends Fragment implements PrincipalInter.View {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
   // Adapter adapter;
    AdapterCompleto adapter;

    Boolean isScrolling = false;
    int currentItem, totalItem,scrollOutItem;
   // ArrayList listo;
    ArrayList <Cerveza> DatosObtenidos;
    String [] dto;
      ProgressBar progressBar;

    private PrincipalInter.Presenter principalPresenter;
    public PrincipalFragment_View() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PrincipalFragment_View.
     */
    // TODO: Rename and change types and number of parameters
    public static PrincipalFragment_View newInstance(String param1, String param2) {
        PrincipalFragment_View fragment = new PrincipalFragment_View();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_principal_view, container, false);

            recyclerView = (RecyclerView) v.findViewById(R.id.recyclerviewProductos);
        linearLayoutManager = new LinearLayoutManager(getContext());
        progressBar =(ProgressBar) v.findViewById(R.id.progress_circular);

        principalPresenter = new Principal_Controller(this);
        //listo= new ArrayList();
        DatosObtenidos = new ArrayList<Cerveza>();
        consumirDatos ();

      
        return v;
    }

    private void Mostrarlista() {

System.out.println ("Size "+DatosObtenidos.size());
       // adapter = new Adapter(listo,getContext());
        adapter= new AdapterCompleto(DatosObtenidos,getContext());

        adapter.setOnclikListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), " resultado  "+ DatosObtenidos.get(recyclerView.getChildLayoutPosition(v)).getName() , Toast.LENGTH_SHORT).show();
/*DetalleFragment detalleFragment = new DetalleFragment();
                detalleFragment.show(getChildFragmentManager(),);*/
            }
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull @NotNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                    isScrolling = true;
                }
            }
            @Override
            public void onScrolled(@NonNull @NotNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                currentItem=linearLayoutManager.getChildCount();
                totalItem = linearLayoutManager.getItemCount();
                scrollOutItem=linearLayoutManager.findFirstVisibleItemPosition();

                if (isScrolling && currentItem + scrollOutItem == totalItem){

                    isScrolling=false;
                    DateMethod();
                }
            }

        });

    }

    private void consumirDatos() {
        principalPresenter.GenerarDatos();
    }

    private void DateMethod() {
        progressBar.setVisibility(View.VISIBLE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                    for (int i=0;i<5;i++){
                   // listo.add(Math.floor(Math.random()*100)+ "");
                   //     DatosObtenidos.add(Math.floor(Math.random()*100)+ "");
                    adapter.notifyDataSetChanged();
                    progressBar.setVisibility(View.GONE);
                }
            }
        }, 5000);
    }





    @Override
    public void MostrarList(String resultado, List<Cerveza> body) {
      //  Toast.makeText(getContext(), " resultado  "+resultado , Toast.LENGTH_SHORT).show();


        if (resultado.equals("200")){
          //  Toast.makeText(getContext(), " resultado  "+resultado , Toast.LENGTH_SHORT).show();


            for (Cerveza cerveza:body){

                //listo.add(cerveza.getName());
              DatosObtenidos.add(cerveza);
            }

            Mostrarlista();
        
        }

    }
}