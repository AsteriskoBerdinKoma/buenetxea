package buenetxea.kudeatzaileak;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import buenetxea.db.Connector;
import buenetxea.objektuak.Propietario;

public class PropietarioKud {
	private static PropietarioKud instance;
	private final Connection connection;
	private final Statement statement;
	
	public PropietarioKud () throws SQLException, ClassNotFoundException
	{
		this.connection=Connector.getConnection();
		this.statement=Connector.getStatement();
	
	}
	public static PropietarioKud getInstance() throws SQLException,
	ClassNotFoundException {
		if (null == instance)
			instance = new PropietarioKud();
	return instance;
}
	
	Propietario getPropietario (String nan) throws SQLException 
	{
		 String dni;
		 String nombre;
		 String apellido1;
		 String apellido2;
		 String domicilio_postal;
		 int cp;
		 String ciudad;
		 int tel_fijo;
		 int tel_movil;
		 String horario_fijo;
		 String horario_movil;
		 String observaciones;
		 String query="SELECT * FROM propietario WHERE dni=" + nan;
		 ResultSet rs= this.statement.executeQuery(query);
		 if (rs.next())
		 {
			 dni=rs.getString("dni");
			 nombre=rs.getString("nombre");
			 nombre=rs.getString("nombre");
			 apellido1=rs.getString("apellido1");
			 apellido2=rs.getString("apellido2");
			 domicilio_postal=rs.getString("domicilio_postal");
			 cp=rs.getInt("cp");
			 ciudad=rs.getString("ciudad");
			 tel_fijo=rs.getInt("tel_fijo");
			 tel_movil=rs.getInt("tel_movil");
			 horario_fijo=rs.getString("horario_fijo");
			 horario_movil=rs.getString("horario_movil");
			 observaciones=rs.getString("observaciones");
			 return new Propietario (dni,nombre,apellido1,apellido2,domicilio_postal,
					 cp,ciudad,tel_fijo,tel_movil,horario_fijo,horario_movil,observaciones);
			 
			 
		 }
		 else
			 return null;
		 
	}
	public boolean InsertPropietario (String dni, String nombre, String apellido1, String apellido2, 
			int cp, String ciudad, int tel_fijo, int tel_movil,String horario_fijo, String horario_movil,
			String observaciones) throws SQLException
	{	if (getPropietario(dni) == null )
			{
			String query="INSERT INTO Propietario SET " ;
			try {
				int rs= this.statement.executeUpdate(query);
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				return false;
			}
		
			}
		return false;
	}
}
