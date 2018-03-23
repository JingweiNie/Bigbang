package fragments;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.niejingwei.bigbang.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserFragment extends Fragment {

    private View rootview;
    public UserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Context context= new ContextThemeWrapper(getActivity(),R.style.userPanelTheme);
        LayoutInflater layoutInflater=inflater.cloneInContext(context);
        rootview=layoutInflater.inflate(R.layout.fragment_user, container, false);
        return rootview;
    }

}
