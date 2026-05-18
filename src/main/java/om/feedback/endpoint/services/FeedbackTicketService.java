package om.feedback.endpoint.services;

import om.feedback.endpoint.models.Feedback;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class  {

        // Shared In-Memory List
        private final List<Feedback> feedbackList = new ArrayList<>();


        // 1. CREATE
        public Feedback createFeedback(Feedback feedback) {

                // Generate unique ID
                String generatedId = UUID.randomUUID().toString();

                // Set generated ID into feedback object
                feedback.setId(generatedId);

                // Store feedback in memory
                feedbackList.add(feedback);

                // Return created feedback
                return feedback;
        }


        // 2. VIEW ALL
        public List<Feedback> getAllFeedbacks() {
                return feedbackList;
        }


        // 3. EDIT (Add method here)


        // 4. DELETE (Your Part)
        public boolean deleteFeedback(String id) {

                return feedbackList.removeIf(f -> f.getId().equals(id));
        }
}