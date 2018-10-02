package com.app.api.resources;

import com.google.inject.Inject;
import com.app.api.core.Quiz.QuizResponse;
import com.app.api.logic.QuizLogic;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/v1/auth")
public class QuizResource {

    private QuizLogic quizLogic;

    @Inject
    public QuizResource(QuizLogic quizLogic) {
        this.quizLogic = quizLogic;
    }

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public List<QuizResponse> getQuestions() throws Exception {

        List<QuizResponse> questions = quizLogic.getAuth();
        return questions;
    }

    @GET
    @Path("/is-correct/{questionId}/{response}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getQuestions(
            @PathParam("questionId") String questionId,
            @PathParam("response") String response
    ) throws Exception {
        Boolean isCorrect =  quizLogic.isCorrect(questionId,response);
        return Response.ok(isCorrect, MediaType.APPLICATION_JSON).build();
    }


}
