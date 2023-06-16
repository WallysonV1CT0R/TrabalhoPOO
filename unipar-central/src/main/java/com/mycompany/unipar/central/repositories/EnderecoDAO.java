package com.mycompany.unipar.central.repositories;

import com.mycompany.unipar.central.model.Endereco;
import com.mycompany.unipar.central.utils.DatabaseUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDAO {

    private static final String INSERT =
            "INSERT INTO ENDERECO(id, logradouro, numero, bairro,"
            + " complemento, cep, pessoa_id) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE =
            "UPDATE ENDERECO SET logradouro = ?, numero = ?,"
            + " bairro = ?, complemento = ?, cep = ?, pessoa_id = ? " +
            "WHERE id = ?";
    private static final String DELETE_BY_ID =
            "DELETE FROM ENDERECO WHERE id = ?";
    private static final String FIND_ALL =
            "SELECT id, logradouro, numero, bairro, complemento,"
            + " cep, pessoa_id FROM ENDERECO";
    private static final String FIND_BY_ID =
            "SELECT id, logradouro, numero, bairro, complemento,"
            + " cep, pessoa_id FROM ENDERECO WHERE id = ?";

    public List<Endereco> findAll() throws SQLException {
        List<Endereco> enderecos = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Endereco endereco = new Endereco();
                endereco.setId(rs.getInt("id"));
                endereco.setLogradouro(rs.getString
        ("logradouro"));
                endereco.setNumero(rs.getInt("numero"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setComplemento(rs.getString
        ("complemento"));
                endereco.setCep(rs.getInt("cep"));
                endereco.setPessoa(new PessoaDAO().findById
        (rs.getInt("PESSOA_ID")));
                enderecos.add(endereco);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }

            if (pstmt != null) {
                pstmt.close();
            }

            if (conn != null) {
                conn.close();
            }
        }

        return enderecos;
    }

    public Endereco findById(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Endereco endereco = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                endereco = new Endereco();
                endereco.setId(rs.getInt("id"));
                endereco.setLogradouro(rs.getString
        ("logradouro"));
                endereco.setNumero(rs.getInt("numero"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setComplemento(rs.getString
        ("complemento"));
                endereco.setCep(rs.getInt("cep"));
                endereco.setPessoa(new PessoaDAO().findById
        (rs.getInt("PESSOA_ID")));
            }
        } finally {
            if (rs != null) {
                rs.close();
            }

            if (pstmt != null) {
                pstmt.close();
            }

            if (conn != null) {
                conn.close();
            }
        }

        return endereco;
    }

    public void insert(Endereco endereco) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setInt(1, endereco.getId());
            pstmt.setString(2, endereco.getLogradouro());
            pstmt.setInt(3, endereco.getNumero());
            pstmt.setString(4, endereco.getBairro());
            pstmt.setString(5, endereco.getComplemento());
            pstmt.setInt(6, endereco.getCep());
            pstmt.executeUpdate();
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }

            if (conn != null) {
                conn.close();
            }
        }
    }

    public void update(Endereco endereco) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, endereco.getLogradouro());
            pstmt.setInt(2, endereco.getNumero());
            pstmt.setString(3, endereco.getBairro());
            pstmt.setString(4, endereco.getComplemento());
            pstmt.setInt(5, endereco.getCep());
            pstmt.setInt(6, endereco.getId());
            pstmt.executeUpdate();
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }

            if (conn != null) {
                conn.close();
            }
        }
    }

    public void delete(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(DELETE_BY_ID);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }

            if (conn != null) {
                conn.close();
            }
        }
    }
}
