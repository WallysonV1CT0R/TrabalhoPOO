package com.mycompany.unipar.central.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.unipar.central.utils.DatabaseUtils;
import com.mycompany.unipar.central.model.Cidade;
import com.mycompany.unipar.central.model.Pais;

public class CidadeDAO {
private static final String INSERT
            = "INSERT INTO ESTADO(id,nome,ra,Estado_id)VALUES"
            + "(?,?,?,?)";
    private static final String FIND_ALL
            = "SELECT ID, NOME ,RA, ESTADO_ID FROM CIDADE";
    private static final String FIND_BY_ID
            = "SELECT ID, NOME , RA, ESTADO FROM CIDADE WHERE ID = ?";
    private static final String DELETE_BY_ID
            = "DELETE FROM CIDADE WHERE ID = ?";
    private static final String UPDATE
            = "UPDATE CIDADE SET NOME = ?, RA = ?,"
            + " CIDADE_ID = ? WHERE ID = ?";
    private Pais pais;

    public List<Cidade> findAll() throws SQLException {
        ArrayList<Cidade> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = new DatabaseUtils().getConnection();

            pstmt = conn.prepareStatement(FIND_ALL);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                Cidade cidade = new Cidade(0, INSERT, INSERT,pais);
                cidade.setId(rs.getInt("ID"));
                cidade.setNome(rs.getString("NOME"));
                cidade.setRa(rs.getString("RA"));

                retorno.add(cidade);
            }
        } finally {
        }
        if (rs != null) {
            rs.close();
        }

        if (pstmt != null) {
            pstmt.close();
        }
        if (conn != null) {
            conn.close();

        }
        return retorno;

    }

    public Cidade findById(int id) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Cidade retorno = null;
        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                retorno = new Cidade(id, INSERT, INSERT, pais);
                retorno.setId(rs.getInt("ID"));
                retorno.setNome(rs.getString("NOME"));
                retorno.setRegistroAcademico(rs.getString
                ("RA"));
                retorno.setPais(new EstadoDAO().findById(rs.getInt
                ("ESTADO_ID")));
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
        return retorno;
    }

    public void insert(Cidade cidade) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DatabaseUtils().getConnection();

            pstmt = conn.prepareStatement(INSERT);
            pstmt.setInt(1, cidade.getId());
            pstmt.setString(2, cidade.getNome());
            pstmt.setString(3, cidade.getRa());

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

    public void update(Cidade cidade) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, cidade.getNome());
            pstmt.setString(2, cidade.getRegistroAcademico());
            pstmt.setInt(3, cidade.getId());

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
