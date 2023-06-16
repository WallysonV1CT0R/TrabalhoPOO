package com.mycompany.unipar.central.repositories;

import com.mycompany.unipar.central.model.Agencia;
import com.mycompany.unipar.central.model.Conta;
import com.mycompany.unipar.central.utils.DatabaseUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AgenciaDAO {

    private static final String INSERT =
            "INSERT INTO AGENCIA(id, codigo, razao_social,"
            + " cnpj, ra, conta_id) " +
            "VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE =
            "UPDATE AGENCIA SET codigo = ?, razao_social = ?,"
            + " cnpj = ?, ra = ?, conta_id = ? " +
            "WHERE id = ?";
    private static final String DELETE_BY_ID =
            "DELETE FROM AGENCIA WHERE id = ?";
    private static final String FIND_ALL =
            "SELECT id, codigo, razao_social, cnpj, ra, conta_id FROM AGENCIA";
    private static final String FIND_BY_ID =
            "SELECT id, codigo, razao_social, cnpj, ra,"
            + " conta_id FROM AGENCIA WHERE id = ?";

    public List<Agencia> findAll() throws SQLException {
        List<Agencia> agencias = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Agencia agencia = new Agencia();
                agencia.setId(rs.getInt("id"));
                agencia.setCodigo(rs.getString("codigo"));
                agencia.setRazaoSocial(rs.getString
        ("razao_social"));
                agencia.setCnpj(rs.getString("cnpj"));
                agencia.setRa(rs.getString("ra"));
                agencia.setConta(new ContaDAO().findById
        (rs.getInt("CONTA_ID")));

                agencias.add(agencia);
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

        return agencias;
    }

    public Agencia findById(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Agencia agencia = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                agencia = new Agencia();
                agencia.setId(rs.getInt("id"));
                agencia.setCodigo(rs.getString
        ("codigo"));
                agencia.setRazaoSocial(rs.getString
        ("razao_social"));
                agencia.setCnpj(rs.getString("cnpj"));
                agencia.setRa(rs.getString("ra"));
                agencia.setConta(new ContaDAO().findById(rs.getInt
        ("CONTA_ID")));
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

        return agencia;
    }

    public void insert(Agencia agencia) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setInt(1, agencia.getId());
            pstmt.setString(2, agencia.getCodigo());
            pstmt.setString(3, agencia.getRazaoSocial());
            pstmt.setString(4, agencia.getCnpj());
            pstmt.setString(5, agencia.getRa());
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

    public void update(Agencia agencia) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, agencia.getCodigo());
            pstmt.setString(2, agencia.getRazaoSocial());
            pstmt.setString(3, agencia.getCnpj());
            pstmt.setString(4, agencia.getRa());
            pstmt.setInt(5, agencia.getId());
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
