package com.map;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {

        // Create Configuration and SessionFactory
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        // Create session
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        // Create and save the Details objects 
        Details details1 = new Details();
        details1.setDetailsId(101);
        details1.setNoteDescription("This is the first note's details.");
        session.save(details1);

        Details details2 = new Details();
        details2.setDetailsId(102);
        details2.setNoteDescription("Details of the second note.");
        session.save(details2);

        Details details3 = new Details();
        details3.setDetailsId(103);
        details3.setNoteDescription("This note describes a third example.");
        session.save(details3); 

        // create Note objects and associate them with saved Details
        Note note1 = new Note();
        note1.setNoteId(1);
        note1.setNoteTitle("First Note");
        note1.setDetails(details1); // Associate saved Details with Note
        session.save(note1); 

        Note note2 = new Note();
        note2.setNoteId(2);
        note2.setNoteTitle("Second Note");
        note2.setDetails(details2);
        session.save(note2); 

        Note note3 = new Note();
        note3.setNoteId(3);
        note3.setNoteTitle("Third Note");
        note3.setDetails(details3);
        session.save(note3); 

        // Commit the transaction
        tx.commit();

        // Retrieve the data from the database
        List<Note> notes = session.createQuery("from Note", Note.class).list();
        for (Note note : notes) {
            System.out.println(note);
        }

        // Close the session and factory
        session.close();
        factory.close();
    }
}
