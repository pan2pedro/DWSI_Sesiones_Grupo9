package com.idat.service;

import com.idat.dao.IIntervalosHorariosDao;
import com.idat.dao.daoImpl.IntervalosHorariosDaoImpl;
import com.idat.entity.IntervalosHorarios;
import java.util.List;

public class ServicioIntervalosHorarios {
    public int operacionesEscritura(String indicador, IntervalosHorarios p){
        IIntervalosHorariosDao dao = new IntervalosHorariosDaoImpl();
        return dao.operacionesEscritura(indicador, p);
    }
    
    public List<IntervalosHorarios> operacionesLectura(String indicador, IntervalosHorarios p){
        IIntervalosHorariosDao dao = new IntervalosHorariosDaoImpl();
        return dao.operacionesLectura(indicador, p);
    }
}
