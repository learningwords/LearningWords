package es.jesus.learningwords.service;


import es.jesus.learningwords.Application;
import es.jesus.learningwords.shared.vo.WordTypeVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * Created by jesus on 15/09/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class WordServiceTest {

    @Autowired
    private WordService wordService;

    @Test
    public void test() {
        List<WordTypeVO> types = wordService.listWordTypes();
        List<String> codes = types.stream().map(WordTypeVO::getCode).collect(Collectors.toList());
        assertFalse(types.isEmpty());
        assertTrue(codes.contains("SM"));
        assertTrue(codes.contains("PV"));
        assertTrue(codes.contains("FE"));
        assertTrue(codes.contains("OT"));
    }

}