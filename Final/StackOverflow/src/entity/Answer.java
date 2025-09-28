package entity;

import enums.EventType;

public class Answer extends Post{
        private boolean isAccepted;
        public Answer(String answer, User user) {
            super(answer, user);
            isAccepted = false;
        }
        public boolean isAccepted() {
            return isAccepted;
        }
        public void setAccepted() {
            isAccepted = true;
            User user = this.user;
            user.updateReput(EventType.ACCEPT_ANSWER.getValue());
        }
        
        public String getId() {
            return this.id;
        }

}
