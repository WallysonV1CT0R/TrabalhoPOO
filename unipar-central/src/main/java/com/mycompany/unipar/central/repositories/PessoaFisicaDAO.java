package com.mycompany.unipar.central.repositories;

import com.mycompany.unipar.central.model.PessoaFisica;
import com.mycompany.unipar.central.utils.DatabaseUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaFisicaDAO {

    private static final String INSERT =
            "INSERT INTO PESSOA_FISICA(cpf, rg, data_nascimento,"
            + " id_pessoa) VALUES (?, ?, ?, ?)";
    private static final String UPDATE =
            "UPDATE PESSOA_FISICA SET cpf = ?, rg = ?,"
            + " data_nascimento = ? WHERE id_pessoa = ?";
    private static final String DELETE_BY_ID =
            "DELETE FROM PESSOA_FISICA WHERE id_pessoa = ?";
    private static final String FIND_ALL =
            "SELECT pf.cpf, pf.rg, pf.data_nascimento,"
            + " p.id, p.nome, p.documento, p.tipo_pessoa, p.data_nasc " +
            "FROM PESSOA_FISICA pf " +
            "JOIN PESSOA p ON pf.id_pessoa = p.id";
    private static final String FIND_BY_ID =
            "SELECT pf.cpf, pf.rg, pf.data_nascimento,"
            + " p.id, p.nome, p.documento, p.tipo_pessoa, p.data_nasc " +
            "FROM PESSOA_FISICA pf " +
            "JOIN PESSOA p ON pf.id_pessoa = p.id " +
            "WHERE p.id = ?";

    public List<PessoaFisica> findAll() throws SQLException {
        List<PessoaFisica> pessoasFisicas = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                PessoaFisica pessoaFisica = new PessoaFisica();
                pessoaFisica.setCpf(rs.getString("cpf"));
                pessoaFisica.setRg(rs.getString("rg"));
                pessoaFisica.setDataNascimento
        (rs.getDate("data_nascimento"));
                pessoaFisica.setId(rs.getInt("id"));
                pessoaFisica.setNome(rs.getString("nome"));
                pessoaFisica.setDocumento(rs.getInt
        ("documento"));
                pessoaFisica.setTipoPessoa
        (rs.getString("tipo_pessoa"));
                pessoaFisica.setDataNasc
        (rs.getDate("data_nasc"));

                pessoasFisicas.add(pessoaFisica);
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

        return pessoasFisicas;
    }

    public PessoaFisica findById(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        PessoaFisica pessoaFisica = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                pessoaFisica = new PessoaFisica();
                pessoaFisica.setCpf(rs.getString("cpf"));
                pessoaFisica.setRg(rs.getString("rg"));
                pessoaFisica.setDataNascimento
        (rs.getDate("data_nascimento"));
                pessoaFisica.setId(rs.getInt("id"));
                pessoaFisica.setNome(rs.getString("nome"));
                pessoaFisica.setDocumento(rs.getInt
        ("documento"));
                pessoaFisica.setTipoPessoa
        (rs.getString("tipo_pessoa"));
                pessoaFisica.setDataNasc
        (rs.getDate("data_nasc"));
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

        return pessoaFisica;
    }

    public void insert(PessoaFisica pessoaFisica) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setString(1, pessoaFisica.getCpf());
            pstmt.setString(2, pessoaFisica.getRg());
            pstmt.setDate(3, new java.sql.Date
        (pessoaFisica.getDataNascimento().getTime()));
            pstmt.setInt(4, pessoaFisica.getId());
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

    public void update(PessoaFisica pessoaFisica) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, pessoaFisica.getCpf());
            pstmt.setString(2, pessoaFisica.getRg());
            pstmt.setDate(3, new java.sql.Date
        (pessoaFisica.getDataNascimento().getTime()));
            pstmt.setInt(4, pessoaFisica.getId());
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

