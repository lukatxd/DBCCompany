CREATE TABLE poll(
pollId varchar(255) not null,
title varchar(255),
durationInMinutes int not null,
creationDate timestamp not null,
PRIMARY KEY (pollId)
);

CREATE TABLE vote(
voteId varchar(255) not null,
userDocument varchar(20) not null,
choice int not null,
pollId varchar(255) not null,
voteTime timestamp not null,
PRIMARY KEY (voteId),
FOREIGN KEY (pollId) REFERENCES poll(pollId)
)