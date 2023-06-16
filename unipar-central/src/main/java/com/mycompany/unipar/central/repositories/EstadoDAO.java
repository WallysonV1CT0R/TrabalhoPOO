package com.mycompany.unipar.central.repositories;

import com.mycompany.unipar.central.model.Estado;
import com.mycompany.unipar.central.model.Estado;
import com.mycompany.unipar.central.model.Pais;
import com.mycompany.unipar.central.utils.DatabaseUtils;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstadoDAO {

    private static final String INSERT
            = "INSERT INTO ESTADO(id,nome,sigla,ra,Pais_id)VALUES"
            + "(?,?,?,?)";
    private static final String FIND_ALL
            = "SELECT ID, NOME ,SIGLA,RA, PAIS_ID FROM ESTADO";
    private static final String FIND_BY_ID
            = "SELECT ID, NOME ,SIGLA, RA, PAIS FROM ESTADO WHERE ID = ?";
    private static final String DELETE_BY_ID
            = "DELETE FROM ESTADO WHERE ID = ?";
    private static final String UPDATE
            = "UPDATE ESTADO SET NOME = ?, SIGLA = ?, RA = ?,"
            + " PAIS_ID = ? WHERE ID = ?";

    public List<Estado> findAll() throws SQLException {
        ArrayList<Estado> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = new DatabaseUtils().getConnection();

            pstmt = conn.prepareStatement(FIND_ALL);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                int estadoId = rs.getInt("id");
                String nome = rs.getString("nome");
                String sigla = rs.getString("sigla");
                int paisId = rs.getInt("pais_id");

                Pais pais = new Pais();
                pais.setId(paisId);

                Estado estado = new Estado(estadoId, nome, sigla, pais);
                retorno.add(estado);
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

    public Estado findById(int id) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Estado retorno = null;
        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                retorno = new Estado(id, INSERT, INSERT, retorno);
                retorno.setId(rs.getInt("ID"));
                retorno.setNome(rs.getString("NOME"));
                retorno.setRegistroAcademico
        (rs.getString("RA"));
                retorno.setSigla(rs.getString("SIGLA"));
                retorno.setPais(new PaisDAO().findById(rs.getInt
        ("PAIS_ID")));
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

    public void insert(Estado estado) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DatabaseUtils().getConnection();

            pstmt = conn.prepareStatement(INSERT);
            pstmt.setInt(1, estado.getId());
            pstmt.setString(2, estado.getNome());
            pstmt.setString(3, estado.getSigla());

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

    public void update(Estado estado) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, estado.getNome());
            pstmt.setString(2, estado.getSigla());
            pstmt.setString(3, estado.getRegistroAcademico());
            pstmt.setInt(4, estado.getId());

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
