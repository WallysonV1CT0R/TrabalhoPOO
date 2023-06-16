package com.mycompany.unipar.central.services;

import com.mycompany.unipar.central.exceptions.CampoNaoInformadoException;
import com.mycompany.unipar.central.exceptions.EntidadeNaoInformadaException;
import com.mycompany.unipar.central.exceptions.TamanhoCampoInvalidoException;
import com.mycompany.unipar.central.model.Endereco;
import com.mycompany.unipar.central.model.Estado;
import com.mycompany.unipar.central.model.Pais;
import com.mycompany.unipar.central.repositories.EnderecoDAO;
import com.mycompany.unipar.central.repositories.EstadoDAO;
import java.sql.SQLException;
import java.util.List;

public class EnderecoService {
    public void validar(Endereco endereco) throws EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {
        if (endereco == null) {
            throw new EntidadeNaoInformadaException("Endereco");
        }

        if (endereco.getLogradouro()== null || endereco.getLogradouro().isEmpty()
                || endereco.getNome().isBlank()) {
            throw new CampoNaoInformadoException("Logradouro");
        }  
        if (endereco.getComplemento()== null || endereco.getComplemento().isEmpty()
                || endereco.getComplemento().isBlank()) {
            throw new CampoNaoInformadoException("Complemento");
        }

        if (endereco.getBairro()!= null || endereco.getBairro().isEmpty()
                || endereco.getBairro().isBlank()) {
            throw new TamanhoCampoInvalidoException("Bairro", 50);

        }
    }

    public List<Estado> findAll() throws SQLException {
        EstadoDAO enderecoDAO = new EstadoDAO();
        List<Estado> resultado = enderecoDAO.findAll();

        return resultado;

    }

    public Pais findById(int id) throws SQLException,
            TamanhoCampoInvalidoException, Exception {

        if (id <= 0) {
            throw new TamanhoCampoInvalidoException("id", 1);
        }

        EstadoDAO enderecoDAO = new EstadoDAO();

        Estado retorno = enderecoDAO.findById(id);

        if (retorno == null) {
            throw new Exception("Não foi possivel encontrar um endereco"
                    + " com o id: " + id + " informado");
        }

        return retorno;

    }

    public void insert(Endereco endereco) throws SQLException,
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {
        validar(endereco);
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        enderecoDAO.insert(endereco);

    }

    public void update(Endereco endereco) throws SQLException,
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {
        validar(endereco);
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        enderecoDAO.update(endereco);
    }

    public void delete(int id) throws SQLException {
        EstadoDAO enderecoDAO = new EstadoDAO();
        enderecoDAO.delete(id);

    }

}
