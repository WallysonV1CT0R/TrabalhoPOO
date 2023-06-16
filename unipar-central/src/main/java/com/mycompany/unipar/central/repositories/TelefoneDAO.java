package com.mycompany.unipar.central.repositories;

import com.mycompany.unipar.central.enums.OperadoraEnum;
import com.mycompany.unipar.central.model.Telefone;
import com.mycompany.unipar.central.utils.DatabaseUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TelefoneDAO {

    private static final String INSERT =
            "INSERT INTO TELEFONE(id, numero, operadora) VALUES (?, ?, ?)";
    private static final String UPDATE =
            "UPDATE TELEFONE SET numero = ?, operadora = ? WHERE id = ?";
    private static final String DELETE_BY_ID =
            "DELETE FROM TELEFONE WHERE id = ?";
    private static final String FIND_ALL =
            "SELECT id, numero, operadora FROM TELEFONE";
    private static final String FIND_BY_ID =
            "SELECT id, numero, operadora FROM TELEFONE WHERE id = ?";
    private OperadoraEnum operadoraenum;

    public List<Telefone> findAll() throws SQLException {
        List<Telefone> telefones = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Telefone telefone = new Telefone();
                telefone.setId(rs.getInt("id"));
                telefone.setNumero(rs.getString("numero"));
                telefone.setOperadora(rs.getString(INSERT));
                telefones.add(telefone);
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

        return telefones;
    }

    public Telefone findById(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Telefone telefone = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                telefone = new Telefone();
                telefone.setId(rs.getInt("id"));
                telefone.setNumero(rs.getString("numero"));
                telefone.setOperadora(rs.getString(INSERT));
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

        return telefone;
    }

    public void insert(Telefone telefone) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setInt(1, telefone.getId());
            pstmt.setString(2, telefone.getNumero());
            pstmt.setString(3,
                    telefone.getOperadora().valueOf(INSERT));
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

    public void update(Telefone telefone) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, telefone.getNumero());
            pstmt.setString(3,
                    telefone.getOperadora().valueOf(INSERT));
            pstmt.setInt(3, telefone.getId());
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

    public void deleteById(int id) throws SQLException {
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
