alter table poll drop column durationInMinutes;
alter table poll add column startDate timestamp not null;
alter table poll add column endDate timestamp not null;
alter table poll add column description varchar(255);

alter table vote alter column choice bit;