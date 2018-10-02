package com.app.api.mapper;

import com.app.api.core.Quiz.QuizResponse;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuizMapper implements ResultSetMapper<QuizResponse>{

    public QuizResponse map(int i, ResultSet resultSet, StatementContext statementContext)throws SQLException {
        return new QuizResponse(
                resultSet.getString("QuestionId"),
                resultSet.getString("Question"),
                resultSet.getString("OptionOne"),
                resultSet.getString("OptionTwo"),
                resultSet.getString("OptionThree"),
                resultSet.getString("OptionFour"),
                resultSet.getString("CorrectOption")
        );
    }
}


