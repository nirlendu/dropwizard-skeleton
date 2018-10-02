package com.app.api.dao;

import com.app.api.core.Quiz.QuizResponse;
import com.app.api.mapper.QuizMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import ru.vyarus.guicey.jdbi.installer.repository.JdbiRepository;
import ru.vyarus.guicey.jdbi.tx.InTransaction;

import java.util.List;

@JdbiRepository
@InTransaction
public interface QuizDao {

    @SqlQuery("SELECT * FROM `Questions`")
    @Mapper(QuizMapper.class)
    List<QuizResponse> getQuestions( );

    @SqlQuery("SELECT COUNT(*) FROM `Questions` WHERE QuestionId = :questionId AND Response = :response")
    @Mapper(QuizMapper.class)
    Boolean isCorrect(
            @Bind("questionId") String questionId,
            @Bind("response") String response
    );

}
