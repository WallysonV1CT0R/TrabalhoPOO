package com.mycompany.unipar.central.repositories;

import com.mycompany.unipar.central.model.Pessoa;
import com.mycompany.unipar.central.utils.DatabaseUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {

    private static final String INSERT =
            "INSERT INTO PESSOA(id, nome, documento, tipo_pessoa,"
            + " data_nasc) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE =
            "UPDATE PESSOA SET nome = ?, documento = ?,"
            + " tipo_pessoa = ?, data_nasc = ? WHERE id = ?";
    private static final String DELETE_BY_ID =
            "DELETE FROM PESSOA WHERE id = ?";
    private static final String FIND_ALL =
            "SELECT id, nome, documento, tipo_pessoa,"
            + " data_nasc FROM PESSOA";
    private static final String FIND_BY_ID =
            "SELECT id, nome, documento, tipo_pessoa,"
            + " data_nasc FROM PESSOA WHERE id = ?";

    public List<Pessoa> findAll() throws SQLException {
        List<Pessoa> pessoas = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setId(rs.getInt("id"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setDocumento(rs.getInt
        ("documento"));
                pessoa.setTipoPessoa(rs.getString
        ("tipo_pessoa"));
                pessoa.setDataNasc
        (rs.getDate("data_nasc"));

                pessoas.add(pessoa);
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

        return pessoas;
    }

    public Pessoa findById(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Pessoa pessoa = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                pessoa = new Pessoa();
                pessoa.setId(rs.getInt("id"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setDocumento(rs.getInt("documento"));
                pessoa.setTipoPessoa
        (rs.getString("tipo_pessoa"));
                pessoa.setDataNasc(rs.getDate("data_nasc"));
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

        return pessoa;
    }

    public void insert(Pessoa pessoa) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setInt(1, pessoa.getId());
            pstmt.setString(2, pessoa.getNome());
            pstmt.setInt(3, pessoa.getDocumento());
            pstmt.setString(4, pessoa.getTipoPessoa());
            pstmt.setDate(5, new java.sql.Date
            (pessoa.getDataNasc().getTime()));
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

    public void update(Pessoa pessoa) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, pessoa.getNome());
            pstmt.setInt(2, pessoa.getDocumento());
            pstmt.setString(3, pessoa.getTipoPessoa());
            pstmt.setDate(4, new java.sql.Date
        (pessoa.getDataNasc().getTime()));
            pstmt.setInt(5, pessoa.getId());
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
