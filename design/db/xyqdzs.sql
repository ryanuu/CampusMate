/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2016/2/24 17:25:48                           */
/*==============================================================*/


drop table if exists LAB_TERM;

drop table if exists LAB_TIME;

drop table if exists lab_bluetooth_dev;

drop table if exists lab_check_work;

drop table if exists lab_class;

drop table if exists lab_college;

drop table if exists lab_course_list;

drop table if exists lab_curriculum_name;

drop table if exists lab_department;

drop table if exists lab_exam;

drop table if exists lab_modify_course;

drop table if exists lab_motion_trail;

drop table if exists lab_notice;

drop table if exists lab_position;

drop table if exists lab_student;

drop table if exists lab_student_phone;

drop table if exists lab_subject;

drop table if exists lab_teacher;

/*==============================================================*/
/* Table: LAB_TERM                                              */
/*==============================================================*/
create table LAB_TERM
(
   term_id              bigint not null auto_increment comment 'ѧ��ID',
   term_name            char(30),
   start_date           date comment '��ʼʱ��',
   end_date             date comment '����ʱ��',
   college_id           bigint,
   create_date          date comment '����ʱ��',
   edite_date           date comment '�޸�ʱ��',
   del                  int comment 'ɾ����ʶ',
   primary key (term_id)
);

alter table LAB_TERM comment 'ѧ�ڱ�';

/*==============================================================*/
/* Table: LAB_TIME                                              */
/*==============================================================*/
create table LAB_TIME
(
   id                   bigint not null auto_increment comment 'id',
   section              int comment '����',
   term_id              bigint comment 'ѧ��',
   start_date           time comment '��ʼʱ��',
   end_date             time comment '����ʱ��',
   college_id           bigint,
   create_date          date comment '����ʱ��',
   edit_date            date comment '�޸�ʱ��',
   del                  int comment 'ɾ����ʶ',
   primary key (id)
);

alter table LAB_TIME comment '�μ��';

/*==============================================================*/
/* Table: lab_bluetooth_dev                                     */
/*==============================================================*/
create table lab_bluetooth_dev
(
   dev_id               bigint not null auto_increment comment 'ID',
   dev_number           bigint comment '�������',
   manufactor           char(200) comment '����',
   status               int comment '״̬',
   position_id          bigint,
   uuid                 char(35),
   major                bigint,
   minor                bigint,
   dev_type             char(50),
   create_date          date comment '����ʱ��',
   edit_date            date comment '�޸�ʱ��',
   del                  int comment 'ɾ����ʶ',
   dev_sn               char,
   dev_mac              char(20),
   measuredPower        int(11),
   name                 char(30),
   primary key (dev_id)
);

alter table lab_bluetooth_dev comment '�����豸';

/*==============================================================*/
/* Table: lab_check_work                                        */
/*==============================================================*/
create table lab_check_work
(
   check_id             bigint not null auto_increment comment '����id',
   class_id             bigint comment '�༶ID',
   curriculum_id        bigint comment '�γ�id',
   curriculum_name      char(100),
   status               char comment '����״̬',
   student_id           bigint comment 'ѧ��id',
   weekNo               int,
   weekday              int,
   section              int comment '����',
   start_date           date comment '�Ͽ�ǩ��ʱ��',
   end_date             date comment '�¿�ǩ��ʱ��',
   term_id              bigint comment 'ѧ��',
   create_date          date comment '����ʱ��',
   edit_date            date comment '�޸�ʱ��',
   del                  int comment 'ɾ����ʶ',
   primary key (check_id)
);

alter table lab_check_work comment '���ڼ�¼';

/*==============================================================*/
/* Table: lab_class                                             */
/*==============================================================*/
create table lab_class
(
   class_id             bigint not null auto_increment comment '�༶id',
   class_name           char(50) not null comment '�༶����',
   college_id           bigint not null,
   department_id        bigint not null comment 'ԺϵID',
   subject_id           bigint not null comment 'רҵ',
   headmaster           bigint comment '������',
   instructor           bigint comment '����Ա',
   grade                int not null comment '��',
   create_date          date comment '����ʱ��',
   edit_date            date comment '�޸�ʱ��',
   del                  int comment 'ɾ����ʶ',
   primary key (class_id)
);

alter table lab_class comment '�༶';

/*==============================================================*/
/* Table: lab_college                                           */
/*==============================================================*/
create table lab_college
(
   college_id           bigint not null auto_increment,
   college_name         char(30) not null,
   short_name           char(10),
   college_profile      varchar(500),
   create_date          date,
   edit_date            date,
   del                  int,
   primary key (college_id)
);

