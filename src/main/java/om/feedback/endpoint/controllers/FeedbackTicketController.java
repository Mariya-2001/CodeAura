package om.feedback.endpoint.controllers;

import om.feedback.endpoint.models.Feedback;
import om.feedback.endpoint.services.FeedbackTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/feedbacks")
public class FeedbackTicketController {

    @Autowired
    public FeedbackTicketService feedbackTicketService;
    private static final AtomicLong counter = new AtomicLong();
    private final long id = counter.incrementAndGet();


    // 1. POST Endpoint (Create Feedback)
    @PostMapping
    public ResponseEntity<Feedback> createFeedback(@RequestBody Feedback feedback) {



        // Call service to create feedback
        Feedback created = feedbackTicketService.createFeedback(feedback);


        // Return CREATED status (201)
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    // 2. GET Endpoint (View Team)
//  Retrieves all feedback entries and returns them as JSON
    @GetMapping
    public ResponseEntity<List<Feedback>> getAll() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(feedbackTicketService.getAllFeedbacks());
    }
    // 3. PUT Endpoint (Edit Team)

    //put request
    @PutMapping("/{id}")
    public ResponseEntity<?> updateFeedback(

            @PathVariable String id,
            @RequestBody Feedback updatedFeedback
    ) {
        Feedback result = feedbackTicketService.updatedFeedback(
                String.valueOf(id), updatedFeedback
        );

        //invalid ID
        if (result == null) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Feedback not found");
        }

        //Sucess response
        return ResponseEntity.ok(result);

    }

    // 4. DELETE Endpoint
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeedback(@PathVariable String id) {

        boolean isDeleted = feedbackTicketService.deleteFeedback(id);

        if (!isDeleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }

}