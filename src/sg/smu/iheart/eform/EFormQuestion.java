package sg.smu.iheart.eform;

public class EFormQuestion {
	public String question;
	public Boolean isAnswered = false;
	public int choice = 0;
	public Boolean answer;
	public EFormQuestion(String question, Boolean answer) {
		super();
		this.question = question;
		this.answer = answer;
	}
	
}
