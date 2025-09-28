import entity.User;
import entity.Question;
import entity.Answer;
import enums.VoteType;

public class DemoMain {
    public static void main(String[] args) {
        System.out.println("=== StackOverflow System Demo ===\n");
        
        // Initialize the StackOverflow facade
        StackOverFlowFacade stackOverflow = new StackOverFlowFacade();
        
        // Create users
        System.out.println("1. Creating Users:");
        User alice = new User("Alice", "user1");
        User bob = new User("Bob", "user2");
        User charlie = new User("Charlie", "user3");
        User diana = new User("Diana", "user4");
        
        stackOverflow.addUser(alice);
        stackOverflow.addUser(bob);
        stackOverflow.addUser(charlie);
        stackOverflow.addUser(diana);
        
        System.out.println("Created users: " + alice.getName() + ", " + bob.getName() + 
                          ", " + charlie.getName() + ", " + diana.getName());
        System.out.println("Initial reputations: Alice=" + alice.getReput() + 
                          ", Bob=" + bob.getReput() + 
                          ", Charlie=" + charlie.getReput() + 
                          ", Diana=" + diana.getReput() + "\n");
        
        // Create questions
        System.out.println("2. Creating Questions:");
        Question q1 = stackOverflow.addQuestion(
            "How to implement Singleton pattern in Java?", 
            alice, 
            "I need to understand the best way to implement Singleton pattern in Java with thread safety."
        );
        
        Question q2 = stackOverflow.addQuestion(
            "What is the difference between ArrayList and LinkedList?", 
            bob, 
            "Can someone explain when to use ArrayList vs LinkedList in Java?"
        );
        
        System.out.println("Question 1 created by " + alice.getName() + ": " + q1.getId());
        System.out.println("Question 2 created by " + bob.getName() + ": " + q2.getId());
        System.out.println();
        
        // Add answers
        System.out.println("3. Adding Answers:");
        Answer a1 = stackOverflow.addAnswer(q1.getId(), 
            "Use enum singleton pattern for thread safety: public enum Singleton { INSTANCE; }", 
            charlie);
        
        Answer a2 = stackOverflow.addAnswer(q1.getId(), 
            "Use double-checked locking with volatile keyword for lazy initialization.", 
            diana);
        
        Answer a3 = stackOverflow.addAnswer(q2.getId(), 
            "ArrayList is better for random access, LinkedList is better for frequent insertions/deletions.", 
            alice);
        
        System.out.println("Answer 1 to Q1 by " + charlie.getName());
        System.out.println("Answer 2 to Q1 by " + diana.getName());
        System.out.println("Answer 3 to Q2 by " + alice.getName());
        System.out.println();
        
        // Demonstrate voting
        System.out.println("4. Voting on Questions and Answers:");
        
        // Vote on questions
        stackOverflow.vote(q1.getId(), bob, VoteType.UPVOTE);
        stackOverflow.vote(q1.getId(), charlie, VoteType.UPVOTE);
        stackOverflow.vote(q2.getId(), diana, VoteType.UPVOTE);
        stackOverflow.vote(q2.getId(), charlie, VoteType.DOWNVOTE);
        
        System.out.println("Voted on questions - Bob and Charlie upvoted Q1");
        System.out.println("Diana upvoted Q2, Charlie downvoted Q2");
        
        // Vote on answers  
        stackOverflow.vote(a1.getId(), alice, VoteType.UPVOTE);
        stackOverflow.vote(a1.getId(), bob, VoteType.UPVOTE);
        stackOverflow.vote(a2.getId(), bob, VoteType.DOWNVOTE);
        stackOverflow.vote(a3.getId(), charlie, VoteType.UPVOTE);
        
        System.out.println("Voted on answers - Alice and Bob upvoted Answer1");
        System.out.println("Bob downvoted Answer2, Charlie upvoted Answer3");
        System.out.println();
        
        // Show reputation after voting
        System.out.println("5. Reputation after voting:");
        System.out.println("Alice: " + alice.getReput() + " (asked question, answered, got upvote)");
        System.out.println("Bob: " + bob.getReput() + " (asked question)");
        System.out.println("Charlie: " + charlie.getReput() + " (answered, got upvotes)");
        System.out.println("Diana: " + diana.getReput() + " (answered, got downvote)");
        System.out.println();
        
        // Accept answers
        System.out.println("6. Accepting Answers:");
        stackOverflow.acceptAnswer(q1.getId(), a1.getId()); // Alice accepts Charlie's answer
        stackOverflow.acceptAnswer(q2.getId(), a3.getId()); // Bob accepts Alice's answer
        
        System.out.println("Alice accepted Charlie's answer for Q1");
        System.out.println("Bob accepted Alice's answer for Q2");
        System.out.println();
        
        // Final reputation check
        System.out.println("7. Final Reputation After Answer Acceptance:");
        System.out.println("Alice: " + alice.getReput() + " (bonus for accepted answer)");
        System.out.println("Bob: " + bob.getReput());
        System.out.println("Charlie: " + charlie.getReput() + " (bonus for accepted answer)");
        System.out.println("Diana: " + diana.getReput());
        System.out.println();
        
        System.out.println("=== Demo Complete ===");
        System.out.println("The system successfully demonstrated:");
        System.out.println("- User creation and management");
        System.out.println("- Question posting");
        System.out.println("- Answer posting");
        System.out.println("- Voting system with reputation updates");
        System.out.println("- Answer acceptance with reputation bonuses");
    }
}
