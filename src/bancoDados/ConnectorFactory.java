package bancoDados;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;


/**Classe usada para conectar ao banco de dados.
 * @author Silvério Rodrigues
 * @since 12//12/2017
 */

public class ConnectorFactory {

	/**
	 * @return
	 * @throws SQLException
	 */
	public static Connection conecta() throws SQLException{
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String Conexao = "jdbc:mysql://localhost:3306/nisiasgbd";
		String user = "root";
		String password = "ifrnjc";
		
		return (Connection) DriverManager.getConnection(Conexao, user, password);
		
	}
	
}
