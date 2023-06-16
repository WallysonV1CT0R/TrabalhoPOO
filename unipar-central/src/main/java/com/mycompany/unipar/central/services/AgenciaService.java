package com.mycompany.unipar.central.services;

import com.mycompany.unipar.central.exceptions.CampoNaoInformadoException;
import com.mycompany.unipar.central.exceptions.EntidadeNaoInformadaException;
import com.mycompany.unipar.central.exceptions.TamanhoCampoInvalidoException;
import com.mycompany.unipar.central.model.Agencia;
import com.mycompany.unipar.central.repositories.AgenciaDAO;

import java.sql.SQLException;
import java.util.List;

public class AgenciaService {
    public void validar(Agencia agencia) throws EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {
        if (agencia == null) {
            throw new EntidadeNaoInformadaException("Agência");
        }

        if (agencia.getAgencia() == null || agencia.getAgencia().isEmpty() || 
                agencia.getAgencia().isBlank()) {
            throw new CampoNaoInformadoException("Número da agência");
        }
    }

    public List<Agencia> findAll() throws SQLException {
        AgenciaDAO agenciaDAO = new AgenciaDAO();
        return agenciaDAO.findAll();
    }

    public Agencia findById(int id) throws SQLException, 
            TamanhoCampoInvalidoException, 
            Exception {
        if (id <= 0) {
            throw new TamanhoCampoInvalidoException("ID", 1);
        }

        AgenciaDAO agenciaDAO = new AgenciaDAO();
        Agencia agencia = agenciaDAO.findById(id);

        if (agencia == null) {
            throw new Exception("Não foi possível encontrar uma "
                    + "agência com o ID informado: " + id);
        }

        return agencia;
    }

    public void insert(Agencia agencia) throws SQLException, 
            EntidadeNaoInformadaException,
            CampoNaoInformadoException, 
            TamanhoCampoInvalidoException {
        validar(agencia);

        AgenciaDAO agenciaDAO = new AgenciaDAO();
        agenciaDAO.insert(agencia);
    }

    public void update(Agencia agencia) throws SQLException, 
            EntidadeNaoInformadaException,
            CampoNaoInformadoException, 
            TamanhoCampoInvalidoException {
        validar(agencia);

        AgenciaDAO agenciaDAO = new AgenciaDAO();
        agenciaDAO.update(agencia);
    }

    public void delete(int id) throws SQLException {
        AgenciaDAO agenciaDAO = new AgenciaDAO();
        agenciaDAO.delete(id);
    }
}
