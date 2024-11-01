package com.idat.app;

import com.idat.entity.IntervalosHorarios;
import com.idat.service.ServicioIntervalosHorarios;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "WSIntervalosHorarios")
public class WSIntervalosHorarios {
    @WebMethod(operationName = "ayuda")
    public String ayuda(@WebParam(name = "name") String nombre) {
        return "Autor " + nombre + " !";
    }

    @WebMethod(operationName = "listadoIntervalosHorarios")
    public List<IntervalosHorarios> listadoIntervalosHorarios(){
        System.out.println("Obteniendo listado de intervalos horarios...");
        ServicioIntervalosHorarios servicio = new ServicioIntervalosHorarios();
        IntervalosHorarios p = new IntervalosHorarios();
        
        p.setIdIntervaloHorario(0);
        p.setIntervaloHorario("");
        p.setNumeroVehiculos(0);
        
        List<IntervalosHorarios> lista = servicio.operacionesLectura("ConsultarTodo", p);
        return lista;
    }
}
