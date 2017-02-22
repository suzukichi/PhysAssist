package logic;

import java.util.ArrayList;

public class Topic {
	public long topicID;
	public String title, info;
	public ArrayList<Equation> equations;
	public ArrayList<Quiz> quizzes;
	
	public Topic(long topicID) {
		// TODO: get from db
	}
	
	public Topic(String title, String info) {
		if (title.length() < 1) {
			throw new IllegalArgumentException("Topic titles must be more than one character long.");
		}

		this.title = title;
		this.info = info;
		this.equations = new ArrayList<Equation>();
		this.quizzes = new ArrayList<Quiz>();
	}
	
	public void addEquation(Equation equation) {
		equations.add(equation);
	}
}
