package com.app.api.logic;

import com.google.common.base.Throwables;
import com.google.inject.Inject;
import com.app.api.core.Scores.ScoresResponse;
import com.app.api.dao.ScoreDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ScoreLogic {

    private ScoreDao scoreDao;
    private static Logger logger = LogManager.getLogger(ScoreLogic.class);

    @Inject
    public ScoreLogic(ScoreDao scoreDao) {
        this.scoreDao = scoreDao;
    }

    public List<ScoresResponse> getScore() throws Exception{
        try {

            return scoreDao.getScore();

        } catch (Exception e){
            this.logger.error(Throwables.getStackTraceAsString (e));
            return null;
        }
    }

    public String updateScore(
            String userId,
            String score
    ) throws Exception{
        try {
            scoreDao.insertScore(
                    userId,
                    score
            );

            return userId;

        } catch (Exception e){
            this.logger.error(Throwables.getStackTraceAsString (e));
            return null;
        }
    }

}
