package com.mycompany.unipar.central.services;

import com.mycompany.unipar.central.exceptions.CampoNaoInformadoException;
import com.mycompany.unipar.central.exceptions.EntidadeNaoInformadaException;
import com.mycompany.unipar.central.exceptions.TamanhoCampoInvalidoException;
import com.mycompany.unipar.central.model.Endereco;
import com.mycompany.unipar.central.model.Pessoa;
import com.mycompany.unipar.central.model.Telefone;
import com.mycompany.unipar.central.repositories.PessoaDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class PessoaService {
    public void validar(Pessoa pessoa) throws EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {
        if (pessoa == null) {
            throw new EntidadeNaoInformadaException("Pessoa");
        }

        if (pessoa.getNome() == null || pessoa.getNome().isEmpty() ||
                pessoa.getNome().isBlank()) {
            throw new CampoNaoInformadoException("Nome");
        }

        if (pessoa.getDocumento() <= 0) {
            throw new TamanhoCampoInvalidoException("Documento", 1);
        }

        if (pessoa.getTipoPessoa() == null || pessoa.getTipoPessoa().isEmpty()
                || pessoa.getTipoPessoa().isBlank()) {
            throw new CampoNaoInformadoException("Tipo de Pessoa");
        }

    }

    public void insert(Pessoa pessoa) throws SQLException,
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {
        validar(pessoa);
        PessoaDAO pessoaDAO = new PessoaDAO();
        pessoaDAO.insert(pessoa);
    }

    public void update(Pessoa pessoa) throws SQLException,
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {
        validar(pessoa);
        PessoaDAO pessoaDAO = new PessoaDAO();
        pessoaDAO.update(pessoa);
    }

    public void delete(int id) throws SQLException {
        PessoaDAO pessoaDAO = new PessoaDAO();
        pessoaDAO.delete(id);
    }
}

