package com.trip.dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ImagesDao {
	public ArrayList<String> query(int id) throws SQLException;
}
