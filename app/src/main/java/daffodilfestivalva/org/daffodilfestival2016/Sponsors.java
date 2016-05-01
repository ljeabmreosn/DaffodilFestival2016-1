package daffodilfestivalva.org.daffodilfestival2016;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Sponsors extends Fragment {


    public Sponsors() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        /*View view = inflater.inflate(R.layout.fragment_sponsors, container, false);
        Typeface myTypeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/COOPBL.TTF");
        TextView tv = (TextView) view.findViewById(R.id.textview1);
        tv.setTypeface(myTypeface);

        return view;*/
        return inflater.inflate(R.layout.fragment_sponsors, container, false);
    }

}
