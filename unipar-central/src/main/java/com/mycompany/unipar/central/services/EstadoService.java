package com.mycompany.unipar.central.services;

import com.mycompany.unipar.central.exceptions.CampoNaoInformadoException;
import com.mycompany.unipar.central.exceptions.EntidadeNaoInformadaException;
import com.mycompany.unipar.central.exceptions.TamanhoCampoInvalidoException;
import com.mycompany.unipar.central.model.Estado;
import com.mycompany.unipar.central.model.Pais;
import com.mycompany.unipar.central.repositories.EstadoDAO;
import java.sql.SQLException;
import java.util.List;

public class EstadoService {

    public void validar(Estado estado) throws EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {
        if (estado == null) {
            throw new EntidadeNaoInformadaException("Estado");
        }

        if (estado.getNome() == null || estado.getNome().isEmpty()
                || estado.getNome().isBlank()) {
            throw new CampoNaoInformadoException("Nome");
        }

        if (estado.getSigla() != null || estado.getSigla().isEmpty()
                || estado.getSigla().isBlank()) {
            throw new TamanhoCampoInvalidoException("Sigla", 10);

        }
    }

    public List<Estado> findAll() throws SQLException {
        EstadoDAO estadoDAO = new EstadoDAO();
        List<Estado> resultado = estadoDAO.findAll();

        return resultado;

    }

    public Pais findById(int id) throws SQLException,
            TamanhoCampoInvalidoException, Exception {

        if (id <= 0) {
            throw new TamanhoCampoInvalidoException("id", 1);
        }

        EstadoDAO estadoDAO = new EstadoDAO();

        Estado retorno = estadoDAO.findById(id);

        if (retorno == null) {
            throw new Exception("Não foi possivel encontrar um estado"
                    + " com o id: " + id + " informado");
        }

        return retorno;

    }

    public void insert(Estado estado) throws SQLException,
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {
        validar(estado);
        EstadoDAO estadoDAO = new EstadoDAO();
        estadoDAO.insert(estado);

    }

    public void update(Estado estado) throws SQLException,
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {
        validar(estado);
        EstadoDAO estadoDAO = new EstadoDAO();
        estadoDAO.update(estado);
    }

    public void delete(int id) throws SQLException {
        EstadoDAO estadoDAO = new EstadoDAO();
        estadoDAO.delete(id);

    }
}
