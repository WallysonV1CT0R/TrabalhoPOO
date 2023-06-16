package com.mycompany.unipar.central.services;

import com.mycompany.unipar.central.exceptions.CampoNaoInformadoException;
import com.mycompany.unipar.central.exceptions.EntidadeNaoInformadaException;
import com.mycompany.unipar.central.exceptions.TamanhoCampoInvalidoException;
import com.mycompany.unipar.central.model.Transacao;
import com.mycompany.unipar.central.repositories.TransacaoDAO;

import java.sql.SQLException;
import java.util.List;

public class TransacaoService {
    public void validar(Transacao transacao) throws 
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {
        if (transacao == null) {
            throw new EntidadeNaoInformadaException("Transação");
        }

        if (transacao.getValor() <= 0) {
            throw new TamanhoCampoInvalidoException
        ("Valor da transação", 0.01);
        }
    }

    public List<Transacao> findAll() throws SQLException {
        TransacaoDAO transacaoDAO = new TransacaoDAO();
        return transacaoDAO.findAll();
    }

    public Transacao findById(int id) throws 
            SQLException, 
            TamanhoCampoInvalidoException, 
            Exception {
        if (id <= 0) {
            throw new TamanhoCampoInvalidoException("ID", 1);
        }

        TransacaoDAO transacaoDAO = new TransacaoDAO();
        Transacao transacao = transacaoDAO.findById(id);

        if (transacao == null) {
            throw new Exception("Não foi possível encontrar uma "
                    + "transação com o ID informado: " + id);
        }

        return transacao;
    }

    public void insert(Transacao transacao) throws SQLException, 
            EntidadeNaoInformadaException,
            CampoNaoInformadoException, 
            TamanhoCampoInvalidoException {
        validar(transacao);

        TransacaoDAO transacaoDAO = new TransacaoDAO();
        transacaoDAO.insert(transacao);
    }

    public void update(Transacao transacao) throws SQLException, 
            EntidadeNaoInformadaException,
            CampoNaoInformadoException, 
            TamanhoCampoInvalidoException {
        validar(transacao);

        TransacaoDAO transacaoDAO = new TransacaoDAO();
        transacaoDAO.update(transacao);
    }

    public void delete(int id) throws SQLException {
        TransacaoDAO transacaoDAO = new TransacaoDAO();
        transacaoDAO.deleteById(id);
    }
}
