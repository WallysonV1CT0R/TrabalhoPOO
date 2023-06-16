package com.mycompany.unipar.central.services;

import com.mycompany.unipar.central.exceptions.CampoNaoInformadoException;
import com.mycompany.unipar.central.exceptions.EntidadeNaoInformadaException;
import com.mycompany.unipar.central.exceptions.TamanhoCampoInvalidoException;
import com.mycompany.unipar.central.model.Cidade;
import com.mycompany.unipar.central.repositories.CidadeDAO;

import java.sql.SQLException;
import java.util.List;

public class CidadeService {
    public void validar(Cidade cidade) throws EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {
        if (cidade == null) {
            throw new EntidadeNaoInformadaException("Cidade");
        }

        if (cidade.getNome() == null || cidade.getNome().isEmpty() || 
                cidade.getNome().isBlank()) {
            throw new CampoNaoInformadoException("Nome da cidade");
        }

        if (cidade.getEstado() == null) {
            throw new CampoNaoInformadoException("Estado");
        }
    }

    public List<Cidade> findAll() throws SQLException {
        CidadeDAO cidadeDAO = new CidadeDAO();
        return cidadeDAO.findAll();
    }

    public Cidade findById(int id) throws SQLException, 
            TamanhoCampoInvalidoException, 
            Exception {
        if (id <= 0) {
            throw new TamanhoCampoInvalidoException("ID", 1);
        }

        CidadeDAO cidadeDAO = new CidadeDAO();
        Cidade cidade = cidadeDAO.findById(id);

        if (cidade == null) {
            throw new Exception("Não foi possível encontrar uma cidade "
                    + "com o ID informado: " + id);
        }

        return cidade;
    }

    public void insert(Cidade cidade) throws SQLException, 
            EntidadeNaoInformadaException,
            CampoNaoInformadoException, 
            TamanhoCampoInvalidoException {
        validar(cidade);

        CidadeDAO cidadeDAO = new CidadeDAO();
        cidadeDAO.insert(cidade);
    }

    public void update(Cidade cidade) throws SQLException, 
            EntidadeNaoInformadaException,
            CampoNaoInformadoException, 
            TamanhoCampoInvalidoException {
        validar(cidade);

        CidadeDAO cidadeDAO = new CidadeDAO();
        cidadeDAO.update(cidade);
    }

    public void delete(int id) throws SQLException {
        CidadeDAO cidadeDAO = new CidadeDAO();
        cidadeDAO.delete(id);
    }
}
