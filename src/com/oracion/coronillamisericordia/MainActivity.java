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
import android.widget.TextView;

public class MainActivity extends ActionBarActivity implements OnClickListener{
	private int contador=0;
	ImageView img;
	TextView txt;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		txt=(TextView)findViewById(R.id.texto);
		
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
		
		
		int ImagenInicial=R.drawable.cero;
		
		if(contador<4) 
		{
			switch(contador){
				case 1:
					img.setImageResource(R.drawable.unoo);
					txt.setText(R.string.padre);
					break;			
				case 2:
					img.setImageResource(R.drawable.doso);
					txt.setText(R.string.ave);
					break;
				case 3:
					img.setImageResource(R.drawable.treso);
					txt.setText(R.string.credo);
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
				//cuentas mayores
				img.setImageResource(ImagenInicial);
				txt.setText(R.string.cuentasmayores);
				break;			
			case 2:
				img.setImageResource(R.drawable.uno);
				txt.setText(R.string.cuentasmenores);
				break;
			case 3:
				img.setImageResource(R.drawable.dos);
				txt.setText(R.string.cuentasmenores);
				break;
			case 4:
				img.setImageResource(R.drawable.tres);
				txt.setText(R.string.cuentasmenores);
				break;
			case 5:
				img.setImageResource(R.drawable.cuatro);
				txt.setText(R.string.cuentasmenores);
				break;
			case 6:
				img.setImageResource(R.drawable.cinco);
				txt.setText(R.string.cuentasmenores);
				break;
			case 7:
				img.setImageResource(R.drawable.seis);
				txt.setText(R.string.cuentasmenores);
				break;
			case 8:
				img.setImageResource(R.drawable.siete);
				txt.setText(R.string.cuentasmenores);
				break;
			case 9:
				img.setImageResource(R.drawable.ocho);
				txt.setText(R.string.cuentasmenores);
				break;
			case 10:
				img.setImageResource(R.drawable.nueve);
				txt.setText(R.string.cuentasmenores);
				break;
			default://si sobran 0 quiere decir que est‡ en la cuenta 10 de las cuentas mayores
				img.setImageResource(R.drawable.diez);
				txt.setText(R.string.cuentasmenores);
				break;
			}
			
		}else if (contador >58){
			int moduloContador=contador-58;
			
			switch(moduloContador){
			case 1:
				img.setImageResource(R.drawable.unoo);
				txt.setText(R.string.santo);
				break;			
			case 2:
				img.setImageResource(R.drawable.doso);
				txt.setText(R.string.santo);
				break;
			case 3:
				img.setImageResource(R.drawable.treso);
				txt.setText(R.string.santo);
				break;
			case 4:
				//Áoh mi amado y dulce amigo!
				img.setImageResource(ImagenInicial);
				txt.setText(R.string.oracionJesus);
				break;
			default://si excediera de los 62 volvemos a colocar la imagen inicial;
				img.setImageResource(ImagenInicial);
				contador=0; //y volvemos al contador 0
				break;
			}
			
		}
	}

}
