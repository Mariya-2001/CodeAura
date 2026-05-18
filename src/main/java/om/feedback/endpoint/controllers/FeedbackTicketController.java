package om.feedback.endpoint.controllers;

import om.feedback.endpoint.models.Feedback;
import om.feedback.endpoint.services.FeedbackTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/feedbacks")
public class FeedbackTicketController {

    @Autowired
    public FeedbackTicketService feedbackTicketService;


    // 1. POST Endpoint (Create Team)
    @PostMapping
    public ResponseEntity<Feedback> createFeedback(@RequestBody Feedback feedback) {

        // Create new feedback
        Feedback createdFeedback = feedbackTicketService.createFeedback(feedback);

        // Return response with status 201
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdFeedback);
    }


    // 2. GET Endpoint (View Team)
    @GetMapping
    public ResponseEntity<List<Feedback>> getAll() {

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(feedbackTicketService.getAllFeedbacks());
    }


    // 3. PUT Endpoint (Edit Team)


    // 4. DELETE Endpoint (Your Part)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeedback(@PathVariable String id) {

        boolean isDeleted = feedbackTicketService.deleteFeedback(id);

        if (!isDeleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
