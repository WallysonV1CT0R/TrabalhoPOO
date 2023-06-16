package com.mycompany.unipar.central.services;

import com.mycompany.unipar.central.exceptions.CampoNaoInformadoException;
import com.mycompany.unipar.central.exceptions.EntidadeNaoInformadaException;
import com.mycompany.unipar.central.exceptions.TamanhoCampoInvalidoException;
import com.mycompany.unipar.central.model.PessoaJuridica;
import com.mycompany.unipar.central.repositories.PessoaJuridicaDAO;

import java.sql.SQLException;
import java.util.List;

public class PessoaJuridicaService {
    public void validar(PessoaJuridica pessoaJuridica) throws
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {
        if (pessoaJuridica == null) {
            throw new EntidadeNaoInformadaException("Pessoa jurídica");
        }

        if (pessoaJuridica.getNome() == null ||
                pessoaJuridica.getNome().isEmpty() ||
                pessoaJuridica.getNome().isBlank()) {
            throw new CampoNaoInformadoException("Nome da pessoa jurídica");
        }

        if (pessoaJuridica.getCnpj() == null ||
                pessoaJuridica.getCnpj().isEmpty() || 
                pessoaJuridica.getCnpj().isBlank()) {
            throw new CampoNaoInformadoException("CNPJ da pessoa jurídica");
        }
    }

    public List<PessoaJuridica> findAll() throws SQLException {
        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
        return pessoaJuridicaDAO.findAll();
    }

    public PessoaJuridica findById(int id) throws SQLException,
            TamanhoCampoInvalidoException,
            Exception {
        if (id <= 0) {
            throw new TamanhoCampoInvalidoException("ID", 1);
        }

        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
        PessoaJuridica pessoaJuridica = pessoaJuridicaDAO.findById(id);

        if (pessoaJuridica == null) {
            throw new Exception("Não foi possível encontrar uma pessoa"
                    + " jurídica com o ID informado: " + id);
        }

        return pessoaJuridica;
    }

    public void insert(PessoaJuridica pessoaJuridica) throws SQLException,
            EntidadeNaoInformadaException,
            CampoNaoInformadoException, 
            TamanhoCampoInvalidoException {
        validar(pessoaJuridica);

        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
        pessoaJuridicaDAO.insert(pessoaJuridica);
    }

    public void update(PessoaJuridica pessoaJuridica) throws SQLException, 
            EntidadeNaoInformadaException,
            CampoNaoInformadoException, 
            TamanhoCampoInvalidoException {
        validar(pessoaJuridica);

        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
        pessoaJuridicaDAO.update(pessoaJuridica);
    }

    public void delete(int id) throws SQLException {
        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
        pessoaJuridicaDAO.delete(id);
    }
}
