package com.vadym.test.test;

import com.vadym.test.model.GroupData;
import com.vadym.test.model.Groups;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupModificationTest extends TestBase {
    @BeforeMethod
    public void ensurePrecondishions() {
        app.goTo().groupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new GroupData().withName("test1"));
        }
    }

    @Test
    public void testGroupModification() {

        Groups before = app.group().all();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData().withId(modifiedGroup.getId())
                .withName("test1").withHeader("test2").withFooter("test3");
        app.group().modify(group);
        Assert.assertEquals(app.group().count(), before.size());
        Groups after = app.group().all();

        assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));

    }


}
