package com.mycompany.unipar.central.services;

import com.mycompany.unipar.central.exceptions.CampoNaoInformadoException;
import com.mycompany.unipar.central.exceptions.EntidadeNaoInformadaException;
import com.mycompany.unipar.central.exceptions.TamanhoCampoInvalidoException;
import com.mycompany.unipar.central.model.Banco;
import com.mycompany.unipar.central.repositories.BancoDAO;

import java.sql.SQLException;
import java.util.List;

public class BancoService {
    public void validar(Banco banco) throws EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {
        if (banco == null) {
            throw new EntidadeNaoInformadaException("Banco");
        }

        if (banco.getNome() == null || banco.getNome().isEmpty() || 
                banco.getNome().isBlank()) {
            throw new CampoNaoInformadoException("Nome do banco");
        }
    }

    public List<Banco> findAll() throws SQLException {
        BancoDAO bancoDAO = new BancoDAO();
        return bancoDAO.findAll();
    }

    public Banco findById(int id) throws SQLException, 
            TamanhoCampoInvalidoException,
            Exception {
        if (id <= 0) {
            throw new TamanhoCampoInvalidoException("ID", 1);
        }

        BancoDAO bancoDAO = new BancoDAO();
        Banco banco = bancoDAO.findById(id);

        if (banco == null) {
            throw new Exception("Não foi possível encontrar um banco com "
                    + "o ID informado: " + id);
        }

        return banco;
    }

    public void insert(Banco banco) throws SQLException, 
            EntidadeNaoInformadaException,
            CampoNaoInformadoException, 
            TamanhoCampoInvalidoException {
        validar(banco);

        BancoDAO bancoDAO = new BancoDAO();
        bancoDAO.insert(banco);
    }

    public void update(Banco banco) throws SQLException, 
            EntidadeNaoInformadaException,
            CampoNaoInformadoException, 
            TamanhoCampoInvalidoException {
        validar(banco);

        BancoDAO bancoDAO = new BancoDAO();
        bancoDAO.update(banco);
    }

    public void delete(int id) throws SQLException {
        BancoDAO bancoDAO = new BancoDAO();
        bancoDAO.delete(id);
    }
}
