package com.mycompany.unipar.central.repositories;

import com.mycompany.unipar.central.model.PessoaJuridica;
import com.mycompany.unipar.central.utils.DatabaseUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaJuridicaDAO {

    private static final String INSERT =
            "INSERT INTO PESSOA_JURIDICA(razao_social, cnpj, cnae_principal,"
            + " fantasia, id_pessoa) " +
            "VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE =
            "UPDATE PESSOA_JURIDICA SET razao_social = ?, cnpj = ?,"
            + " cnae_principal = ?, fantasia = ? WHERE id_pessoa = ?";
    private static final String DELETE_BY_ID =
            "DELETE FROM PESSOA_JURIDICA WHERE id_pessoa = ?";
    private static final String FIND_ALL =
            "SELECT pj.razao_social, pj.cnpj, pj.cnae_principal, pj.fantasia,"
            + " p.id, p.nome, p.documento, p.tipo_pessoa, p.data_nasc " +
            "FROM PESSOA_JURIDICA pj " +
            "JOIN PESSOA p ON pj.id_pessoa = p.id";
    private static final String FIND_BY_ID =
            "SELECT pj.razao_social, pj.cnpj, pj.cnae_principal, pj.fantasia,"
            + " p.id, p.nome, p.documento, p.tipo_pessoa, p.data_nasc " +
            "FROM PESSOA_JURIDICA pj " +
            "JOIN PESSOA p ON pj.id_pessoa = p.id " +
            "WHERE p.id = ?";

    public List<PessoaJuridica> findAll() throws SQLException {
        List<PessoaJuridica> pessoasJuridicas = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                PessoaJuridica pessoaJuridica = new PessoaJuridica();
                pessoaJuridica.setRazaoSocial(rs.getString
        ("razao_social"));
                pessoaJuridica.setCnpj(rs.getString
        ("cnpj"));
                pessoaJuridica.setCnaePrincipal(rs.getString
        ("cnae_principal"));
                pessoaJuridica.setFantasia(rs.getString
        ("fantasia"));
                pessoaJuridica.setId(rs.getInt
        ("id"));
                pessoaJuridica.setNome(rs.getString
        ("nome"));
                pessoaJuridica.setDocumento(rs.getInt
        ("documento"));
                pessoaJuridica.setTipoPessoa(rs.getString
        ("tipo_pessoa"));
                pessoaJuridica.setDataNasc(rs.getDate
        ("data_nasc"));

                pessoasJuridicas.add(pessoaJuridica);
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

        return pessoasJuridicas;
    }

    public PessoaJuridica findById(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        PessoaJuridica pessoaJuridica = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                pessoaJuridica = new PessoaJuridica();
                pessoaJuridica.setRazaoSocial(rs.getString
        ("razao_social"));
                pessoaJuridica.setCnpj(rs.getString("cnpj"));
                pessoaJuridica.setCnaePrincipal(rs.getString
        ("cnae_principal"));
                pessoaJuridica.setFantasia(rs.getString
        ("fantasia"));
                pessoaJuridica.setId(rs.getInt("id"));
                pessoaJuridica.setNome(rs.getString("nome"));
                pessoaJuridica.setDocumento(rs.getInt
        ("documento"));
                pessoaJuridica.setTipoPessoa(rs.getString
        ("tipo_pessoa"));
                pessoaJuridica.setDataNasc(rs.getDate
        ("data_nasc"));
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

        return pessoaJuridica;
    }

    public void insert(PessoaJuridica pessoaJuridica) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setString(1, pessoaJuridica.getRazaoSocial());
            pstmt.setString(2, pessoaJuridica.getCnpj());
            pstmt.setString(3, pessoaJuridica.getCnaePrincipal());
            pstmt.setString(4, pessoaJuridica.getFantasia());
            pstmt.setInt(5, pessoaJuridica.getId());
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

    public void update(PessoaJuridica pessoaJuridica) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, pessoaJuridica.getRazaoSocial());
            pstmt.setString(2, pessoaJuridica.getCnpj());
            pstmt.setString(3, pessoaJuridica.getCnaePrincipal());
            pstmt.setString(4, pessoaJuridica.getFantasia());
            pstmt.setInt(5, pessoaJuridica.getId());
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
