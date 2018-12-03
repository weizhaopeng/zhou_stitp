package com.example.root.test1.page.project;

/*
 *"create table topic ("
                    +"topic_id integer primary key autoincrement, "
                    +"topic_name text not null, "
                    +"topic_guidence_id integer, "
                    +"topic_researcher1 integer, "
                    +"topic_researcher2 integer, "
                    +"topic_researcher3 integer, "
                    +"topic_researchers_other integer,"
                    +"topic_researchers_state integer default 0, "
                    +"topic_state integer, "
                    +"topic_is_full integer, "
                    +"topic_delete_state,"
                    +"topic_delete_date date);";
 */
public class Topic {
    public String topicId, topicName, topicTeacher, topicResearcher[],
            topicResearcherState, topicCategory, topicTechNeed;
    public int topicState, topicStudentNeed;
    public boolean topicIsFull, topicDeleteState;
}
