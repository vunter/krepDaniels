package bancoDeDados;
import bancoDeDados.Conexao;
public class TesteConexao {
	public static void main(String[] args) {
		
		Conexao conn = new Conexao();
		conn.conectar("vunte", "2025");
		System.out.println(conn.estaConectado());
	}

}
