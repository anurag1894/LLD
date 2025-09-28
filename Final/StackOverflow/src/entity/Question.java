package entity;

import java.util.ArrayList;
import java.util.List;

public class Question extends Post{
    private String question;
    private Answer acceptedAnswer;
    private List<Answer> answers;
    public Question(String title, String body, User user){
        super(body, user);
        this.question = title;
        this.acceptedAnswer = null;
        this.answers = new ArrayList<>();
    }
    public void setAcceptedAnswer(Answer answer){
        this.acceptedAnswer = answer;
    }

    public String getId(){
        return this.id;
    }

    public void addAnswer(Answer answer){
        this.answers.add(answer);
    }
}
