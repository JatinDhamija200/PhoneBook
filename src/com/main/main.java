package com.main;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import com.Dao.ContactDao;
import com.conn.DBConnect;
import com.entity.Contact;

public class main {
	public static void main(String[] args) {
		boolean f = true;
		ContactDao cd = new ContactDao(DBConnect.getConn());
		while (f) {
			System.out.println("..........................");
			System.out.println("1. Create Contact");
			System.out.println("2. Edit Contact");
			System.out.println("3. Delete Contact");
			System.out.println("4. View Contact");
			System.out.println("5. Exit");
			System.out.println("..........................");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter No.: ");
			int number = sc.nextInt();

			switch (number) {
			case 1:
				
				System.out.println("Enter Name");
				String name = sc.next();
				System.out.println("Enter Number");
				String phone = sc.next();
				Contact c = new Contact();
				
				c.setName(name);
				c.setPhone(phone);
				boolean t = cd.saveContact(c);
				if (t) {
					System.out.println("Ph No. Saved");
				} else {
					System.out.println("Server Error");
				}
				break;
			case 2:
				System.out.println("Enter Id");
				int id = sc.nextInt();
				System.out.println("Enter Name");
				String name2 = sc.next();
				System.out.println("Enter Number");
				String phone2 = sc.next();
				Contact c2 = new Contact();
				c2.setId(id);
				c2.setName(name2);
				c2.setPhone(phone2);
				boolean s2 = cd.editContact(c2);
				if (s2) {
					System.out.println("Edit Success");
				} else {
					System.out.println("User is Not Available");
				}
				break;
			case 3:
				System.out.println("Enter Id");
				int id1 = sc.nextInt();
				boolean s3 = cd.deleteContact(id1);
				if (s3) {
					System.out.println("Phone Delete Success");
				} else {
					System.out.println("User is Not Available");
				}
				break;
			case 4:
				List<Contact> list = cd.getAllContact();
				if (list.isEmpty()) {
					System.out.println("Phone is Not Available");
				} else {
					for (Contact con : list) {
						System.out.println("ID = " + con.getId());
						System.out.println("Name = " + con.getName());
						System.out.println("Phone = " + con.getPhone());
						System.out.println(".........................");
					}
				}
				break;
			case 5:
				f = false;
				System.out.println("Thank You");
				break;
			default:
				System.out.println("Enter Valid No.");
				break;
			}
		}
	}
}
