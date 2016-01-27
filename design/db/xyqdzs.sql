/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2016/1/27 15:38:48                           */
/*==============================================================*/


drop table if exists lab_bluetooth;

drop table if exists lab_check_work;

drop table if exists lab_class;

drop table if exists lab_classroom;

drop table if exists lab_course_list;

drop table if exists lab_curriculum_name;

drop table if exists lab_notice;

drop table if exists lab_status_course;

drop table if exists lab_student;

drop table if exists lab_student_phone;

drop table if exists lab_teacher;

drop table if exists lab_term;

drop table if exists lab_time;

/*==============================================================*/
/* Table: lab_bluetooth                                         */
/*==============================================================*/
create table lab_bluetooth
(
   bluetooth_id         int not null auto_increment,
   bluetooth_number     int,
   manufactor           char(200),
   status               int,
   classroom_id         int,
   create_date          date,
   edit_date            date,
   del                  int,
   primary key (bluetooth_id)
);

/*==============================================================*/
/* Table: lab_check_work                                        */
/*==============================================================*/
create table lab_check_work
(
   check_id             int not null auto_increment,
   class_id             int,
   curriculum_id        int,
   status               int,
   student_id           int,
   section              int,
   start_date           date,
   end_date             date,
   term                 int,
   create_date          date,
   edit_date            date,
   del                  int,
   primary key (check_id)
);

/*==============================================================*/
/* Table: lab_class                                             */
/*==============================================================*/
create table lab_class
(
   class_id             int not null auto_increment,
   calss_name           char(50),
   student_numbers      int,
   department_id        int,
   major                int,
   headmaster           int,
   instructor           int,
   create_date          date,
   edit_date            date,
   del                  int,
   primary key (class_id)
);

/*==============================================================*/
/* Table: lab_classroom                                         */
/*==============================================================*/
create table lab_classroom
(
   classroom_id         int not null auto_increment,
   academic_building    char(100),
   number               char(20),
   classroom_type       int,
   create_date          date,
   edit_date            date,
   del                  int,
   primary key (classroom_id)
);

/*==============================================================*/
/* Table: lab_course_list                                       */
/*==============================================================*/
create table lab_course_list
(
   course_id            int not null auto_increment,
   curriculum_id        int,
   week                 int,
   section              int,
   class_id             int,
   term                 int,
   classroom_id         int,
   tremI_id             int,
   create_date          date,
   edit_date            date,
   del                  int,
   primary key (course_id)
);

/*==============================================================*/
/* Table: lab_curriculum_name                                   */
/*==============================================================*/
create table lab_curriculum_name
(
   curriculum_id        int not null auto_increment,
   curriculum_name      char(100),
   teacher_id           int,
   start_week           int,
   end_week             int,
   department_id        int,
   create_date          date,
   edit_date            date,
   del                  int,
   primary key (curriculum_id)
);

/*==============================================================*/
/* Table: lab_notice                                            */
/*==============================================================*/
create table lab_notice
(
   notice_id            int not null auto_increment,
   content              char(1000),
   title                char(100),
   creat_date           date,
   edit_date            date,
   display_date         int,
   del                  int,
   teacher_id           int,
   class_id             char,
   top                  int,
   primary key (notice_id)
);

/*==============================================================*/
/* Table: lab_status_course                                     */
/*==============================================================*/
create table lab_status_course
(
   status_id            int not null auto_increment,
   curriculum_id        int,
   week                 int,
   section              int,
   class_id             int,
   term                 int,
   classroom_id         int,
   tremI_id             int,
   course_id            int,
   create_date          date,
   edit_date            date,
   del                  int,
   primary key (status_id)
);

/*==============================================================*/
/* Table: lab_student                                           */
/*==============================================================*/
create table lab_student
(
   student_id           int not null auto_increment,
   student_number       int not null,
   student_name         char,
   sex                  char(2),
   age                  int(3),
   nation               char(20),
   phone                int(11),
   id_card              char(18),
   type                 int,
   email                char,
   department_id        int,
   class_id             int,
   head_image           char,
   note                 char(500),
   creat_date           date,
   edit_date            date,
   del                  int,
   primary key (student_id)
);

/*==============================================================*/
/* Table: lab_student_phone                                     */
/*==============================================================*/
create table lab_student_phone
(
   mac_id               int not null auto_increment,
   student_id           int not null,
   student_number       int,
   mac                  char,
   creat_date           date,
   edit_date            date,
   del                  int,
   primary key (mac_id)
);

/*==============================================================*/
/* Table: lab_teacher                                           */
/*==============================================================*/
create table lab_teacher
(
   teacher_id           int not null auto_increment,
   curriculum_id        int,
   teacher_number       int not null,
   teacher_name         char(20),
   sex                  char(2),
   age                  int(3),
   nation               char(20),
   phone                int(11),
   id_card              int(18),
   email                char,
   department_id        char,
   class_id             char,
   course_id            char,
   head_image           char,
   type                 int,
   note                 char(500),
   creat_date           date,
   edit_date            date,
   del                  int,
   primary key (teacher_id)
);

/*==============================================================*/
/* Table: lab_term                                              */
/*==============================================================*/
create table lab_term
(
   tremI_id             int not null auto_increment,
   start_date           date,
   end_date             date,
   create_date          date,
   edite_date           date,
   del                  int,
   primary key (tremI_id)
);

/*==============================================================*/
/* Table: lab_time                                              */
/*==============================================================*/
create table lab_time
(
   id                   int not null auto_increment,
   section              int,
   term                 int,
   start_date           date,
   end_date             date,
   create_date          date,
   edit_date            date,
   del                  int,
   primary key (id)
);

alter table lab_bluetooth add constraint FK_Reference_9 foreign key (classroom_id)
      references lab_classroom (classroom_id) on delete restrict on update restrict;

alter table lab_course_list add constraint FK_Reference_1 foreign key (classroom_id)
      references lab_classroom (classroom_id) on delete restrict on update restrict;

alter table lab_course_list add constraint FK_Reference_2 foreign key (curriculum_id)
      references lab_curriculum_name (curriculum_id) on delete restrict on update restrict;

alter table lab_course_list add constraint FK_Reference_3 foreign key (class_id)
      references lab_class (class_id) on delete restrict on update restrict;

alter table lab_course_list add constraint FK_Reference_7 foreign key (tremI_id)
      references lab_term (tremI_id) on delete restrict on update restrict;

alter table lab_status_course add constraint FK_Reference_4 foreign key (classroom_id)
      references lab_classroom (classroom_id) on delete restrict on update restrict;

alter table lab_status_course add constraint FK_Reference_5 foreign key (curriculum_id)
      references lab_curriculum_name (curriculum_id) on delete restrict on update restrict;

alter table lab_status_course add constraint FK_Reference_6 foreign key (class_id)
      references lab_class (class_id) on delete restrict on update restrict;

alter table lab_status_course add constraint FK_Reference_8 foreign key (tremI_id)
      references lab_term (tremI_id) on delete restrict on update restrict;

alter table lab_teacher add constraint FK_Reference_10 foreign key (curriculum_id)
      references lab_curriculum_name (curriculum_id) on delete restrict on update restrict;

