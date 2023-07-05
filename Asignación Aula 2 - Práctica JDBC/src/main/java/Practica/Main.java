package Practica;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import Practica.controladores.CrudTradicionalControlador;

public class Main {
    public static void main(String[] args) {
        var app = Javalin.create(config ->{
            //configurando los documentos estaticos.
            config.staticFiles.add(staticFileConfig -> {
                staticFileConfig.hostedPath = "/";
                staticFileConfig.directory = "/publico";
                staticFileConfig.location = Location.CLASSPATH;
                staticFileConfig.precompress=false;
                staticFileConfig.aliasCheck=null;
            });}).start(7001);

        new CrudTradicionalControlador(app).aplicarRutas();

    }
}