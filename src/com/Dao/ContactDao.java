package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import com.entity.Contact;

public class ContactDao {
	private Connection conn;

	public ContactDao(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean saveContact(Contact c) {

		boolean f = false;
		try {
			PreparedStatement ps = conn.prepareStatement("insert into contact(id,name,phone) values(?,?,?)");
			ps.setInt(1, c.getId());
			ps.setString(2, c.getName());
			ps.setString(3, c.getPhone());
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return f;
	}

	public boolean editContact(Contact c) {

		boolean f = false;
		try {
			PreparedStatement ps = conn.prepareStatement("update contact set phone=? where id=?");
			ps.setString(1, c.getPhone());
			ps.setInt(2, c.getId());
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return f;
	}

	public boolean deleteContact(int id) {
		boolean f = false;
		try {
			PreparedStatement ps = conn.prepareStatement("delete from contact where id=?");
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return f;
	}

	public List<Contact> getAllContact() {
		List<Contact> list = new ArrayList<Contact>();
		Contact obj = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from contact ");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				obj = new Contact();
				obj.setId(rs.getInt(1));
				obj.setName(rs.getString(2));
				obj.setPhone(rs.getString(3));
				list.add(obj);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
}
