package com.idat.dao;

import com.idat.entity.IntervalosHorarios;
import java.util.List;

public interface IIntervalosHorariosDao {
    // INSERT, DELETE, UPDATE
    public int operacionesEscritura(String indicador, IntervalosHorarios p);
    // SELECT 
    public List<IntervalosHorarios> operacionesLectura(String indicador, IntervalosHorarios p);
}
