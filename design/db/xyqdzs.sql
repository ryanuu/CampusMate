/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2016/1/28 11:37:44                           */
/*==============================================================*/


drop table if exists lab_bluetooth;

drop table if exists lab_check_work;

drop table if exists lab_class;

drop table if exists lab_course_list;

drop table if exists lab_curriculum_name;

drop table if exists lab_notice;

drop table if exists lab_position;

drop table if exists lab_status_course;

drop table if exists lab_student;

drop table if exists lab_student_phone;

drop table if exists lab_teacher;

drop table if exists lab_term;

drop table if exists lab_time;

drop table if exists lab_trajectory;

/*==============================================================*/
/* Table: lab_bluetooth                                         */
/*==============================================================*/
create table lab_bluetooth
(
   bluetooth_id         int not null auto_increment comment 'ID',
   bluetooth_number     int comment '�������',
   manufactor           char(200) comment '����',
   status               int comment '״̬',
   position_id          int,
   create_date          date comment '����ʱ��',
   edit_date            date comment '�޸�ʱ��',
   del                  int comment 'ɾ����ʶ',
   primary key (bluetooth_id)
);

alter table lab_bluetooth comment '�����豸';

/*==============================================================*/
/* Table: lab_check_work                                        */
/*==============================================================*/
create table lab_check_work
(
   check_id             int not null auto_increment comment '����id',
   class_id             int comment '�༶ID',
   curriculum_id        int comment '�γ�id',
   status               int comment '����״̬',
   student_id           int comment 'ѧ��id',
   section              int comment '����',
   start_date           date comment '�Ͽ�ǩ��ʱ��',
   end_date             date comment '�¿�ǩ��ʱ��',
   term                 int comment 'ѧ��',
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
   class_id             int not null auto_increment comment '�༶id',
   calss_name           char(50) comment '�༶����',
   college_id           int,
   department_id        int comment 'ԺϵID',
   major                int comment 'רҵ',
   headmaster           int comment '������',
   instructor           int comment '����Ա',
   level_id             int comment '��',
   create_date          date comment '����ʱ��',
   edit_date            date comment '�޸�ʱ��',
   del                  int comment 'ɾ����ʶ',
   primary key (class_id)
);

alter table lab_class comment '�༶';

/*==============================================================*/
/* Table: lab_course_list                                       */
/*==============================================================*/
create table lab_course_list
(
   course_id            int not null auto_increment comment '�γ̱�ID',
   curriculum_id        int,
   week                 int comment '�ܼ�',
   section              int comment '�������ڼ��ڣ�',
   class_id             int,
   term                 int comment 'ѧ��',
   position_id          int,
   course_type          int,
   create_date          date comment '����ʱ��',
   edit_date            date comment '�޸�ʱ��',
   del                  int comment 'ɾ����ʶ',
   primary key (course_id)
);

alter table lab_course_list comment '�γ̱�';

/*==============================================================*/
/* Table: lab_curriculum_name                                   */
/*==============================================================*/
create table lab_curriculum_name
(
   curriculum_id        int not null auto_increment comment '�γ�id',
   curriculum_name      char(100) comment '�γ�����',
   teacher_id           int comment '�ο���ʦID',
   start_week           int comment '��ʼʱ�䣨�ܣ�',
   end_week             int comment '����ʱ�䣨�ܣ�',
   college_id           int,
   department_id        int comment 'ԺϵID',
   tremI_id             int comment 'ѧ��id',
   level                int comment '��',
   create_date          date comment '����ʱ��',
   edit_date            date comment '�޸�ʱ��',
   del                  int comment 'ɾ����ʶ',
   primary key (curriculum_id)
);

alter table lab_curriculum_name comment '�γ�����';

/*==============================================================*/
/* Table: lab_notice                                            */
/*==============================================================*/
create table lab_notice
(
   notice_id            int not null auto_increment comment 'ID',
   content              char(1000) comment '����',
   title                char(100) comment '����',
   creat_date           date comment '����ʱ��',
   edit_date            date comment '�޸�ʱ��',
   display_date         int comment 'չʾʱ��',
   del                  int comment 'ɾ����ʶ',
   teacher_id           int comment '������id',
   class_id             char comment '���հ༶',
   top                  int comment '�ö���ʶ',
   primary key (notice_id)
);

alter table lab_notice comment '֪ͨ';

/*==============================================================*/
/* Table: lab_position                                          */
/*==============================================================*/
create table lab_position
(
   position_id          int not null auto_increment comment 'λ��ID',
   academic_field       char(100) comment '����',
   number               char(20) comment '���',
   position_type        int comment 'λ������',
   create_date          date comment '����ʱ��',
   edit_date            date comment '�޸�ʱ��',
   del                  int comment 'ɾ��',
   primary key (position_id)
);

alter table lab_position comment 'λ��';

/*==============================================================*/
/* Table: lab_status_course                                     */
/*==============================================================*/
create table lab_status_course
(
   status_id            int not null auto_increment comment '�γ̱��޸�ID',
   curriculum_id        int,
   week                 int comment '�ܼ�',
   section              int comment '����',
   term                 int comment 'ѧ��',
   class_id             int,
   position_id          int,
   course_type          int,
   course_id            int comment '�γ̱�ID',
   create_date          date comment '����ʱ��',
   edit_date            date comment '�޸�ʱ��',
   del                  int comment 'ɾ����ʶ',
   primary key (status_id)
);

