package com.app.api.mapper;

import com.app.api.core.Scores.ScoresResponse;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ScoreMapper implements ResultSetMapper<ScoresResponse>{

    public ScoresResponse map(int i, ResultSet resultSet, StatementContext statementContext)throws SQLException {
        return new ScoresResponse(
                resultSet.getString("UserId"),
                resultSet.getString("Score")
        );
    }
}
