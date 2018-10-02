package com.app.api.resources;

import com.google.inject.Inject;
import com.app.api.core.Scores.ScoresResponse;
import com.app.api.logic.ScoreLogic;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * nirlendu
 */
public class ScoreResource {

    private ScoreLogic scoreLogic;

    @Inject
    public ScoreResource(ScoreLogic scoreLogic) {
        this.scoreLogic = scoreLogic;
    }

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ScoresResponse> getScores() throws Exception {

        List<ScoresResponse> scores = scoreLogic.getScore();
        return scores;
    }

    @GET
    @Path("/update/{userId}/{score}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getQuestions(
            @PathParam("userId") String userId,
            @PathParam("score") String score
    ) throws Exception {
        String response =  scoreLogic.updateScore(
                userId,
                score
        );
        return Response.ok(response, MediaType.APPLICATION_JSON).build();
    }

}
