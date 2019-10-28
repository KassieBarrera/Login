package com.example.pruebalogin

class Persona {
    var imagen: Int? = null
    var nombre: String? = null
    var direccion: String? = null
    var telefono: String? = null
    var correo_electronico: String? = null
    var contrasenia: String? = null
    
    constructor(imagen: Int?, nombre: String?, direccion: String?, telefono: String?) {
        this.imagen = imagen
        this.nombre = nombre
        this.direccion = direccion
        this.telefono = telefono
    }

    constructor()
    
    internal fun setNombre(nombre: String?){
        this.nombre = nombre
    }

    internal fun getNombre(): String? {
        return nombre
    }

    internal fun setDireccino(direccion: String?){
        this.direccion = direccion
    }

    internal fun getDireccion(): String? {
        return direccion
    }
    
    internal fun setTelefono(telefono: String?){
        this.telefono = telefono
    }

    internal fun getTelefono(): String? {
        return telefono
    }

    fun setCorreo(correo: String?){
        this.correo_electronico = correo
    }
    
    fun getCorreo(): String?{
        return  correo_electronico
    }
    
    fun setConstrasenia(contrasenia: String?){
        this.contrasenia = contrasenia
    }
    
    fun getComtrasemnia(): String?{
        return contrasenia
    }

    override fun toString(): String {
        return "Persona(imagen=$imagen, nombre=$nombre, direccion=$direccion, telefono=$telefono)"
    }
}