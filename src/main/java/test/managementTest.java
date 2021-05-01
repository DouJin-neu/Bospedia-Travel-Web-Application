package test;

import com.djin.pojo.Ticket;
import com.djin.service.ManagementService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


public class managementTest {

    @Autowired
    ManagementService managementService;

    @Test
    public void filter(){

        String id = "1";
        List<Ticket> list = managementService.idFilter(id);
        System.out.println(list.get(0));
    }
}
