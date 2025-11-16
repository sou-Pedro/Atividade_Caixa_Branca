package login;

import java.sql.Connection;
import java.sql.DriverManager;
importjava.sql.ResultSet;
import java.sql.Statement;

public class User {

    public Connection conectarBD(){
        Connection conn = null;
        try{
            // erro: este driver não existe. o correto seria "com.mysql.cj.jdbc.Driver".
            Class.forName("com.mysql.Driver.Manager").newInstance();

            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";

            conn = DriverManager.getConnection(url);
        }catch (Exception e) { 
            // erro: catch vazio esconde erros e dificulta o debug.
        }
        return conn; // erro: retorna null se a conexão falhar.
    }

    public String nome="";
    public boolean result = false;

    public boolean verificarUsuario(String login, String senha){
        String sql = "";
        Connection conn = conectarBD();

         // erro: se a conexão falha, conn fica null e o método quebra depois.

        // instrução sql
        sql += "select nome from usuarios ";
        
        // erro: montar sql concatenando strings permite sql injection.
        sql += "where login = '" + login + "'";
        sql += " and senha = '" + senha + "';";

        try{
            // erro: se conn for null, isso gera nullpointerexception.
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(sql);

            if(rs.next()){
                result = true;
                nome = rs.getString("nome");
            }
        }catch (Exception e) { 
            // erro: exceções ignoradas, problema real nunca é mostrado.
        }

        // erro: nenhuma das conexões e objetos sql é fechado (conn, st, rs).

        return result;
    }

}//fim da class
