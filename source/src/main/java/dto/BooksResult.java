package dto;

import java.io.Serializable;

public class BooksResult implements Serializable {
	private String title; // タイトル
	private String message; // メッセージ
	private String backTo; // 戻り先

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getBackTo() {
		return backTo;
	}

	public void setBackTo(String backTo) {
		this.backTo = backTo;
	}

	public BooksResult() {
		this(null, null, null);
	}

	public BooksResult(String title, String message, String backTo) {
		this.title = title;
		this.message = message;
		this.backTo = backTo;
	}
}
