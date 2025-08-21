package br.edu.fatecpg.appduastelas

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ProdutoActivity : AppCompatActivity(R.layout.activity_produto) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val txvProduto = findViewById<TextView>(R.id.txv_produto);
        val fabVolta = findViewById<FloatingActionButton>(R.id.fab_volta);

        txvProduto.text = intent.getStringExtra("produto")
        fabVolta.setOnClickListener(){
            finish()
        }
    }
}