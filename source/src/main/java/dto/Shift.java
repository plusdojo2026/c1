package dto;

import java.io.Serializable;

public class Shift implements Serializable {

    private int id;
    private String user_name;
    private String date;
    private String clock_in;
    private String clock_out;
    private String real_in;
    private String real_out;

    public Shift() {
        this.id = 0;
        this.user_name = "";
        this.date = "";
        this.clock_in = "";
        this.clock_out = "";
        this.real_in = "";
        this.real_out = "";
    }

    public Shift(int id, String user_name, String date,
                 String clock_in, String clock_out,
                 String real_in, String real_out) {

        this.id = id;
        this.user_name = user_name;
        this.date = date;
        this.clock_in = clock_in;
        this.clock_out = clock_out;
        this.real_in = real_in;
        this.real_out = real_out;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getClock_in() {
		return clock_in;
	}

	public void setClock_in(String clock_in) {
		this.clock_in = clock_in;
	}

	public String getClock_out() {
		return clock_out;
	}

	public void setClock_out(String clock_out) {
		this.clock_out = clock_out;
	}

	public String getReal_in() {
		return real_in;
	}

	public void setReal_in(String real_in) {
		this.real_in = real_in;
	}

	public String getReal_out() {
		return real_out;
	}

	public void setReal_out(String real_out) {
		this.real_out = real_out;
	}

}