package projetojavadb;

import java.sql.*;
import java.util.*;

public class Teste {

    public static void main(String[] args) {
        Connection con = new Conexao().abrirConexao();

        CarroBean carroBean = new CarroBean();
        CarroDAO carroDao = new CarroDAO(con);
//        
//        carroBean.setPlaca("FHK6023");
//        carroBean.setCor("Azul");
//        carroBean.setDescricao("pika");
//        
//        System.out.println(carroDao.inserir(carroBean));
//        
//        carroBean.setPlaca("FJR1000");
//        carroBean.setCor("amarelo");
//        carroBean.setDescricao("teste");
//        
//        System.out.println(carroDao.inserir(carroBean));
        
        carroBean.setPlaca("FJR1000");
        carroBean.setCor("roxo");
        carroBean.setDescricao("TESTE2");
        
        System.out.println(carroDao.alterar(carroBean));
    }
}
