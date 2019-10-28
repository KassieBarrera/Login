package com.example.pruebalogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.SearchView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_usuarios.*
import org.json.JSONArray
import org.json.JSONObject
import android.widget.SearchView.OnQueryTextListener as OnQueryTextListener1

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    val url = "https://serviciowebintecap.000webhostapp.com/sw.php"
    var mPersonList = ArrayList<Persona>()
    lateinit var mPersona: Persona

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getDatos()


        btn_login.setOnClickListener {
            val usuario: String = edtUser.text.toString()
            val pass: String = edtPass.text.toString()
            //Toast.makeText(this, "usuario: $usuario pass: $pass", Toast.LENGTH_SHORT).show()
            ConfirmarUsuario(usuario, pass)
        }

    }

    fun getDatos() {
        val requestQueue = Volley.newRequestQueue(this@MainActivity)
        val request = JsonObjectRequest(Request.Method.GET, url, null,
            Response.Listener { response ->
                val json: JSONArray = response.optJSONArray("clientes")
                for (i in 0 until json.length()) {
                    mPersona = Persona()
                    val jsonObject: JSONObject? = null
                    val item = json.getJSONObject(i)

                    mPersona.setNombre(item.optString("nombre"))
                    mPersona.setNombre(item.optString("nombre"))
                    mPersona.setTelefono(item.optString("telefono"))
                    mPersona.setDireccino(item.optString("direccion"))
                    mPersona.setCorreo(item.optString("correo_electronico"))
                    mPersona.setConstrasenia(item.optString("contrasenia"))

                    mPersonList.add(mPersona)
                }

                /*adaptador = Adaptador(this, mPersonList)
                gridView.adapter = adaptador*/
            }, Response.ErrorListener {
                Toast.makeText(this, "No se pudo conectar", Toast.LENGTH_SHORT).show()
                Log.d(TAG, "Persona: Error ... no se pudo conectar")
            })
        requestQueue.add(request)
    }

    fun ConfirmarUsuario(user: String, contra: String): Boolean {
        val nPersonaLst = ArrayList<Persona>()
        var usuario: Persona
        for (usuario in mPersonList)
            if (usuario.getComtrasemnia().equals(contra) || usuario.getCorreo().equals(user)) {
                nPersonaLst.add(usuario)
                val intent = Intent(this, Usuarios::class.java)
                startActivity(intent)
            }
        if (contra.equals("") || user.equals("")) {
            Toast.makeText(this, "Datos vacios", Toast.LENGTH_SHORT).show()
        } else {
            error.text = "Usuario o contraseña invalidos"

        }
        return false
    }
}



