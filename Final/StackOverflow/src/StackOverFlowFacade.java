import entity.Answer;
import entity.Post;
import entity.Question;

import java.util.HashMap;
import java.util.Map;
import entity.User;
import enums.EventType;
import enums.VoteType;

public class StackOverFlowFacade {
    private Map<String,User> users;
    private Map<String, Question> questions;
    private Map<String, Answer> answers;
    public StackOverFlowFacade() {
        users = new HashMap<>();
        questions = new HashMap<>();
        answers = new HashMap<>();
    }
    public void addUser(User user) {
        users.put(user.getId(),user);
    }
    public Question addQuestion(String title, User user, String body) {
        Question question = new Question(title,body,user);
        questions.put(question.getId(),question);
        return question;
    }

    public Answer addAnswer(String questionId, String body, User user){
        Question question = questions.get(questionId);
        Answer answer = new Answer(body, user);
        question.addAnswer(answer);
        answers.put(answer.getId(), answer);
        return answer;
    }

    public void acceptAnswer(String questionId, String answerId) {
        Answer answer = answers.get(answerId);
        Question question = questions.get(questionId);
        question.setAcceptedAnswer(answer);
        answer.setAccepted();
    }

    private Post findPostById(String postId) {
        if(questions.containsKey(postId)) {
            return questions.get(postId);
        } else if (answers.containsKey(postId)) {
            return answers.get(postId);
        } else {
            return null;
        }
    }
    public synchronized void vote(String postId, User user, VoteType voteType) {
        Post post = findPostById(postId);
        if(post instanceof Question) {
            post.vote(user,voteType);
        } else if(post instanceof Answer) {
            post.vote(user,voteType);
        } else {
            System.out.println("Invalid post");
        }


    }

}
