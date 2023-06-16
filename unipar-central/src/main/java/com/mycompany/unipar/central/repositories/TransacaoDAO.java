package com.mycompany.unipar.central.repositories;

import com.mycompany.unipar.central.model.Transacao;
import com.mycompany.unipar.central.utils.DatabaseUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransacaoDAO {

    private static final String INSERT =
            "INSERT INTO TRANSACAO(id, tipo, data_hora, valor, ra,"
            + " conta_origem, conta_destino) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE =
            "UPDATE TRANSACAO SET tipo = ?, data_hora = ?, valor = ?, ra = ?,"
            + " conta_origem = ?, conta_destino = ? WHERE id = ?";
    private static final String DELETE_BY_ID =
            "DELETE FROM TRANSACAO WHERE id = ?";
    private static final String FIND_ALL =
            "SELECT id, tipo, data_hora, valor, ra, conta_origem,"
            + " conta_destino FROM TRANSACAO";
    private static final String FIND_BY_ID =
            "SELECT id, tipo, data_hora, valor, ra, conta_origem,"
            + " conta_destino FROM TRANSACAO WHERE id = ?";

    public List<Transacao> findAll() throws SQLException {
        List<Transacao> transacoes = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Transacao transacao = new Transacao();
                transacao.setId(rs.getInt("id"));
                transacao.setTipo(rs.getString("tipo"));
                transacao.setData_hora(rs.getDate("data_hora"));
                transacao.setValor(rs.getDouble("valor"));
                transacao.setRa(rs.getString("ra"));
                transacao.setContaOrigem(rs.getString
        ("conta_origem"));
                transacao.setContaDestino(rs.getString
        ("conta_destino"));

                transacoes.add(transacao);
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

        return transacoes;
    }

    public Transacao findById(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Transacao transacao = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                transacao = new Transacao();
                transacao.setId(rs.getInt("id"));
                transacao.setTipo(rs.getString("tipo"));
                transacao.setData_hora(rs.getDate
        ("data_hora"));
                transacao.setValor(rs.getDouble("valor"));
                transacao.setRa(rs.getString("ra"));
                transacao.setContaOrigem(rs.getString
        ("conta_origem"));
                transacao.setContaDestino(rs.getString
        ("conta_destino"));
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

        return transacao;
    }

    public void insert(Transacao transacao) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setInt(1, transacao.getId());
            pstmt.setInt(2, transacao.getTipo());
            pstmt.setDate(3, transacao.getData_hora());
            pstmt.setDouble(4, transacao.getValor());
            pstmt.setString(5, transacao.getRa());
            pstmt.setString(6, transacao.getContaOrigem());
            pstmt.setString(7, transacao.getContaDestino());

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

    public void update(Transacao transacao) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setInt(1, transacao.getTipo());
            pstmt.setDate(2, transacao.getData_hora());
            pstmt.setDouble(3, transacao.getValor());
            pstmt.setString(4, transacao.getRa());
            pstmt.setString(5, transacao.getContaOrigem());
            pstmt.setString(6, transacao.getContaDestino());
            pstmt.setInt(7, transacao.getId());

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
