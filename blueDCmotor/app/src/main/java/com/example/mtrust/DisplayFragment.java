package com.example.mtrust;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mtrust.ColorPickerDialog.OnColorChangedListener;

public class DisplayFragment extends Fragment {
	ColorPickerDialog colorPicker;
	int chosenColor = Color.RED;
	
	private OnDataChangeListener mListener;

	public static DisplayFragment newInstance() {
		return new DisplayFragment();
	}

	private OnColorChangedListener onColorSelected = new OnColorChangedListener(){

		@Override
		public void colorChanged(String key, int color) {
			if (key.equals("chosen_led_color")){
				if (chosenColor != color){
					chosenColor = color;

					byte[] col = new byte[]{(byte) Color.red(chosenColor), (byte) Color.green(chosenColor), (byte) Color.blue(chosenColor)};
					
					mListener.OnDataChangeListener(col);

				}
			}
			
		}
	};
	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_display, container, false);
		if (v != null) {
			colorPicker = new ColorPickerDialog(this.getActivity(), onColorSelected, "chosen_led_color" , Color.RED, Color.BLUE); 
			
			colorPicker.show();
		}
		return v;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			mListener = (OnDataChangeListener) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ " must implement OnFragmentInteractionListener");
		}
	}

	@Override
	public void onDetach() {
		super.onDetach();
		mListener = null;
	}

	public interface OnDataChangeListener {
		public void OnDataChangeListener(byte[] val);
	}	
}
