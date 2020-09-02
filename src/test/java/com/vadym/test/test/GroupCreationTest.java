package com.vadym.test.test;

import com.vadym.test.model.GroupData;
import com.vadym.test.model.Groups;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

public class GroupCreationTest extends TestBase {

    @Test
    public void groupCreationTest() {
        app.goTo().groupPage();
        Groups before = app.group().all();
        GroupData group = new GroupData().withName("test2");
        app.group().create(group);
        Groups after = app.group().all();
        assertThat(after.size(),equalTo(before.size() + 1));


        assertThat(after, equalTo(before.withAdded
                (group.withId(after.stream().mapToInt(GroupData::getId).max().getAsInt()))));

    }

}
