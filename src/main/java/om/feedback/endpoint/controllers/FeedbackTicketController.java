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

        // 2. GET Endpoint (View Team)


// 3. PUT Endpoint (Edit Team)

        // 4. DELETE Endpoint (Your Part)

}
