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

// 2. VIEW ALL - Returns all feedback entries from in-memory list
 public List<Feedback> getAllFeedbacks() { return feedbackList; }

// 3. EDIT (Add method here)

        // 4. DELETE (Your Part)
        public boolean deleteFeedback(String id) {
return feedbackList.removeIf(f -> f.getId().equals(id));
}
}
