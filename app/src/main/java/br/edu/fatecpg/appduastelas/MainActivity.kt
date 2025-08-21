package br.edu.fatecpg.appduastelas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.fatecpg.appduastelas.model.Produto
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // linha 14 pode tirar ou minimizar
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtNomeProduto = findViewById<EditText>(R.id.edt_nome_produto);
        val edtValorProduto = findViewById<EditText>(R.id.edt_valor_produto);
        val btnCadastrar = findViewById<Button>(R.id.btn_cadastrar);
        val fabButton = findViewById<FloatingActionButton>(R.id.fab_avancar);
        var prod = Produto("Sem Produto", 0.0);

        btnCadastrar.setOnClickListener(){
            val nome = edtNomeProduto.text.toString();
            val preco = edtValorProduto.text.toString().toDouble();
            prod = Produto(nome, preco);
        }
        // enviado os dados do produto para outra tela
        fabButton.setOnClickListener(){
            val intent = Intent(this, ProdutoActivity::class.java)
            intent.putExtra("produto", prod.toString())
            startActivity(intent)
        }
    }
}