/*==============================================================*/
/* Table: lab_course_list                                       */
/*==============================================================*/
create table lab_course_list
(
   course_list_id       bigint not null auto_increment comment '�γ̱�ID',
   curriculum_id        bigint,
   weekday              int not null comment '�ܼ�',
   section              int not null comment '�������ڼ��ڣ�',
   class_id             bigint not null,
   term_id              bigint not null comment 'ѧ��',
   position_id          bigint,
   course_type          int not null,
   create_date          date comment '����ʱ��',
   edit_date            date comment '�޸�ʱ��',
   del                  int comment 'ɾ����ʶ',
   primary key (course_list_id)
);

alter table lab_course_list comment '�γ̱�';

/*==============================================================*/
/* Table: lab_curriculum_name                                   */
/*==============================================================*/
create table lab_curriculum_name
(
   curriculum_id        bigint not null auto_increment comment '�γ�id',
   curriculum_name      char(100) comment '�γ�����',
   teacher_id           bigint comment '�ο���ʦID',
   teacher_name         char(20),
   start_week           int comment '��ʼʱ�䣨�ܣ�',
   end_week             int comment '����ʱ�䣨�ܣ�',
   subject_id           bigint not null,
   term_id              bigint not null comment 'ѧ��id',
   level                int comment '��',
   course_type          int,
   create_date          date comment '����ʱ��',
   edit_date            date comment '�޸�ʱ��',
   del                  int comment 'ɾ����ʶ',
   primary key (curriculum_id)
);

alter table lab_curriculum_name comment '�γ�����';

/*==============================================================*/
/* Table: lab_department                                        */
/*==============================================================*/
create table lab_department
(
   department_id        bigint not null auto_increment,
   department_name      char(30) not null,
   short_name           char(10),
   department_profile   varchar(500),
   college_id           bigint not null,
   create_date          date,
   edit_date            date,
   del                  int,
   primary key (department_id)
);

/*==============================================================*/
/* Table: lab_exam                                              */
/*==============================================================*/
create table lab_exam
(
   exam_id              bigint not null auto_increment,
   curriculum_id        bigint,
   curriculum_name      char(100),
   start_time           time,
   end_time             time,
   week                 int,
   subject_id           bigint not null,
   level                int,
   term_id              bigint,
   teacher_id           bigint,
   create_date          date,
   edit_date            date,
   del                  int,
   primary key (exam_id)
);

/*==============================================================*/
/* Table: lab_modify_course                                     */
/*==============================================================*/
create table lab_modify_course
(
   modify_id            bigint not null auto_increment comment '�γ̱��޸�ID',
   curriculum_id        bigint,
   weekday              int not null comment '�ܼ�',
   section              int not null comment '����',
   term_id              bigint not null comment 'ѧ��',
   class_id             bigint not null,
   position_id          bigint,
   course_type          int not null,
   course_id            bigint comment '�γ̱�ID',
   create_date          date comment '����ʱ��',
   edit_date            date comment '�޸�ʱ��',
   del                  int comment 'ɾ����ʶ',
   primary key (modify_id)
);

alter table lab_modify_course comment '�γ��޸ı�';

/*==============================================================*/
/* Table: lab_motion_trail                                      */
/*==============================================================*/
create table lab_motion_trail
(
   trail_d              bigint not null auto_increment comment 'id',
   student_id           bigint comment 'ѧ��id',
   position_id          bigint comment 'λ��',
   residence_tim        bigint,
   start_time           date,
   leave_time           date,
   create_date          date comment '����ʱ��',
   primary key (trail_d)
);

alter table lab_motion_trail comment '�켣��';

/*==============================================================*/
/* Table: lab_notice                                            */
/*==============================================================*/
create table lab_notice
(
   notice_id            bigint not null auto_increment comment 'ID',
   content              varchar(1000) comment '����',
   title                char(100) comment '����',
   display_date         int comment 'չʾʱ��',
   teacher_id           bigint comment '������id',
   source               char,
   class_id             char comment '���հ༶',
   department_id        bigint,
   college_id           bigint,
   top                  int comment '�ö���ʶ',
   creat_date           date comment '����ʱ��',
   edit_date            date comment '�޸�ʱ��',
   del                  int comment 'ɾ����ʶ',
   primary key (notice_id)
);

alter table lab_notice comment '֪ͨ';

/*==============================================================*/
/* Table: lab_position                                          */
/*==============================================================*/
create table lab_position
(
   position_id          bigint not null auto_increment comment 'λ��ID',
   place                char(100) comment '����',
   number               char(20) comment '���',
   position_type        int comment 'λ������',
   create_date          date comment '����ʱ��',
   edit_date            date comment '�޸�ʱ��',
   del                  int comment 'ɾ��',
   primary key (position_id)
);

