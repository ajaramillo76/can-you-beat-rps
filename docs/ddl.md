# SQL data definition language (DDL)

```SQLite
CREATE TABLE IF NOT EXISTS `User`
(
    `user_id`  INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `email_id` TEXT COLLATE NOCASE
);

CREATE UNIQUE INDEX IF NOT EXISTS `index_User_email_id` ON `User` (`email_id`);

CREATE TABLE IF NOT EXISTS `Game`
(
    `game_id`  INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `user_id`  INTEGER                           NOT NULL,
    `win`      INTEGER                           NOT NULL,
    `lose`     INTEGER                           NOT NULL,
    `draw`     INTEGER                           NOT NULL,
    `rock`     INTEGER                           NOT NULL,
    `paper`    INTEGER                           NOT NULL,
    `scissors` INTEGER                           NOT NULL,
    FOREIGN KEY (`user_id`) REFERENCES `User` (`user_id`) ON UPDATE NO ACTION ON DELETE CASCADE
);

CREATE INDEX IF NOT EXISTS `index_Game_user_id` ON `Game` (`user_id`);

CREATE INDEX IF NOT EXISTS `index_Game_win` ON `Game` (`win`);

CREATE INDEX IF NOT EXISTS `index_Game_lose` ON `Game` (`lose`);

CREATE INDEX IF NOT EXISTS `index_Game_draw` ON `Game` (`draw`);

CREATE INDEX IF NOT EXISTS `index_Game_rock` ON `Game` (`rock`);

CREATE INDEX IF NOT EXISTS `index_Game_paper` ON `Game` (`paper`);

CREATE INDEX IF NOT EXISTS `index_Game_scissors` ON `Game` (`scissors`);

CREATE TABLE IF NOT EXISTS `HistoricalData`
(
    `historicaldata_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `user_id`           INTEGER                           NOT NULL,
    `wins`              INTEGER                           NOT NULL,
    `losses`            INTEGER                           NOT NULL,
    `draw`              INTEGER                           NOT NULL,
    `rock`              INTEGER                           NOT NULL,
    `paper`             INTEGER                           NOT NULL,
    `scissors`          INTEGER                           NOT NULL,
    FOREIGN KEY (`user_id`) REFERENCES `User` (`user_id`) ON UPDATE NO ACTION ON DELETE CASCADE
);

CREATE INDEX IF NOT EXISTS `index_HistoricalData_user_id` ON `HistoricalData` (`user_id`);

CREATE INDEX IF NOT EXISTS `index_HistoricalData_wins` ON `HistoricalData` (`wins`);

CREATE INDEX IF NOT EXISTS `index_HistoricalData_losses` ON `HistoricalData` (`losses`);

CREATE INDEX IF NOT EXISTS `index_HistoricalData_draw` ON `HistoricalData` (`draw`);

CREATE INDEX IF NOT EXISTS `index_HistoricalData_rock` ON `HistoricalData` (`rock`);

CREATE INDEX IF NOT EXISTS `index_HistoricalData_paper` ON `HistoricalData` (`paper`);

CREATE INDEX IF NOT EXISTS `index_HistoricalData_scissors` ON `HistoricalData` (`scissors`);
``` 

[Download](ddl.sql)
