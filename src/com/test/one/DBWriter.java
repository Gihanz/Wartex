package com.test.one;

import java.sql.Connection;

public class DBWriter {

	public boolean addTwitterFeed(String [] ar) throws Exception {
		Connection con = new DBConn().getConnection();
		String query = " insert into twitter_feed(Text,UserID,Location,Date,Time,Favorites_count,Followers_count,Retweet_count) values('"+ar[1]+"','"+Integer.parseInt(ar[2])+"','"+ar[3]+"','"+ar[4]+"','"+ar[5]+"','"+ar[6]+"','"+ar[7]+"','"+ar[8]+"')";
		int rst = DBHandle.setData(con, query);

		if (rst > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean addTwitterPolarity(String id,String ar) throws Exception {
		Connection con = new DBConn().getConnection();
		String query = "UPDATE twitter_feed SET polarity='"+ar+"' WHERE ID ="+id;
		int rst = DBHandle.setData(con, query);

		if (rst > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean addFacebookPolarity(String id,String ar) throws Exception {
		Connection con = new DBConn().getConnection();
		String query = "UPDATE facebook_post SET polarity='"+ar+"' WHERE PostID ="+id;
		int rst = DBHandle.setData(con, query);

		if (rst > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean addTwitterUser(String [] ar) throws Exception {
		Connection con = new DBConn().getConnection();
		String query = " insert into twitter_user(Name,Age,Country,City,Telephone,Following_Count,Followers_Count,Tweets_count) values('"+ar[1]+"','"+ar[2]+"','"+ar[3]+"','"+ar[4]+"','"+ar[5]+"','"+ar[6]+"','"+ar[7]+"','"+ar[8]+"')";
		int rst = DBHandle.setData(con, query);

		if (rst > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean addFacebookUser(String [] ar) throws Exception {
		Connection con = new DBConn().getConnection();
		String query = " insert into facebook_user(ID,Username,Country,City,Followers_count, Post_count,Relationship_status,Age,Gender) values('"+ar[0]+"','"+ar[1]+"','"+ar[2]+"','"+ar[3]+"','"+ar[4]+"','"+ar[5]+"','"+ar[6]+"','"+ar[7]+"','"+ar[8]+"')";
		int rst = DBHandle.setData(con, query);

		if (rst > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean addFacebookPost(String [] ar) throws Exception {
		Connection con = new DBConn().getConnection();
		String query = " insert into facebook_post(PostID,Text,UserID,date,time,location,likes_count,share_count,comment_count) values('"+ar[0]+"','"+ar[1]+"','"+ar[2]+"','"+ar[3]+"','"+ar[4]+"','"+ar[5]+"','"+ar[6]+"','"+ar[7]+"','"+ar[8]+"')";
		int rst = DBHandle.setData(con, query);

		if (rst > 0) {
			return true;
		} else {
			return false;
		}
	}
}
