package com.map;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Details {

	@Id
	@Column(name = "details_id")
	private int detailsId;

	private String noteDescription;

	public Details() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Details(int detailsId, String noteDescription) {
		super();
		this.detailsId = detailsId;
		this.noteDescription = noteDescription;
	}

	public int getDetailsId() {
		return detailsId;
	}

	public void setDetailsId(int detailsId) {
		this.detailsId = detailsId;
	}

	public String getNoteDescription() {
		return noteDescription;
	}

	public void setNoteDescription(String noteDescription) {
		this.noteDescription = noteDescription;
	}

	@Override
	public String toString() {
		return "Details [detailsId=" + detailsId + ", noteDescription=" + noteDescription + "]";
	}

}
