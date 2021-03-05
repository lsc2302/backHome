package com.lsc.backhome;

import com.lsc.backhome.model.dto.CommentDTO;
import com.lsc.backhome.model.entity.RegisteredUser;
import com.lsc.backhome.service.impl.CommentServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BackhomeApplication.class)

public class commentServiceTest {
    @Autowired
    private CommentServiceImpl commentServiceImpl;

    @Test
    public void test1() {
        System.out.println(commentServiceImpl.getCommentsBySiteID(1));
    }

    @Test
    public void test2() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse("2021-01-13 17:40:17");
        commentServiceImpl.create(new CommentDTO(1,"Bad service", 2),
                new RegisteredUser("1349290158897311745","admin","$2a$10$8qx711TBg/2hxfL7N.sxf.0ROMhR/iuPhQx33IFqGd7PLgt5nGJTO",
                        "https://s3.ax1x.com/2020/12/01/DfHNo4.jpg","",date));
    }
}

