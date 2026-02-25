package co.edu.unipiloto.chatgasolinera;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    TextView tvHistorial;
    EditText etMensaje;
    Button btnEnviar;

    String historial = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvHistorial = findViewById(R.id.tvHistorial);
        etMensaje = findViewById(R.id.etMensaje);
        btnEnviar = findViewById(R.id.btnEnviar);

        // Recibir respuesta si viene desde EstacionActivity
        String mensajeRecibido = getIntent().getStringExtra("respuesta");
        String historialRecibido = getIntent().getStringExtra("historial");

        if(historialRecibido != null){
            historial = historialRecibido;
            tvHistorial.setText(historial);
        }

        if(mensajeRecibido != null){
            historial += "Estación: " + mensajeRecibido + "\n";
            tvHistorial.setText(historial);
        }

        btnEnviar.setOnClickListener(v -> {

            String mensaje = etMensaje.getText().toString().trim();

            if(!mensaje.isEmpty()){

                historial += "Cliente: " + mensaje + "\n";

                Intent intent = new Intent(MainActivity.this, EstacionActivity.class);
                intent.putExtra("mensaje", mensaje);
                intent.putExtra("historial", historial);

                startActivity(intent);
            }

        });
    }
}