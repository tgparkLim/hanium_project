package com.example.mtrust;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mtrust.ColorPickerDialog.OnColorChangedListener;

public class ControllFragment extends Fragment {

	
	private OnDataChangeListener mListener;

	public static ControllFragment newInstance() {
		return new ControllFragment();
	}

    private byte speed = 100;

    private TextView speedTV = null;

    private TextView directTV = null;

	private OnColorChangedListener onColorSelected = new OnColorChangedListener(){

		@Override
		public void colorChanged(String key, int color) {
			if (key.equals("chosen_led_color")){
				/*if (chosenColor != color){
					chosenColor = color;

					byte[] col = new byte[]{(byte) Color.red(chosenColor), (byte) Color.green(chosenColor), (byte) Color.blue(chosenColor)};
					
					mListener.OnDataChangeListener(col);


				}*/
			}
			
		}
	};
	/*private View.OnClickListener goCkickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {

            byte[] col = new byte[]{(byte) speed, (byte)-1, (byte)speed,(byte)-1};
            mListener.OnDataChangeListener(col);
        }
    };

    private View.OnClickListener backCkickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            byte[] col = new byte[]{(byte) speed, (byte)0, (byte)speed,(byte)0};
            mListener.OnDataChangeListener(col);
        }
    };

    private View.OnClickListener stopCkickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            byte[] col = new byte[]{(byte) 0, (byte)-1, (byte)0,(byte)-1};
            mListener.OnDataChangeListener(col);
        }
    };*/



	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_controll, container, false);

        speedTV = (TextView)v.findViewById(R.id.speedTV);
        directTV = (TextView)v.findViewById(R.id.directTV);
        JoystickView joy = (JoystickView)v.findViewById(R.id.joy_stick);
        //this.addContentView(v,  new WindowManager.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT));

        joy.setOnJoystickMoveListener(new JoystickView.OnJoystickMoveListener() {

            @Override
            public void onValueChanged(int angle, int power, int direction) {
                // TODO Auto-generated method stub
                //angleTextView.setText(" " + String.valueOf(angle) + "°");
                //powerTextView.setText(" " + String.valueOf(power) + "%");
                int i = (int)speed&0xff;
                switch (direction) {
                    case JoystickView.FRONT:
                        //directionTextView.setText(R.string.front_lab);
                        Log.i("joy","FRONT");
                        directTV.setText("FRONT");
                        if( mListener != null ){
                            if( i < 255 ){
                                speed =  (byte)(speed +1);
                            }
                            byte[] col = new byte[]{ (byte)(speed&0xff), -1, (byte)(speed&0xff), -1};
                            mListener.OnDataChangeListener(col);
                        }
                        break;
                    case JoystickView.FRONT_RIGHT:
                       // directionTextView.setText(R.string.front_right_lab);
                        Log.i("joy","BOTTOM_LEFT");
                        directTV.setText("BOTTOM_LEFT");
                        if( mListener != null ){
                            if( i < 255 ){
                                speed =  (byte)(speed +1);
                            }
                            byte[] col = new byte[]{(byte)( speed&0xff), (byte)-1, (byte)((speed&0xff) *( 0.5)), (byte)-1};
                            mListener.OnDataChangeListener(col);
                        }
                        break;
                    case JoystickView.LEFT_FRONT:
                        // directionTextView.setText(R.string.left_front_lab);
                        Log.i("joy","LEFT_FRONT");
                        directTV.setText("LEFT_FRONT");
                        if( mListener != null ){
                            if( i < 255 ){
                                speed =  (byte)(speed +1);
                            }
                            byte[] col = new byte[]{(byte)(( speed&0xff) * (0.5)), (byte)-1, (byte)(byte)( speed&0xff),(byte)-1};
                            mListener.OnDataChangeListener(col);
                        }
                        break;
                    case JoystickView.RIGHT:
                        //directionTextView.setText(R.string.right_lab);
                        Log.i("joy","RIGHT");
                        directTV.setText("LEFT");
                        if( mListener != null ){
                            if( i< 255 ){
                                speed =  (byte)(speed +1);
                            }
                            byte[] col = new byte[]{ (byte)( speed&0xff), (byte)-1, (byte)(( speed&0xff) * (0.2)),(byte)-1};
                            mListener.OnDataChangeListener(col);
                        }
                        break;
                    case JoystickView.LEFT:
                        // directionTextView.setText(R.string.left_lab);
                        Log.i("joy","LEFT");
                        directTV.setText("RIGHT");
                        if( mListener != null ){
                            if( i < 255 ){
                                speed =  (byte)(speed +1);
                            }
                            byte[] col = new byte[]{(byte)(( speed&0xff) * (0.2)), (byte)-1, (byte)( speed&0xff),(byte)-1};
                            mListener.OnDataChangeListener(col);
                        }
                        break;
                    case JoystickView.RIGHT_BOTTOM:
                        //directionTextView.setText(R.string.right_bottom_lab);
                        Log.i("joy","BOTTOM_LEFT");
                        directTV.setText("BOTTOM_LEFT");
                        if( mListener != null ){
                            if( i < 255 ){
                                speed =  (byte)(speed +1);
                            }
                            byte[] col = new byte[]{(byte)( speed&0xff), (byte)-1, (byte)(( speed&0xff) * (0.5)),(byte)-1};
                            mListener.OnDataChangeListener(col);
                        }
                        break;
                    case JoystickView.BOTTOM:
                       // directionTextView.setText(R.string.bottom_lab);
                        Log.i("joy","BOTTOM");
                        directTV.setText("BOTTOM");
                        if( mListener != null ){


                            byte[] col = new byte[]{(byte) 100, (byte)0, (byte)100,(byte)0};
                            mListener.OnDataChangeListener(col);
                        }
                        break;
                    case JoystickView.BOTTOM_LEFT:
                       // directionTextView.setText(R.string.bottom_left_lab);
                        Log.i("joy","RIGHT_BOTTOM");
                        directTV.setText("RIGHT_BOTTOM");
                        if( mListener != null ){
                            if( i < 255 ){
                                speed =  (byte)(speed +1);
                            }
                            byte[] col = new byte[]{ (byte)(100 * 0.5), (byte)0, (byte)100,(byte)0};
                            mListener.OnDataChangeListener(col);
                        }
                        break;

                    default:
                       // directionTextView.setText(R.string.center_lab);
                        Log.i("joy","stop");
                        directTV.setText("stop");
                        if( mListener != null ){

                            byte[] col = new byte[]{(byte) 0, (byte)0, (byte)0,(byte)0};
                            speed = 100;
                            mListener.OnDataChangeListener(col);
                        }
                }
                Log.i("speed", String.valueOf(i));
                speedTV.setText(String.valueOf(i));
            }
        }, JoystickView.DEFAULT_LOOP_INTERVAL);
		return v;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			mListener = (OnDataChangeListener) activity;
            byte[] col = new byte[]{(byte) 0, (byte)-1, (byte)0,(byte)-1};
           if(mListener!=null) mListener.OnDataChangeListener(col);
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
