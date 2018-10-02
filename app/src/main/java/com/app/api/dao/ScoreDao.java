package com.app.api.dao;

import com.app.api.core.Scores.ScoresResponse;
import com.app.api.mapper.QuizMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import ru.vyarus.guicey.jdbi.installer.repository.JdbiRepository;
import ru.vyarus.guicey.jdbi.tx.InTransaction;

import java.util.List;

@JdbiRepository
@InTransaction
public interface ScoreDao {

    @SqlQuery("SELECT * FROM `Score`")
    @Mapper(QuizMapper.class)
    List<ScoresResponse> getScore();

    @SqlUpdate("INSERT INTO `Score` (`Score`, `UserId`) VALUES ( :score, :userId)")
    void insertScore(
            @Bind("userId") String userId,
            @Bind("score") String score
    );


}
