package om.feedback.endpoint.services;

import om.feedback.endpoint.models.Feedback;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID; // Used to generate unique ID

@Service
public class FeedbackTicketService {

        // Shared In-Memory List (acts like a fake database)
        private final List<Feedback> feedbackList = new ArrayList<>();

        // 1. CREATE (Add new feedback)
        public Feedback createFeedback(Feedback feedback) {

                // Generate unique ID for each feedback
                String generatedId = UUID.randomUUID().toString();

                // Set the ID into the object
                feedback.setId(generatedId);

                // Store feedback in memory list
                feedbackList.add(feedback);

                // Return created object
                return feedback;
        }

        // 2. VIEW ALL
        public List<Feedback> getAllFeedbacks() {
                return feedbackList;
        }

        // 3. EDIT (Add later if needed)

        // 4. DELETE
        public boolean deleteFeedback(String id) {
                return feedbackList.removeIf(f -> f.getId().equals(id));
        }
}