package isa.appfinalandroid;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import isa.appfinalandroid.models2.EscenariosDeportivos;


/**
 * A simple {@link Fragment} subclass.
 */
public class InicioFragment extends Fragment {
    private FragmentActivity myContext;
    private Button btncero,btnuno;
    public InicioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_inicio, container, false);
        btncero= (Button) view.findViewById(R.id.button2);
        btnuno= (Button) view.findViewById(R.id.button3);

        btncero.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Fragment fragment = null;
                Class fragmentClass= EscenariosDeportivosFragment.class;
                try{
                    fragment = (Fragment) fragmentClass.newInstance();
                }catch (Exception e){
                    e.printStackTrace();
                }
                FragmentManager fragmentManager=myContext.getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();


            }
        });
        btnuno.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Fragment fragment = null;
                Class fragmentClass= MunicipiosFragment.class;
                try{
                    fragment = (Fragment) fragmentClass.newInstance();
                }catch (Exception e){
                    e.printStackTrace();
                }
                FragmentManager fragmentManager=myContext.getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();


            }
        });
        return  view;
    }

    @Override
    public void onAttach(Context context) {

        myContext=(FragmentActivity) context;
        super.onAttach(context);
    }

}
