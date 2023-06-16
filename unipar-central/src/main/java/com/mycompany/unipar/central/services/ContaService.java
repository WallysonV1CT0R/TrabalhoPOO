package com.mycompany.unipar.central.services;

import com.mycompany.unipar.central.enums.TipoContaEnum;
import com.mycompany.unipar.central.exceptions.CampoNaoInformadoException;
import com.mycompany.unipar.central.exceptions.EntidadeNaoInformadaException;
import com.mycompany.unipar.central.exceptions.TamanhoCampoInvalidoException;
import com.mycompany.unipar.central.model.Conta;
import com.mycompany.unipar.central.repositories.ContaDAO;

import java.sql.SQLException;
import java.util.List;

public class ContaService {
    public void validar(Conta conta) throws EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {
        if (conta == null) {
            throw new EntidadeNaoInformadaException("Conta");
        }

        if (conta.getConta()== null || conta.getConta().isEmpty() || 
                conta.getConta().isBlank()) {
            throw new CampoNaoInformadoException("Número da conta");
        }

        if (conta.getSaldo() < 0) {
            throw new CampoNaoInformadoException("Saldo");
        }
    }

    public List<Conta> findAll() throws SQLException {
        ContaDAO contaDAO = new ContaDAO();
        return contaDAO.findAll();
    }

    public Conta findById(int id) throws SQLException,
            TamanhoCampoInvalidoException, 
            Exception {
        if (id <= 0) {
            throw new TamanhoCampoInvalidoException("ID", 1);
        }

        ContaDAO contaDAO = new ContaDAO();
        Conta conta = contaDAO.findById(id);

        if (conta == null) {
            throw new Exception("Não foi possível encontrar uma conta "
                    + "com o ID informado: " + id);
        }

        return conta;
    }

    public void insert(Conta conta) throws SQLException,
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {
        validar(conta);

        ContaDAO contaDAO = new ContaDAO();
        contaDAO.insert(conta);
    }

    public void update(Conta conta) throws SQLException,
            EntidadeNaoInformadaException,
            CampoNaoInformadoException, 
            TamanhoCampoInvalidoException {
        validar(conta);

        ContaDAO contaDAO = new ContaDAO();
        contaDAO.update(conta);
    }

    public void delete(int id) throws SQLException {
        ContaDAO contaDAO = new ContaDAO();
        contaDAO.delete(id);
    }
    public void criarConta(Conta conta) {
        TipoContaEnum tipoConta = conta.getTipoConta();
        String numero = conta.getConta();
    }
}
