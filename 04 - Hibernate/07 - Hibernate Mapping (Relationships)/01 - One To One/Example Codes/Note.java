package com.map;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Note {

	@Id
	@Column(name = "note_id")
	private int noteId;

	private String noteTitle;

	@OneToOne
	private Details details;

	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Note(int noteId, String noteTitle, Details details) {
		super();
		this.noteId = noteId;
		this.noteTitle = noteTitle;
		this.details = details;
	}

	public int getNoteId() {
		return noteId;
	}

	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}

	public String getNoteTitle() {
		return noteTitle;
	}

	public void setNoteTitle(String noteTitle) {
		this.noteTitle = noteTitle;
	}

	public Details getDetails() {
		return details;
	}

	public void setDetails(Details details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "Note [noteId=" + noteId + ", noteTitle=" + noteTitle + ", details=" + details + "]";
	}

}
