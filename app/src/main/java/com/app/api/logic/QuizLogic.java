package com.app.api.logic;

import com.google.common.base.Throwables;
import com.google.inject.Inject;
import com.app.api.core.Quiz.QuizResponse;
import com.app.api.dao.QuizDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class QuizLogic {

    private QuizDao quizDao;
    private static Logger logger = LogManager.getLogger(QuizLogic.class);

    @Inject
    public QuizLogic(QuizDao quizDao) {
        this.quizDao = quizDao;
    }


    public List<QuizResponse> getAuth() throws Exception{
        try {

            List<QuizResponse> questions = quizDao.getQuestions();

            return questions;

        } catch (Exception e){
            this.logger.error(Throwables.getStackTraceAsString (e));
            return null;
        }
    }

    public Boolean isCorrect(
            String questionId,
            String response
    ) throws Exception{
        try {

            return quizDao.isCorrect(
                    questionId,
                    response
            );

        } catch (Exception e){
            this.logger.error(Throwables.getStackTraceAsString (e));
            return null;
        }
    }

}
