package com.app.api.module;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.app.api.MainConfiguration;
import com.app.api.dao.QuizDao;
import com.app.api.dao.ScoreDao;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

public class DaoModule implements Module {

    DBIFactory factory = new DBIFactory();
    DBI jdbi = null;

    @Override
    public void configure(Binder binder) {
    }

    @Provides
    @Singleton
    public QuizDao provideQuizDao(MainConfiguration configuration, Environment environment) throws Exception{

        this.jdbi = this.factory.build(environment, configuration.getDataSourceFactory(), "mysql");
        final QuizDao authDao = this.jdbi.onDemand(QuizDao.class);
        return authDao;
    }

    @Provides
    @Singleton
    public ScoreDao provideScoreDao(MainConfiguration configuration, Environment environment) throws Exception{

        if(jdbi==null){
            this.jdbi = this.factory.build(environment, configuration.getDataSourceFactory(), "mysql");
        }
        final ScoreDao scoreDao = this.jdbi.onDemand(ScoreDao.class);
        return scoreDao;
    }

}
