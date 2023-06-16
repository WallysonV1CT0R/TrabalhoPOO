package com.mycompany.unipar.central.repositories;

import com.mycompany.unipar.central.model.Banco;
import com.mycompany.unipar.central.utils.DatabaseUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BancoDAO {

    private static final String INSERT =
            "INSERT INTO BANCO(id, nome, ra) VALUES (?, ?, ?)";
    private static final String UPDATE =
            "UPDATE BANCO SET nome = ?, ra = ? WHERE id = ?";
    private static final String DELETE_BY_ID =
            "DELETE FROM BANCO WHERE id = ?";
    private static final String FIND_ALL =
            "SELECT id, nome, ra FROM BANCO";
    private static final String FIND_BY_ID =
            "SELECT id, nome, ra FROM BANCO WHERE id = ?";

    public List<Banco> findAll() throws SQLException {
        List<Banco> bancos = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Banco banco = new Banco();
                banco.setId(rs.getInt("id"));
                banco.setNome(rs.getString("nome"));
                banco.setRa(rs.getString("ra"));

                bancos.add(banco);
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

        return bancos;
    }

    public Banco findById(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Banco banco = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                banco = new Banco();
                banco.setId(rs.getInt("id"));
                banco.setNome(rs.getString("nome"));
                banco.setRa(rs.getString("ra"));
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

        return banco;
    }

    public void insert(Banco banco) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setInt(1, banco.getId());
            pstmt.setString(2, banco.getNome());
            pstmt.setString(3, banco.getRa());
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

    public void update(Banco banco) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, banco.getNome());
            pstmt.setString(2, banco.getRa());
            pstmt.setInt(3, banco.getId());
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
