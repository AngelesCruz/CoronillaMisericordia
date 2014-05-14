package com.oracion.coronillamisericordia;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.ImageView;

public class MainActivity extends ActionBarActivity implements OnClickListener{
	private int contador=0;
	ImageView img;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		
		img = (ImageView)findViewById(R.id.imgOracion);
		View boton = findViewById(R.id.btnNext);
		boton.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	

	@Override
	public void onClick(View arg0) {
		if(arg0.getId()==findViewById(R.id.btnNext).getId()){
			++contador;
			cambiaImagen();
		}else{
			--contador;
			cambiaImagen();
		}
		
		
	}
	
	private void cambiaImagen(){
		
		
		int ImagenInicial=R.drawable.ic_launcher;
		
		if(contador<4) 
		{
			switch(contador){
				case 1:
					
					img.setImageResource(R.drawable.padre);
					break;			
				case 2:
					img.setImageResource(R.drawable.ave);
					break;
				case 3:
					img.setImageResource(R.drawable.credo);
					break;
				default://si fuera 0 o negativo por ejemplo
					img.setImageResource(ImagenInicial);
					contador=0; //si fuera negativo 
					break;
			}
		}else if (contador>3 && contador<59){
			int moduloContador=(contador-3)%11;

			switch(moduloContador){
			case 1:
				img.setImageResource(R.drawable.mayores);
				break;			
			case 2:
				img.setImageResource(R.drawable.unoo);
				break;
			case 3:
				img.setImageResource(R.drawable.doso);
				break;
			case 4:
				img.setImageResource(R.drawable.treso);
				break;
			case 5:
				img.setImageResource(R.drawable.cuatroo);
				break;
			case 6:
				img.setImageResource(R.drawable.cincoo);
				break;
			case 7:
				img.setImageResource(R.drawable.seiso);
				break;
			case 8:
				img.setImageResource(R.drawable.sieteo);
				break;
			case 9:
				img.setImageResource(R.drawable.ochoo);
				break;
			case 10:
				img.setImageResource(R.drawable.nueveo);
				break;
			default://si sobran 0 quiere decir que est‡ en la cuenta 10 de las cuentas mayores
				img.setImageResource(R.drawable.diezo);
				break;
			}
			
		}else if (contador >58){
			int moduloContador=contador-58;
			
			switch(moduloContador){
			case 1:
				img.setImageResource(R.drawable.uno);
				break;			
			case 2:
				img.setImageResource(R.drawable.dos);
				break;
			case 3:
				img.setImageResource(R.drawable.tres);
				break;
			default://si excediera de los 61 volvemos a colocar la imagen inicial;
				img.setImageResource(ImagenInicial);
				contador=0; //y volvemos al contador 0
				break;
			}
			
		}
	}

}
