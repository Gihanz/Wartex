package com.test.one;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBReader {

	Connection con;

	public DBReader() throws Exception {
		con = new DBConn().getConnection();
	}

	public String[] getDataset(String id) throws SQLException {
		String getquery = "SELECT * FROM dataset2";
		ResultSet res = DBHandle.getData(con, getquery);
		String[] ar = new String[9];
		while (res.next()) {
			for (int i = 0; i < ar.length; i++)
				ar[i] = res.getString(i + 1);
		}
		return ar;
	}

	public String[] getFacebookUser(String id) throws SQLException {
		String getquery = "SELECT * FROM facebook_user WHERE ID ='" + id + "'";
		ResultSet res = DBHandle.getData(con, getquery);
		String[] ar = new String[9];

		while (res.next()) {
			for (int i = 0; i < ar.length; i++)
				ar[i] = res.getString(i + 1);

		}
		return ar;
	}

	public String[] getTwitterFeed(String id) throws SQLException {
		String getquery = "SELECT * FROM twitter_feed WHERE ID ='" + id + "'";
		ResultSet res = DBHandle.getData(con, getquery);
		String[] ar = new String[9];
		while (res.next()) {
			for (int i = 0; i < ar.length; i++)
				ar[i] = res.getString(i + 1);

		}
		return ar;
	}

	public String[] getFacebookPost(String id) throws SQLException {
		String getquery = "SELECT * FROM facebook_post WHERE PostID ='" + id
				+ "'";
		ResultSet res = DBHandle.getData(con, getquery);
		String[] ar = new String[9];

		while (res.next()) {
			for (int i = 0; i < ar.length; i++)
				ar[i] = res.getString(i + 1);

		}
		return ar;
	}
	
	public String[] getTwitterFeedByUser(String id) throws SQLException {
		String getquery = "SELECT * FROM twitter_feed WHERE UserID ='" + id + "'";
		ResultSet res = DBHandle.getData(con, getquery);
		String[] ar = new String[9];
		while (res.next()) {
			for (int i = 0; i < ar.length; i++)
				ar[i] = res.getString(i + 1);

		}
		return ar;
	}

	public String[] getFacebookPostByUser(String id) throws SQLException {
		String getquery = "SELECT * FROM facebook_post WHERE UserID ='" + id
				+ "'";
		ResultSet res = DBHandle.getData(con, getquery);
		String[] ar = new String[9];

		while (res.next()) {
			for (int i = 0; i < ar.length; i++)
				ar[i] = res.getString(i + 1);

		}
		return ar;
	}

	public ArrayList<String[]> getTwitterUserAll() throws SQLException {
		String getquery = "SELECT * FROM twitter_user";
		ResultSet res = DBHandle.getData(con, getquery);
		ArrayList<String[]> list = new ArrayList<String[]>();
		while (res.next()) {
			String[] ar = new String[9];
			for (int i = 0; i < ar.length; i++){
				ar[i] = res.getString(i + 1);
			}
			list.add(ar);
		}
		return list;
	}

	public ArrayList<String[]> getFacebookUserAll() throws SQLException {
		String getquery = "SELECT * FROM facebook_user";
		ResultSet res = DBHandle.getData(con, getquery);
		ArrayList<String[]> list = new ArrayList<String[]>();
		while (res.next()) {
			String[] ar = new String[9];
			for (int i = 0; i < ar.length; i++){
				ar[i] = res.getString(i + 1);
			}
			list.add(ar);
		}
		return list;
	}

	public ArrayList<String[]> getTwitterFeedAll() throws SQLException {
		String getquery = "SELECT * FROM dataset2";
		
		ResultSet res = DBHandle.getData(con, getquery);
		ArrayList<String[]> list = new ArrayList<String[]>();
		while (res.next()) {
			String[] ar = new String[3];
			for (int i = 0; i < ar.length; i++){
				ar[i] = res.getString(i + 1);
				System.out.println(ar[i]);
			}
			list.add(ar);
		}
		return list;
	}

	public ArrayList<String[]> getFacebookPostAll() throws SQLException {
		String getquery = "SELECT * FROM facebook_post as p  NATURAL JOIN  `facebook_user`as u WHERE p.userID = u.ID";
		ResultSet res = DBHandle.getData(con, getquery);
		ArrayList<String[]> list = new ArrayList<String[]>();
		while (res.next()) {
			String[] ar = new String[18];
			for (int i = 0; i < ar.length; i++){
				ar[i] = res.getString(i + 1);
			}
			list.add(ar);
		}
		return list;
	}

}
