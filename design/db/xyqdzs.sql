/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2016/1/28 11:37:44                           */
/*==============================================================*/


drop table if exists lab_bluetooth_dev;

drop table if exists lab_check_work;

drop table if exists lab_college;

drop table if exists lab_department;

drop table if exists lab_class;

drop table if exists lab_course_list;

drop table if exists lab_curriculum;

drop table if exists lab_notice;

drop table if exists lab_position;

drop table if exists lab_status_course;

drop table if exists lab_student;

drop table if exists lab_student_phone;

drop table if exists lab_teacher;

drop table if exists lab_term;

drop table if exists lab_lessontime;

drop table if exists lab_motion_trail;

/*==============================================================*/
/* Table: lab_bluetooth_dev                                         */
/*==============================================================*/
create table lab_bluetooth_dev
(
   dev_id         		int not null auto_increment comment 'ID',
   dev_number     		int comment '�������',
   uuid					char(32) comment 'uuid',
   major				int	comment 'major',
   minor				int comment 'minor',
   manufactor           char(200) comment '����',
   dev_type				char(50) comment '�ͺ�',
   status               int comment '״̬ 1���� 0������',
   position_id          int	comment 'λ�ñ��',
   create_date          date comment '����ʱ��',
   edit_date            date comment '�޸�ʱ��',
   del                  int comment 'ɾ����ʶ',
   primary key (bluetooth_id)
);

alter table lab_bluetooth_dev comment '�����豸';

/*==============================================================*/
/* Table: lab_check_work                                        */
/*==============================================================*/
create table lab_check_work
(
   check_id             int not null auto_increment comment '����id',
   class_id             int comment '�༶id',
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
/* Table: lab_college                                             */
/*==============================================================*/
create table lab_college
(
   college_id           int not null auto_increment comment 'ѧԺid',
   college_name         char(50) not null comment 'ѧԺ����',
   short_name			char(30) comment 'ѧԺ���',
   primary key (college_id)
);

alter table lab_college comment 'ѧԺ';


/*==============================================================*/
/* Table: lab_department                                             */
/*==============================================================*/
create table lab_department
(
   department_id            int not null auto_increment comment 'ϵid',
   department_name          char(50) not null comment 'ϵ����',
   short_name				char(30) comment 'ϵ���',
   college_id				int not null comment 'ѧԺid',
   primary key (department_id)
);

alter table lab_department comment 'ϵ';

/*==============================================================*/
/* Table: lab_subject                                             */
/*==============================================================*/
create table lab_subject
(
   subject_id            	int not null auto_increment comment 'רҵid',
   subject_name          	char(50) not null comment 'רҵ����',
   short_name				char(30) comment 'רҵ���',
   college_id				int not null comment 'ѧԺid',
   department_id			int not null comment 'ϵid',
   primary key (subject_id)
);

alter table lab_subject comment 'רҵ';

/*==============================================================*/
/* Table: lab_class                                             */
/*==============================================================*/
create table lab_class
(
   class_id             int not null auto_increment comment '�༶id',
   calss_name           char(50) not null comment '�༶����',
   college_id           int not null comment 'Ժid',
   department_id        int not null comment 'ϵid',
   subject_id           int not null comment 'רҵ',
   headmaster           int comment '������',
   instructor           int comment '����Ա',
   grade	            int not null comment '��',
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
   course_list_id       int not null auto_increment comment '�γ̱�ID',
   term                 int not null comment 'ѧ��',
   start_week           int not null comment '��ʼʱ�䣨�ܣ�',
   end_week             int not null comment '����ʱ�䣨�ܣ�',
   weekday              int not null comment '�ܼ�',
   section              int not null comment '�������ڼ��ڣ�',
   curriculum_id        int comment '�γ�id',
   train_lesson_id		int comment 'ʵѵ��id',
   lab_lesson_id		int comment 'ʵ���id',
   exam_id				int comment '����id',
   class_id             int not null comment '�༶id',
   position_id          int comment 'λ��ID',
   course_type          int not null comment '���� 1.��ѧ 2.ʵѵ 3.ʵ�� 4.����',
   exact_begin_time		date comment '��ʼʱ�� (����)',
   exact_end_time		date comment '����ʱ�� (����)',
   
   create_date          date comment '����ʱ��',
   edit_date            date comment '�޸�ʱ��',
   del                  int comment 'ɾ����ʶ',
   primary key (course_list_id)
);

alter table lab_course_list comment '�γ̱�';

/*==============================================================*/
/* Table: lab_curriculum                                   */
/*==============================================================*/
create table lab_curriculum
(
   curriculum_id        int not null auto_increment comment '�γ�id',
   curriculum_name      char(100) comment '�γ�����',
   teacher_id           int comment '�ο���ʦid',
   start_week           int comment '��ʼʱ�䣨�ܣ�',
   end_week             int comment '����ʱ�䣨�ܣ�',
   college_id           int comment 'ѧԺid',
   department_id        int comment 'ϵid',
   term_id             int comment 'ѧ��id',
   grade                int comment '��',
   create_date          date comment '����ʱ��',
   edit_date            date comment '�޸�ʱ��',
   del                  int comment 'ɾ����ʶ',
   primary key (curriculum_id)
);

alter table lab_curriculum comment '�γ�����';

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
   place		        char(100) comment '����',
   serial_number        char(20) comment '���',
   position_type        int comment 'λ������ 1.�̶� 2.�',
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
   duty                 int comment 'ְλ',
   email                char comment 'Email',
   subject_id           int comment 'רҵid',
   class_id             int comment '�༶id',
   department_id        int comment 'ϵID',
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
   college_id           int comment 'ѧԺid',
   department_id        char comment 'ϵid',
   head_image           char comment 'ͷ��',
   role                 int comment '��ɫ ������ ����Ա �ڿ���ʦ',
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
   term_id             int not null auto_increment comment 'ѧ��ID',
   term_name			char(30) comment 'ѧ����',
   start_date           date comment '��ʼʱ��',
   end_date             date comment '����ʱ��',
   create_date          date comment '����ʱ��',
   edite_date           date comment '�޸�ʱ��',
   del                  int comment 'ɾ����ʶ',
   primary key (term_id)
);

