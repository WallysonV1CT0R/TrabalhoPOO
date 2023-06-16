package com.mycompany.unipar.central.services;

import com.mycompany.unipar.central.exceptions.CampoNaoInformadoException;
import com.mycompany.unipar.central.exceptions.EntidadeNaoInformadaException;
import com.mycompany.unipar.central.exceptions.TamanhoCampoInvalidoException;
import com.mycompany.unipar.central.model.PessoaFisica;
import com.mycompany.unipar.central.repositories.PessoaFisicaDAO;

import java.sql.SQLException;
import java.util.List;

public class PessoaFisicaService {
    public void validar(PessoaFisica pessoaFisica) throws EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {
        if (pessoaFisica == null) {
            throw new EntidadeNaoInformadaException("Pessoa física");
        }

        if (pessoaFisica.getNome() == null || pessoaFisica.getNome().isEmpty() || pessoaFisica.getNome().isBlank()) {
            throw new CampoNaoInformadoException("Nome da pessoa física");
        }

        if (pessoaFisica.getCpf() == null || pessoaFisica.getCpf().isEmpty() || pessoaFisica.getCpf().isBlank()) {
            throw new CampoNaoInformadoException("CPF da pessoa física");
        }
    }

    public List<PessoaFisica> findAll() throws SQLException {
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        return pessoaFisicaDAO.findAll();
    }

    public PessoaFisica findById(int id) throws SQLException, TamanhoCampoInvalidoException, Exception {
        if (id <= 0) {
            throw new TamanhoCampoInvalidoException("ID", 1);
        }

        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        PessoaFisica pessoaFisica = pessoaFisicaDAO.findById(id);

        if (pessoaFisica == null) {
            throw new Exception("Não foi possível encontrar uma pessoa física com o ID informado: " + id);
        }

        return pessoaFisica;
    }

    public void insert(PessoaFisica pessoaFisica) throws SQLException, EntidadeNaoInformadaException,
            CampoNaoInformadoException, TamanhoCampoInvalidoException {
        validar(pessoaFisica);

        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        pessoaFisicaDAO.insert(pessoaFisica);
    }

    public void update(PessoaFisica pessoaFisica) throws SQLException, EntidadeNaoInformadaException,
            CampoNaoInformadoException, TamanhoCampoInvalidoException {
        validar(pessoaFisica);

        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        pessoaFisicaDAO.update(pessoaFisica);
    }

    public void delete(int id) throws SQLException {
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        pessoaFisicaDAO.delete(id);
    }
}
