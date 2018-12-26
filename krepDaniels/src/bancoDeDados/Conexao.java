package bancoDeDados;

import java.sql.*;

import javax.swing.JOptionPane;

public class Conexao {
	static String status = "";
	public Connection connection = null;
	public Statement statement = null;
	public ResultSet resultSet = null;
	private String usuario;
	private String senha;
	public void conectar(String usuario, String senha) {
		String servidor = "jdbc:mysql://localhost:3306/krepDaniels";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection(servidor, usuario, senha);
			this.statement = this.connection.createStatement();
		} catch (SQLException e) {
			retornaErro("Erro: " + e);
		} catch (Exception e) {
			retornaErro("Não foi possivel conectar no banco de dados! Erro: " + e);
		}
	}
	public JOptionPane retornaErro(String Mensagem) {
		JOptionPane.showMessageDialog(null, Mensagem, "Erro no Login", JOptionPane.ERROR_MESSAGE);
		return null;
	}
	public void desconectar() {
		try {
			this.connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String estaConectado() {
		if (this.connection != null) {
			return "Conectado com sucesso!";
		} else {
			return "OPS! Algo deu errado, não foi possível conectar ao banco de dados";
		}
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
