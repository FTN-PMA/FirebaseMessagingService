package rs.ftn.reviewer.rest.util;

import java.util.Date;

import rs.ftn.reviewer.rest.dao.TagHibernateDao;
import rs.ftn.reviewer.rest.ejb.Tag;

public class Test {

	public static void main(String[] args) {
		HibernateUtil.getSessionfactory();
		
		Tag t = new Tag();
		t.setName("Tag1");
		t.setDateModified(new Date());
		
		TagHibernateDao thd = new TagHibernateDao();
		thd.save(t);
	}

}