alter table lab_term comment 'ѧ�ڱ�';

/*==============================================================*/
/* Table: lab_lessontime                                              */
/*==============================================================*/
create table lab_lessontime
(
   id                   int not null auto_increment comment 'id',
   serial_section       int comment '��������',
   term_id              int comment 'ѧ��',
   start_date           date comment '��ʼʱ��',
   end_date             date comment '����ʱ��',
   create_date          date comment '����ʱ��',
   edit_date            date comment '�޸�ʱ��',
   del                  int comment 'ɾ����ʶ',
   primary key (id)
);

alter table lab_lessontime comment '�Ͽ�ʱ���';

/*==============================================================*/
/* Table: lab_motion_trail                                        */
/*==============================================================*/
create table lab_motion_trail
(
   trail_id        		int not null auto_increment comment 'id',
   student_id           int comment 'ѧ��id',
   position_id          int comment 'λ��',
   residence_time		int comment '����ʱ�䣨���ӣ�',
   start_time           date comment '��ʼʱ��',
   leave_time			date comment '�뿪ʱ��',
   primary key (trail_id)
);

alter table lab_motion_trail comment '��켣��';

alter table lab_bluetooth add constraint FK_Reference_7 foreign key (position_id)
      references lab_position (position_id) on delete restrict on update restrict;

alter table lab_course_list add constraint FK_Reference_1 foreign key (curriculum_id)
      references lab_curriculum (curriculum_id) on delete restrict on update restrict;

alter table lab_course_list add constraint FK_Reference_2 foreign key (position_id)
      references lab_position (position_id) on delete restrict on update restrict;

alter table lab_course_list add constraint FK_Reference_3 foreign key (class_id)
      references lab_class (class_id) on delete restrict on update restrict;

alter table lab_status_course add constraint FK_Reference_4 foreign key (curriculum_id)
      references lab_curriculum (curriculum_id) on delete restrict on update restrict;

alter table lab_status_course add constraint FK_Reference_5 foreign key (position_id)
      references lab_position (position_id) on delete restrict on update restrict;

alter table lab_status_course add constraint FK_Reference_6 foreign key (class_id)
      references lab_class (class_id) on delete restrict on update restrict;

