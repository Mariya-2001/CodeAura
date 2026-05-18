package om.feedback.endpoint.services;
import java.util.UUID;
import om.feedback.endpoint.models.Feedback;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class FeedbackTicketService {

// Shared In-Memory List
//testing :
 private final List<Feedback> feedbackList = new ArrayList<>();
 // Initialize in-memory list with sample feedback data for testing:
 public FeedbackTicketService() {
  feedbackList.add(new Feedback(UUID.randomUUID().toString(), "The espresso tastes too bitter."));
  feedbackList.add(new Feedback(UUID.randomUUID().toString(), "Great latte art, loved it!"));
        }



        // 1. CREATE (Add method here)
        public Feedback createFeedback(Feedback feedback) {

                // Generate unique ID for the feedback
                String id = java.util.UUID.randomUUID().toString();

                // Set the generated ID into the object
                feedback.setId(id);

                // Store feedback in memory list
                feedbackList.add(feedback);

                // Return the created feedback
                return feedback;
        }


    // 2. VIEW ALL - Returns all feedback entries from in-memory list
        public List<Feedback> getAllFeedbacks() { return feedbackList; }


    // 3. EDIT (Add method here)

        // 4. DELETE
        public boolean deleteFeedback(String id){
                return feedbackList.removeIf(feedback -> feedback.getId().equals(id));
        }

}
