package projetojavadb;

import java.sql.*;
import java.util.*;

public class CarroDAO {

    private Connection con;

    public CarroDAO(Connection con) {
        setCon(con);
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    

    public String inserir(CarroBean carro) {
        String sql = "INSERT INTO Carro(placa, cor, descricao) VALUES(?,?,?)";

        try {
            PreparedStatement ps = getCon().prepareStatement(sql);

            ps.setString(1, carro.getPlaca());
            ps.setString(2, carro.getCor());
            ps.setString(3, carro.getDescricao());

            if (ps.executeUpdate() > 0) {
                return "Inserido com sucesso";
            } else {
                return "Erro ao inserir";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    public String alterar(CarroBean carro) {
        String sql = "UPDATE Carro SET cor = ?, descricao = ? WHERE placa = ?";

        try {
            PreparedStatement ps = getCon().prepareStatement(sql);

            ps.setString(2, carro.getPlaca());
            ps.setString(3, carro.getCor());
            ps.setString(1, carro.getDescricao());

            if (ps.executeUpdate()>0) {
                return "Alterado com sucesso";
            } else {
                return "Erro ao alterar";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    public String excluir(CarroBean carro) {
        String sql = "DELETE FROM Carro WHERE placa=?";

        try {
            PreparedStatement ps = getCon().prepareStatement(sql);

            ps.setString(1, carro.getPlaca());

            if (ps.executeUpdate() > 0) {
                return "Deletado com sucesso";
            } else {
                return "Erro ao deletar";
            }

        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    public List<CarroBean> listarTodos() {
        String sql = "SELECT * FROM Carro";

        List<CarroBean> listaCarro = new ArrayList<CarroBean>();

        try {
            PreparedStatement ps = getCon().prepareStatement(sql);

            ResultSet rs = ps.executeQuery(sql);

            if (rs != null) {
                while (rs.next()) {
                    CarroBean carroBean = new CarroBean();

                    carroBean.setPlaca(rs.getString(1));
                    carroBean.setCor(rs.getString(2));
                    carroBean.setDescricao(rs.getString(3));

                    listaCarro.add(carroBean);
                }
                return listaCarro;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

}
