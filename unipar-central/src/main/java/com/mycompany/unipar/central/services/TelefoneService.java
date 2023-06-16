package com.mycompany.unipar.central.services;

import com.mycompany.unipar.central.exceptions.CampoNaoInformadoException;
import com.mycompany.unipar.central.exceptions.EntidadeNaoInformadaException;
import com.mycompany.unipar.central.exceptions.TamanhoCampoInvalidoException;
import com.mycompany.unipar.central.model.Telefone;
import com.mycompany.unipar.central.repositories.TelefoneDAO;

import java.sql.SQLException;
import java.util.List;

public class TelefoneService {
    public void validar(Telefone telefone) throws EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {
        if (telefone == null) {
            throw new EntidadeNaoInformadaException("Telefone");
        }

        if (telefone.getOperadora() == null || telefone.getOperadora().isEmpty()
                || telefone.getOperadora().isBlank()) {
            throw new CampoNaoInformadoException("DDD do telefone");
        }

        if (telefone.getNumero() == null || telefone.getNumero().isEmpty() ||
                telefone.getNumero().isBlank()) {
            throw new CampoNaoInformadoException("Número do telefone");
        }
    }

    public List<Telefone> findAll() throws SQLException {
        TelefoneDAO telefoneDAO = new TelefoneDAO();
        return telefoneDAO.findAll();
    }

    public Telefone findById(int id) throws SQLException,
            TamanhoCampoInvalidoException,
            Exception {
        if (id <= 0) {
            throw new TamanhoCampoInvalidoException("ID", 1);
        }

        TelefoneDAO telefoneDAO = new TelefoneDAO();
        Telefone telefone = telefoneDAO.findById(id);

        if (telefone == null) {
            throw new Exception("Não foi possível encontrar um telefone com o ID informado: " + id);
        }

        return telefone;
    }

    public void insert(Telefone telefone) throws SQLException,
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {
        validar(telefone);

        TelefoneDAO telefoneDAO = new TelefoneDAO();
        telefoneDAO.insert(telefone);
    }

    public void update(Telefone telefone) throws SQLException, 
            EntidadeNaoInformadaException,
            CampoNaoInformadoException, 
            TamanhoCampoInvalidoException {
        validar(telefone);

        TelefoneDAO telefoneDAO = new TelefoneDAO();
        telefoneDAO.update(telefone);
    }

    public void delete(int id) throws SQLException {
        TelefoneDAO telefoneDAO = new TelefoneDAO();
        telefoneDAO.deleteById(id);
    }
}