alter table lab_position comment 'λ��';

/*==============================================================*/
/* Table: lab_student                                           */
/*==============================================================*/
create table lab_student
(
   student_id           bigint not null auto_increment comment 'ѧ��ID',
   student_number       bigint not null comment 'ѧ��',
   student_name         char comment '����',
   nickname             char(50) comment '�ǳ�',
   sex                  bit comment '�Ա�',
   age                  int(3) comment '����',
   nation               char(20) comment '����',
   phone                bigint(11) comment '�ֻ�����',
   id_card              char(18) comment '���֤����',
   type                 bigint comment 'ְλ',
   email                char comment 'Email',
   class_id             bigint,
   head_image           char comment 'ͷ��',
   note                 varchar(500) comment '��ע',
   password             char comment '����',
   creat_date           date comment '����ʱ��',
   edit_date            date comment '�޸�ʱ��',
   del                  int comment 'ɾ����ʶ',
   useri_id             bigint,
   primary key (student_id)
);

alter table lab_student comment 'ѧ����Ϣ';

/*==============================================================*/
/* Table: lab_student_phone                                     */
/*==============================================================*/
create table lab_student_phone
(
   mac_id               bigint not null auto_increment comment 'id',
   student_id           bigint not null comment 'ѧ��id',
   mac                  char comment '�ֻ������ַ',
   creat_date           date comment '����ʱ��',
   edit_date            date comment '�޸�ʱ��',
   del                  int comment 'ɾ����ʶ',
   primary key (mac_id)
);

alter table lab_student_phone comment '�ֻ�';

/*==============================================================*/
/* Table: lab_subject                                           */
/*==============================================================*/
create table lab_subject
(
   subject_id           bigint not null auto_increment,
   subject_name         char(30) not null,
   short_name           char(10),
   subject_profile      varchar(500),
   college_id           bigint not null,
   department_id        bigint not null,
   create_date          date,
   edit_date            date,
   del                  int,
   primary key (subject_id)
);

/*==============================================================*/
/* Table: lab_teacher                                           */
/*==============================================================*/
create table lab_teacher
(
   teacher_id           bigint not null auto_increment comment '��ְ��ID',
   teacher_number       bigint not null comment '����',
   teacher_name         char(20) comment '����',
   nickname             char(50) comment '�ǳ�',
   sex                  bit comment '�Ա�',
   age                  bigint(3) comment '����',
   nation               char(20) comment '����',
   phone                bigint(11) comment '�ֻ�����',
   id_card              bigint(18) comment '���֤����',
   email                char comment 'Email',
   professional         bigint,
   college_id           bigint,
   department_id        bigint comment 'ԺϵID',
   head_image           char comment 'ͷ��',
   role                 bigint comment '��ɫ',
   note                 varchar(500) comment '��ע',
   password             char comment '����',
   creat_date           date comment '����ʱ��',
   edit_date            date comment '�޸�ʱ��',
   del                  int comment 'ɾ����ʶ',
   user_id              bigint,
   primary key (teacher_id)
);

alter table lab_teacher comment '��ְ����Ϣ';

alter table lab_bluetooth_dev add constraint FK_Reference_11 foreign key (position_id)
      references lab_position (position_id) on delete restrict on update restrict;

alter table lab_class add constraint FK_Reference_12 foreign key (subject_id)
      references lab_subject (subject_id) on delete restrict on update restrict;

alter table lab_course_list add constraint FK_Reference_4 foreign key (curriculum_id)
      references lab_curriculum_name (curriculum_id) on delete restrict on update restrict;

alter table lab_course_list add constraint FK_Reference_5 foreign key (position_id)
      references lab_position (position_id) on delete restrict on update restrict;

alter table lab_course_list add constraint FK_Reference_6 foreign key (class_id)
      references lab_class (class_id) on delete restrict on update restrict;

alter table lab_curriculum_name add constraint FK_Reference_16 foreign key (term_id)
      references LAB_TERM (term_id) on delete restrict on update restrict;

alter table lab_department add constraint FK_Reference_2 foreign key (college_id)
      references lab_college (college_id) on delete restrict on update restrict;

alter table lab_modify_course add constraint FK_Reference_10 foreign key (class_id)
      references lab_class (class_id) on delete restrict on update restrict;

alter table lab_modify_course add constraint FK_Reference_7 foreign key (curriculum_id)
      references lab_curriculum_name (curriculum_id) on delete restrict on update restrict;

alter table lab_modify_course add constraint FK_Reference_9 foreign key (position_id)
      references lab_position (position_id) on delete restrict on update restrict;

alter table lab_subject add constraint FK_Reference_1 foreign key (department_id)
      references lab_department (department_id) on delete restrict on update restrict;

