package co.edu.unipiloto.chatgasolinera;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;

public class EstacionActivity extends AppCompatActivity {

    TextView tvHistorial;
    EditText etMensaje;
    Button btnEnviar;

    String historial = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estacion);

        tvHistorial = findViewById(R.id.tvHistorial);
        etMensaje = findViewById(R.id.etMensaje);
        btnEnviar = findViewById(R.id.btnEnviar);

        // Recibir datos del Cliente
        String mensajeCliente = getIntent().getStringExtra("mensaje");
        String historialRecibido = getIntent().getStringExtra("historial");

        if(historialRecibido != null){
            historial = historialRecibido;
            tvHistorial.setText(historial);
        }

        if(mensajeCliente != null){
            historial += "Cliente: " + mensajeCliente + "\n";
            tvHistorial.setText(historial);
        }

        btnEnviar.setOnClickListener(v -> {

            String respuesta = etMensaje.getText().toString().trim();

            if(!respuesta.isEmpty()){

                historial += "Estación: " + respuesta + "\n";

                Intent intent = new Intent(EstacionActivity.this, MainActivity.class);
                intent.putExtra("respuesta", respuesta);
                intent.putExtra("historial", historial);

                startActivity(intent);
            }

        });
    }
}