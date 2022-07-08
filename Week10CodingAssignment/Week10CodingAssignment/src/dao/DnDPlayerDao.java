package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.DnDPlayer;

public class DnDPlayerDao {
	
	private Connection connection;
	private final String CREATE_NEW_PLAYER_QUERY = "Insert Into dndplayer(first_name,last_name, race, class) Values(?,?,?,?)";
	private final String SHOW_PLAYERS_QUERY = "Select * From dndplayer";
	private final String DELETE_PLAYER_BY_ID_QUERY = "Delete From dndplayer Where id = ?";
	
	
	public DnDPlayerDao() {
		connection = DBConnection.getConnection();
	}

	
	public void createPlayer(String firstName,String lastName, String race, String classes) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_PLAYER_QUERY);
		ps.setString(1, firstName);
		ps.setString(2, lastName);
		ps.setString(3, race);
		ps.setString(4, classes);
		ps.executeUpdate();
	}
	
	public List<DnDPlayer> showPlayers() throws SQLException {
		ResultSet rs = connection.prepareStatement(SHOW_PLAYERS_QUERY).executeQuery();
		
		List<DnDPlayer> players = new ArrayList<DnDPlayer>();
		while (rs.next()) {
			players.add(new DnDPlayer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
		}
		return players;
	}
	
	public void deletePlayerById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_PLAYER_BY_ID_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	
	
	
}