alter table lab_status_course comment '�γ��޸ı�';

/*==============================================================*/
/* Table: lab_student                                           */
/*==============================================================*/
create table lab_student
(
   student_id           int not null auto_increment comment 'ѧ��ID',
   student_number       int not null comment 'ѧ��',
   student_name         char comment '����',
   nickname             char(50) comment '�ǳ�',
   sex                  bit comment '�Ա�',
   age                  int(3) comment '����',
   nation               char(20) comment '����',
   phone                int(11) comment '�ֻ�����',
   id_card              char(18) comment '���֤����',
   type                 int comment 'ְλ',
   email                char comment 'Email',
   major                int comment 'רҵ',
   class_id             int,
   department_id        int comment 'ѧϵID',
   college_id           int comment 'ѧԺid',
   head_image           char comment 'ͷ��',
   note                 char(500) comment '��ע',
   password             char comment '����',
   creat_date           date comment '����ʱ��',
   edit_date            date comment '�޸�ʱ��',
   del                  int comment 'ɾ����ʶ',
   primary key (student_id)
);

alter table lab_student comment 'ѧ����Ϣ';

/*==============================================================*/
/* Table: lab_student_phone                                     */
/*==============================================================*/
create table lab_student_phone
(
   mac_id               int not null auto_increment comment 'id',
   student_id           int not null comment 'ѧ��id',
   mac                  char comment '�ֻ������ַ',
   creat_date           date comment '����ʱ��',
   edit_date            date comment '�޸�ʱ��',
   del                  int comment 'ɾ����ʶ',
   primary key (mac_id)
);

alter table lab_student_phone comment '�ֻ�';

/*==============================================================*/
/* Table: lab_teacher                                           */
/*==============================================================*/
create table lab_teacher
(
   teacher_id           int not null auto_increment comment '��ְ��ID',
   teacher_number       int not null comment '����',
   teacher_name         char(20) comment '����',
   nickname             char(50) comment '�ǳ�',
   sex                  bit comment '�Ա�',
   age                  int(3) comment '����',
   nation               char(20) comment '����',
   phone                int(11) comment '�ֻ�����',
   id_card              int(18) comment '���֤����',
   email                char comment 'Email',
   professional         int,
   college_id           int,
   department_id        char comment 'ԺϵID',
   head_image           char comment 'ͷ��',
   role                 int comment '��ɫ',
   note                 char(500) comment '��ע',
   password             char comment '����',
   creat_date           date comment '����ʱ��',
   edit_date            date comment '�޸�ʱ��',
   del                  int comment 'ɾ����ʶ',
   primary key (teacher_id)
);

alter table lab_teacher comment '��ְ����Ϣ';

/*==============================================================*/
/* Table: lab_term                                              */
/*==============================================================*/
create table lab_term
(
   tremI_id             int not null auto_increment comment 'ѧ��ID',
   start_date           date comment '��ʼʱ��',
   end_date             date comment '����ʱ��',
   create_date          date comment '����ʱ��',
   edite_date           date comment '�޸�ʱ��',
   del                  int comment 'ɾ����ʶ',
   primary key (tremI_id)
);

alter table lab_term comment 'ѧ�ڱ�';

/*==============================================================*/
/* Table: lab_time                                              */
/*==============================================================*/
create table lab_time
(
   id                   int not null auto_increment comment 'id',
   section              int comment '����',
   term                 int comment 'ѧ��',
   start_date           date comment '��ʼʱ��',
   end_date             date comment '����ʱ��',
   create_date          date comment '����ʱ��',
   edit_date            date comment '�޸�ʱ��',
   del                  int comment 'ɾ����ʶ',
   primary key (id)
);

alter table lab_time comment 'ʱ���';

/*==============================================================*/
/* Table: lab_trajectory                                        */
/*==============================================================*/
create table lab_trajectory
(
   itrajectory_d        int not null auto_increment comment 'id',
   student_id           int comment 'ѧ��id',
   position_id          int comment 'λ��',
   create_date          date comment '����ʱ��',
   primary key (itrajectory_d)
);

alter table lab_trajectory comment '�켣��';

alter table lab_bluetooth add constraint FK_Reference_7 foreign key (position_id)
      references lab_position (position_id) on delete restrict on update restrict;

alter table lab_course_list add constraint FK_Reference_1 foreign key (curriculum_id)
      references lab_curriculum_name (curriculum_id) on delete restrict on update restrict;

alter table lab_course_list add constraint FK_Reference_2 foreign key (position_id)
      references lab_position (position_id) on delete restrict on update restrict;

alter table lab_course_list add constraint FK_Reference_3 foreign key (class_id)
      references lab_class (class_id) on delete restrict on update restrict;

alter table lab_status_course add constraint FK_Reference_4 foreign key (curriculum_id)
      references lab_curriculum_name (curriculum_id) on delete restrict on update restrict;

alter table lab_status_course add constraint FK_Reference_5 foreign key (position_id)
      references lab_position (position_id) on delete restrict on update restrict;

alter table lab_status_course add constraint FK_Reference_6 foreign key (class_id)
      references lab_class (class_id) on delete restrict on update restrict;

