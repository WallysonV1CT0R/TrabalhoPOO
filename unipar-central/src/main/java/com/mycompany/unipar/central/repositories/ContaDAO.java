package com.mycompany.unipar.central.repositories;

import com.mycompany.unipar.central.model.Banco;
import com.mycompany.unipar.central.model.Conta;
import com.mycompany.unipar.central.utils.DatabaseUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContaDAO {

    private static final String INSERT =
            "INSERT INTO CONTA(id, conta, agencia, digito,"
            + " tipo, saldo, ra, banco_id) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE =
            "UPDATE CONTA SET conta = ?, agencia = ?, digito = ?,"
            + " tipo = ?, saldo = ?, ra = ?, banco_id = ? " +
            "WHERE id = ?";
    private static final String DELETE_BY_ID =
            "DELETE FROM CONTA WHERE id = ?";
    private static final String FIND_ALL =
            "SELECT id, conta, agencia, digito, tipo, saldo, ra,"
            + " banco_id FROM CONTA";
    private static final String FIND_BY_ID =
            "SELECT id, conta, agencia, digito, tipo, saldo, ra,"
            + " banco_id FROM CONTA WHERE id = ?";

    public List<Conta> findAll() throws SQLException {
        List<Conta> contas = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Conta conta = new Conta();
                conta.setId(rs.getInt("id"));
                conta.setConta(rs.getString("conta"));
                conta.setAgencia(rs.getString("agencia"));
                conta.setDigito(rs.getString("digito"));
                conta.setTipo(rs.getInt("tipo"));
                conta.setSaldo(rs.getDouble("saldo"));
                conta.setRa(rs.getString("ra"));
               conta.setBanco(new BancoDAO().findById(rs.getInt
        ("BANCO_ID")));

                contas.add(conta);
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

        return contas;
    }

    public Conta findById(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Conta conta = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                conta = new Conta();
                conta.setId(rs.getInt("id"));
                conta.setConta(rs.getString("conta"));
                conta.setAgencia(rs.getString("agencia"));
                conta.setDigito(rs.getString("digito"));
                conta.setTipo(rs.getInt("tipo"));
                conta.setSaldo(rs.getDouble("saldo"));
                conta.setRa(rs.getString("ra"));
                conta.setBanco(new BancoDAO().findById(rs.getInt
        ("BANCO_ID")));
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

        return conta;
    }

    public void insert(Conta conta) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setInt(1, conta.getId());
            pstmt.setString(2, conta.getConta());
            pstmt.setString(3, conta.getAgencia());
            pstmt.setString(4, conta.getDigito());
            pstmt.setInt(5, conta.getTipo());
            pstmt.setDouble(6, conta.getSaldo());
            pstmt.setString(7, conta.getRa());
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

    public void update(Conta conta) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, conta.getConta());
            pstmt.setString(2, conta.getAgencia());
            pstmt.setString(3, conta.getDigito());
            pstmt.setInt(4, conta.getTipo());
            pstmt.setDouble(5, conta.getSaldo());
            pstmt.setString(6, conta.getRa());
            pstmt.setInt(7, conta.getId());
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
