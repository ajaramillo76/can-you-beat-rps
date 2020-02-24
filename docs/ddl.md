# SQL data definition language (DDL)

'''sqlite
CREATE TABLE IF NOT EXISTS 'User'
(
    'user_id'   INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    'email'     TEXT                              NOT NULL, 
);

CREATE UNIQUE INDEX IF NOT EXISTS 'index_User_email' ON 'User' ('email');

CREATE TABLE IF NOT EXISTS 'Game'
(
    'game_id' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    'user_id' INTEGER                           NOT NULL,
    'win'     INTEGER,
    'lose'    INTEGER,
    'draw'    INTEGER,
    'rock'    INTEGER                           NOT NULL,
    'paper'   INTEGER                           NOT NULL,
    'scissors'INTEGER                           NOT NULL,
    FOREIGN KEY ('user_id') REFERENCES 'User' ('user_id') ON UPDATE NO ACTION ON DELETE CASCADE 
);

CREATE INDEX IF NOT EXISTS 'index_Game_user_id' ON 'Game' ('user_id');

CREATE TABLE IF NOT EXISTS 'HistoricalData'
(
    'historical_data_id'    INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    'user_id'               INTEGER                           NOT NULL,
    'wins'                  INTEGER,
    'loseses'               INTEGER,
    'draws'                 INTEGER,
    'rock'                  INTEGER                           NOT NULL,
    'paper'                 INTEGER                           NOT NULL,
    'scissors'              INTEGER                           NOT NULL,
    FOREIGN KEY ('user_id') REFERENCES 'HistoricalData' ('user_id') ON UPDATE NO ACTION ON DELETE CASCADE 
);

CREATE INDEX IF NOT EXISTS 'index_HistoricalData_user_id' ON 'HistoricalData' ('user_id');
'''

[Download](ddl.sql)