package moviles.ejercicio7

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import moviles.ejercicio7.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inicializarbinding()
        inicializarEventos()
    }
    fun inicializarEventos(){
        binding.btnSeleccionarCurso.setOnClickListener{
            val curso = binding.spiCurso.selectedItem.toString()
            val asignatura = getAsignaturas(curso)
            binding.txtAsignatura.text = darFormato(asignatura)

        }
    }
    fun inicializarbinding(){
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    fun getAsignaturas(curso:String):List<String> =
        when(curso){
            "1º DAM" -> listOf("Programación", "Sistemas","Base de datos", "Entornos", "Marcas")
            "2º DAM" -> listOf("Móviles", "Interfaces","Acceso a datos","Servicios","Sistemas Gestión Empresarial")
            else -> throw Exception("Curso no admitido")
        }
    fun darFormato(lista:List<String>):String =
        lista
            .map{ asignatura -> "- ${asignatura}\n" }
            .joinToString( "" )
}