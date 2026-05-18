package om.feedback.endpoint.services;

import om.feedback.endpoint.models.Feedback;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class FeedbackTicketService {
        // Shared In-Memory List
        private final List<Feedback> feedbackList = new ArrayList<>();

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

        // 2. VIEW ALL

        // 3. EDIT (Add method here)

        // 4. DELETE
        public boolean deleteFeedback(String id){
                return feedbackList.removeIf(feedback -> feedback.getId().equals(id));
        }

}